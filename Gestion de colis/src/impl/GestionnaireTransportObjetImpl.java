package impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import utils.EtatOffreTransport;
import utils.OffreTransport;
import utils.RandomStr;
import OperateurDeTransportObjet.CoordBancairePro;
import OperateurDeTransportObjet.EtatObjet;
import OperateurDeTransportObjet.GestionUtilisateurs;
import OperateurDeTransportObjet.GestionnairePaiement;
import OperateurDeTransportObjet.GestionnaireTransportObjetPOA;
import OperateurDeTransportObjet.InfoObjet;
import OperateurDeTransportObjet.Objet;
import OperateurDeTransportObjet.Station;
import OperateurDeTransportObjet.Transporteur;
import OperateurDeTransportObjet.GestionnaireTransportObjetPackage.DemandeInscriptionTrans;
import OperateurDeTransportObjet.GestionnaireTransportObjetPackage.InscriptionTrans;
import OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ObjetInexistantException;
import OperateurDeTransportObjet.GestionnaireTransportObjetPackage.TransExistantException;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import exception.GestionnairePaiementPasEnServiceException;
import exception.StationPasEnServiceException;

public class GestionnaireTransportObjetImpl extends GestionnaireTransportObjetPOA {

	private GestionUtilisateurs gestionnaireUtilisateurs;
	private GestionnairePaiement gestionnairePaiement;

	//Contient l'ensemble des liens vers les transporteurs connect�s
	private Map<Integer, Transporteur> mapNumeroTransporteursConnectes;

	//Contient l'ensemble des transporteurs inscrits
	private Map <Integer, InscriptionTrans> mapTransporteur;

	//Contient les offres de transport associ�es � leur code de transport
	private Map <String, OffreTransport> mapCodeTransportOffre;

	//Contient pour chaque num�ro d'adh�rent l'ensemble des idObjet qui lui sont li�s (exp�di�s et destin�s)
	private Multimap<Integer, String> multiMapNumAdherentIdObjet;

	//Contient pour chaque idObjet l'objet correspondant
	private Map<String, Objet> mapIdObjetObjet;

	//Contient pour chaque num�ro de transporteur l'ensemble des codes de transport qui lui sont li�s
	private Multimap<Integer, String> multimapNumTransCodeTrans;
	
	//Contient l'ensemble des couples num�ro d'offre / code transport
	private Map <String, String> mapNumOffreCodeTransport;
	
	//Contient pour chaque idObjet le transporteur qui l'a pris en charge.
	private Map <String, Integer> mapIdObjetNumTransporteur;

	private String args[];


	public GestionnaireTransportObjetImpl (String args[], GestionUtilisateurs gestionnaireUtilisateurs) {

		this.args = args;
		this.gestionnaireUtilisateurs = gestionnaireUtilisateurs;
		
		multiMapNumAdherentIdObjet = ArrayListMultimap.create();
		mapIdObjetObjet = new HashMap<>();

		mapTransporteur = new HashMap<Integer, InscriptionTrans>();
		mapTransporteur.put(1, new InscriptionTrans(1, "Mory", new CoordBancairePro(1311, 07145, 12123651, 95)));	
		mapTransporteur.put(2, new InscriptionTrans(2, "Ducros", new CoordBancairePro(1512, 04045, 1274741, 98)));
		
		mapNumeroTransporteursConnectes = new HashMap<>();
		mapCodeTransportOffre = new HashMap<>();
		multimapNumTransCodeTrans = ArrayListMultimap.create();
		mapNumOffreCodeTransport = new HashMap<>();
		mapIdObjetNumTransporteur = new HashMap<>();
	}


	/**
	 * Notifie le gestionnaire de transport qu'un colis doit �tre transport� d'une station � une autre
	 */
	@Override
	public String notifierOffreTransport(String idObjet, String nomStationDepart,
			String nomStationArrivee) {

		String codeTransport = genererCodeTransport();
		String numeroOffre = genererNumeroOffre();
		mapNumOffreCodeTransport.put(numeroOffre, codeTransport);
		mapCodeTransportOffre.put(codeTransport, new OffreTransport(numeroOffre, idObjet, nomStationDepart, nomStationArrivee, EtatOffreTransport.aPrendreEnCharge));

		//notifier tous les transporteurs
		for (Transporteur transporteur : mapNumeroTransporteursConnectes.values()) {

			transporteur.notifierOffreTransport(nomStationDepart, nomStationArrivee, numeroOffre);
		}

		return codeTransport;
	}

	/**
	 * Notifie le gestionnaire de transport qu'un transporteur a accept� une offre de transport publi�e
	 */
	@Override
	public String notifierOffreAcceptee(int numeroTransporteur,
			String numeroOffre) {

		String codeTransport = mapNumOffreCodeTransport.get(numeroOffre);

		OffreTransport offreTransport = mapCodeTransportOffre.get(codeTransport);
		mapIdObjetNumTransporteur.put(offreTransport.getIdObjet(), numeroTransporteur);
		
		if (offreTransport.getEtatOffreTransport() == EtatOffreTransport.aPrendreEnCharge) {

			offreTransport.setEtatOffreTransport(EtatOffreTransport.priseEnCharge);

			//r�cup�re les numero de transporteur connect�s
			Set<Integer> numerosTransporteurConnectes = new HashSet<>(mapNumeroTransporteursConnectes.keySet());
			//enl�ve le numero de transporteur qui vient d'accepter l'offre
			numerosTransporteurConnectes.remove(numeroTransporteur);
			
			for (Integer numTransCo : numerosTransporteurConnectes) {
				
				mapNumeroTransporteursConnectes.get(numTransCo).notifierOffrePriseEnCharge(numeroOffre);
			}
			
			Station stationDestinataire = getStationDestinataireViaNamingService(offreTransport.getNomStationArrivee());
			stationDestinataire.notifierNumTransporteurObjet(numeroTransporteur, offreTransport.getIdObjet());
			
			multimapNumTransCodeTrans.put(numeroTransporteur, codeTransport);
			//on enl�ve l'offre vu qu'elle vient d'�tre accept�e
			mapNumOffreCodeTransport.remove(numeroOffre);

			return codeTransport;
		}
		else {

			//L'offre de transport a d�j� �t� accept�e par un autre transporteur
			return null;
		}
	}

	/**
	 * V�rifier qu'une transporteur est associ� � un code de transport
	 */
	@Override
	public boolean verifierTransporteur(int numeroTransporteur,
			String codeTransport) {

		boolean transporteurOK = true;
		Collection<String> codesTransport = multimapNumTransCodeTrans.get(numeroTransporteur);

		if (codesTransport.isEmpty()) {

			transporteurOK = false;
		}

		return transporteurOK;
	}

	/**
	 * Permet de consulter l'ensemble des �tats des objets qui concernent un adh�rent
	 */
	@Override
	public InfoObjet[] consulterEtatObjet(int numeroAdherent) {

		Collection<String> idObjets = multiMapNumAdherentIdObjet.get(numeroAdherent);
		List<InfoObjet> infosObjets = new ArrayList<>();
		for(String idObjet : idObjets) {

			infosObjets.add(new InfoObjet(idObjet, mapIdObjetObjet.get(idObjet).etatObjet));
		}

		return (infosObjets.toArray(new InfoObjet[]{}));
	}

	/**
	 * G�n�re un code de transport unique al�atoire
	 * @return
	 */
	private String genererCodeTransport() {

		RandomStr rand = new RandomStr();

		return rand.get(5);
	}

	/**
	 * G�n�re un numero d'offre unique al�atoire
	 * @return
	 */
	private String genererNumeroOffre() {

		RandomStr rand = new RandomStr();

		return rand.get(6);
	}

	/**
	 * Notifie le gestionnaire de transport de la connexion d'un transporteur
	 */
	@Override
	public void notifierConnexion(int numeroTransporteur, Transporteur transporteur) { //r�gler cas reconnexion => toujours � A PRENDRE EN CHARGe

		mapNumeroTransporteursConnectes.put(numeroTransporteur, transporteur);	

		for(OffreTransport offre : mapCodeTransportOffre.values()) {

			transporteur.notifierOffreTransport(offre.getNomStationDepart(), offre.getNomStationArrivee(), offre.getNumeroOffre());
		}
	}
	
	/**
	 * Notifie le gestionnaire de transport de la deconnexion d'un transporteur
	 */
	@Override
	public void notifierDeconnexion(int numeroTransporteur) {
		// TODO Auto-generated method stub
		mapNumeroTransporteursConnectes.remove(numeroTransporteur);
	}

	/**
	 * Notifier le gestionnaire de transport d'un changement d'�tat pour un objet suite � un mouvement de transporteur
	 */
	@Override
	public void notifierEtatObjet(String idObjet, EtatObjet etatObjet)
			throws ObjetInexistantException {


		Objet objet = mapIdObjetObjet.get(idObjet);
		if (objet != null) {
			objet.etatObjet = etatObjet;

			if(etatObjet == EtatObjet.livre) {
				//Cas sp�cial dans lequel on notifie le destinataire que l'objet est arriv�
				alerterDestinataire(objet.numDestinataire, idObjet);
				
				//Cr�diter transporteur
				int numTransporteur = mapIdObjetNumTransporteur.get(idObjet);
				Transporteur transporterADebiter = mapNumeroTransporteursConnectes.get(numTransporteur);
				if (gestionnairePaiement == null) {
					
					try {
						gestionnairePaiement = getGestionnairePaiementViaNamingService();
					} catch (GestionnairePaiementPasEnServiceException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				OffreTransport offre = null;
				for (OffreTransport offreTemp : mapCodeTransportOffre.values()) {
					
					if (offreTemp.getIdObjet().equals(idObjet)) {
						
						offre = offreTemp;
					}
				}
				String stationDepart = offre.getNomStationDepart();
				String stationArrivee = offre.getNomStationArrivee();
				double montantCredit = gestionnairePaiement.crediter(mapTransporteur.get(numTransporteur).coordonneesBancairesPro, stationDepart, stationArrivee);
			
				transporterADebiter.notifierCreditTransport(montantCredit, offre.getNumeroOffre());
			}
		}
		else {
			throw new ObjetInexistantException("L'objet notifi� n'existe pas.");
		}
	}

	private GestionnairePaiement getGestionnairePaiementViaNamingService() throws GestionnairePaiementPasEnServiceException {
		
		OperateurDeTransportObjet.GestionnairePaiement gestionnairePaiementDistant = null;

		// Intialisation de l'orb
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

		// Saisie du nom de l'objet (si utilisation du service de nommage)
		System.out.println("Quel objet Corba voulez-vous contacter ?");
		String idObj = "GPaiement";

		// Recuperation du naming service
		org.omg.CosNaming.NamingContext nameRoot;
		try {
			nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

			// Construction du nom a rechercher
			org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
			nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj,"");

			// Recherche aupres du naming service
			org.omg.CORBA.Object gestionnairePaiementDestinataire = nameRoot.resolve(nameToFind);
			System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
			System.out.println(orb.object_to_string(gestionnairePaiementDestinataire));			

			gestionnairePaiementDistant = OperateurDeTransportObjet.GestionnairePaiementHelper.narrow(gestionnairePaiementDestinataire);

		} catch (Exception e) {
			throw new GestionnairePaiementPasEnServiceException();
		} 

		return gestionnairePaiementDistant;
	}

	/**
	 * Enregistre un nouvel objet aupr�s du gestionnaire de transport. Action r�alis�e lors du d�p�t initial d'un colis
	 */
	@Override
	public void enregistrerObjet(Objet objet) {

		multiMapNumAdherentIdObjet.put(objet.numExpediteur, objet.idObjet);
		multiMapNumAdherentIdObjet.put(objet.numDestinataire, objet.idObjet);

		mapIdObjetObjet.put(objet.idObjet, objet);
	}

	public void alerterDestinataire(int numeroAdherentDestinataire, String idObjet) {

		gestionnaireUtilisateurs.notifierColisArrive(numeroAdherentDestinataire, idObjet);
	}

	/** 
	 * Permet � un trnasporteur de s'inscrire aupr�s du gestionnaire de transport
	 */
	@Override
	public InscriptionTrans demandeInscriptionTrans(DemandeInscriptionTrans demandeInscriptionTrans) 
			throws TransExistantException {

		//v�rifier existance transporteur
		boolean isNouveauTransporteur = verifierTransporteurExistant(demandeInscriptionTrans);

		if (isNouveauTransporteur) {
			//Si nouveau transporteur alors retourner information d'inscription
			InscriptionTrans inscription = new InscriptionTrans(genererNumeroTransporteur(), demandeInscriptionTrans.nomTransporteur, demandeInscriptionTrans.coordonneesBancairesPro);
			return inscription;

		} else {
			//sinon lever exception
			throw new TransExistantException("Un transporteur avec ces informations existe d�j�. Inscription impossible.");
		}
	}

	/**
	 * V�rifie l'existance d'un transporteur
	 */
	private boolean verifierTransporteurExistant (DemandeInscriptionTrans demandeInscription) {

		boolean isNouveauTransporteur = true;
		String nomTransporteur = demandeInscription.nomTransporteur;
		for (InscriptionTrans tempInscription : mapTransporteur.values()) {
			if (tempInscription.nomTransporteur.equals(nomTransporteur)) {	
				isNouveauTransporteur = false;
				break;
			}
			break;
		}
		return isNouveauTransporteur;
	}
	

	/**
	 * G�n�re un nouveau num�ro de transporteur
	 */
	private int genererNumeroTransporteur () {

		return mapTransporteur.size() + 1;
	}
	
	/**
	 * R�cup�re la r�f�rence d'une station destinatrice � partir de son nom
	 * @param nomStation
	 * @return
	 */
	private Station getStationDestinataireViaNamingService (String nomStation) {

		OperateurDeTransportObjet.Station maStationDistante = null;

		// Intialisation de l'orb
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);

		// Saisie du nom de l'objet (si utilisation du service de nommage)
		System.out.println("Quel objet Corba voulez-vous contacter ?");
		String idObj = nomStation;

		// Recuperation du naming service
		org.omg.CosNaming.NamingContext nameRoot;
		try {
			nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

			// Construction du nom a rechercher
			org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
			nameToFind[0] = new org.omg.CosNaming.NameComponent(idObj,"");

			// Recherche aupres du naming service
			org.omg.CORBA.Object stationDestinataire = nameRoot.resolve(nameToFind);
			System.out.println("Objet '" + idObj + "' trouve aupres du service de noms. IOR de l'objet :");
			System.out.println(orb.object_to_string(stationDestinataire));			

			maStationDistante = OperateurDeTransportObjet.StationHelper.narrow(stationDestinataire);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return maStationDistante;
	}
}
