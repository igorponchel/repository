package impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.EtatOffreTransport;
import utils.OffreTransport;
import utils.RandomStr;
import OperateurDeTransportObjet.Adherent;
import OperateurDeTransportObjet.EtatObjet;
import OperateurDeTransportObjet.GestionUtilisateurs;
import OperateurDeTransportObjet.GestionnaireTransportObjetPOA;
import OperateurDeTransportObjet.InfoObjet;
import OperateurDeTransportObjet.Objet;
import OperateurDeTransportObjet.Transporteur;
import OperateurDeTransportObjet.GestionnaireTransportObjetPackage.DemandeInscriptionTrans;
import OperateurDeTransportObjet.GestionnaireTransportObjetPackage.InscriptionTrans;
import OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ObjetInexistantException;
import OperateurDeTransportObjet.GestionnaireTransportObjetPackage.TransExistantException;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class GestionnaireTransportObjetImpl extends GestionnaireTransportObjetPOA {

	private GestionUtilisateurs gestionnaireUtilisateurs;

	//Contient l'ensemble des liens vers les transporteurs connect�s
	private Map<Integer, Transporteur> mapNumeroTransporteursConnectes;

	//Contient l'ensemble des transporteurs inscrits
	private Map <Integer, InscriptionTrans> mapTransporteur;

	//Contient les offres de transport associ�es � leur code de transport
	private Map <String, OffreTransport> mapCodeTransportOffre;

	private Multimap<Integer, String> multiMapNumAdherentIdObjet;

	private Map<String, Objet> mapIdObjetObjet;



	private Map <Integer, String> mapNumeroNomTransporteurs;
	private Multimap<Integer, String> multimapNumTransCodeTrans;
	private Map <String, EtatObjet> mapObjetEtat;
	private Map <String, String> mapNumOffreCodeTransport;

	private String args[];


	public GestionnaireTransportObjetImpl (String args[], GestionUtilisateurs gestionnaireUtilisateurs) {

		this.args = args;
		this.gestionnaireUtilisateurs = gestionnaireUtilisateurs;

		mapTransporteur = new HashMap<Integer, InscriptionTrans>();
		mapTransporteur.put(1, new InscriptionTrans(1, "Mory"));	
		
		mapNumeroNomTransporteurs = new HashMap<>();
		mapNumeroTransporteursConnectes = new HashMap<>();
		mapCodeTransportOffre = new HashMap<>();
		multimapNumTransCodeTrans = ArrayListMultimap.create();
		mapObjetEtat = new HashMap<>();
		mapNumOffreCodeTransport = new HashMap<>();
	}


	@Override
	public String notifierOffreTransport(String nomStationDepart,
			String nomStationArrivee) {

		String codeTransport = genererCodeTransport();
		String numeroOffre = genererNumeroOffre();
		mapNumOffreCodeTransport.put(numeroOffre, codeTransport);
		mapCodeTransportOffre.put(codeTransport, new OffreTransport(numeroOffre, nomStationDepart, nomStationArrivee, EtatOffreTransport.aPrendreEnCharge));

		//notifier tous les transporteurs
		for (Transporteur transporteur : mapNumeroTransporteursConnectes.values()) {

			transporteur.notifierOffreTransport(nomStationDepart, nomStationArrivee, numeroOffre);
		}


		return codeTransport;
	}

	@Override
	public String notifierOffreAcceptee(int numeroTransporteur,
			String numeroOffre) {

		String codeTransport = mapNumOffreCodeTransport.get(numeroOffre);

		if (mapCodeTransportOffre.get(codeTransport).getEtatOffreTransport() == EtatOffreTransport.aPrendreEnCharge) {

			mapCodeTransportOffre.get(codeTransport).setEtatOffreTransport(EtatOffreTransport.priseEnCharge);

			//notifier tous les transporteurs (m�me celui qui a pris en charge l'offre => confirmation)
			for (Transporteur transporteur : mapNumeroTransporteursConnectes.values()) {

				transporteur.notifierOffrePriseEnCharge(codeTransport);
			}

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


	@Override
	public InfoObjet[] consulterEtatObjet(int numeroAdherent)
			throws ObjetInexistantException {

		Collection<String> idObjets = multiMapNumAdherentIdObjet.get(numeroAdherent);
		List<InfoObjet> infosObjets = new ArrayList<>();
		for(String idObjet : idObjets) {

			infosObjets.add(new InfoObjet(idObjet, mapIdObjetObjet.get(idObjet).etatObjet));
		}

		if (!infosObjets.isEmpty()) {

			return (InfoObjet[])infosObjets.toArray();
		}
		else {
			throw new ObjetInexistantException("Aucun objet correspondant.");
		}
	}

	private String genererCodeTransport() {

		RandomStr rand = new RandomStr();

		return rand.get(5);
	}

	private String genererNumeroOffre() {

		RandomStr rand = new RandomStr();

		return rand.get(6);
	}

	@Override
	public void notifierConnexion(int numeroTransporteur, Transporteur transporteur) {

		mapNumeroTransporteursConnectes.put(numeroTransporteur, transporteur);	

		for(OffreTransport offre : mapCodeTransportOffre.values()) {

			transporteur.notifierOffreTransport(offre.getNomStationDepart(), offre.getNomStationArrivee(), offre.getNumeroOffre());
		}
	}

	@Override
	public void notifierDeconnexion(int numeroTransporteur) {
		// TODO Auto-generated method stub
		mapNumeroTransporteursConnectes.remove(numeroTransporteur);
	}


	@Override
	public void notifierEtatObjet(String idObjet, EtatObjet etatObjet)
			throws ObjetInexistantException {


		Objet objet = mapIdObjetObjet.get(idObjet);
		if (objet != null) {
			objet.etatObjet = etatObjet;

			if(etatObjet == EtatObjet.delivre) {

				alerterDestinataire(objet.numDestinataire, idObjet);
			}
		}
		else {
			throw new ObjetInexistantException("L'objet notifi� n'existe pas.");
		}

	}


	@Override
	public void enregistrerObjet(Objet objet) {

		multiMapNumAdherentIdObjet.put(objet.numExpediteur, objet.idObjet);
		multiMapNumAdherentIdObjet.put(objet.numDestinataire, objet.idObjet);

		mapIdObjetObjet.put(objet.idObjet, objet);
	}

	public void alerterDestinataire(int numeroAdherentDestinataire, String idObjet) {

		Adherent adherent = gestionnaireUtilisateurs.getAdherentSiConnecte(numeroAdherentDestinataire);

		adherent.notifierColisArrive(idObjet);
	}

	@Override
	public InscriptionTrans demandeInscriptionTrans(DemandeInscriptionTrans demandeInscriptionTrans) 
			throws TransExistantException {

		//v�rifier existance transporteur
		boolean isNouveauTransporteur = verifierTransporteurExistant(demandeInscriptionTrans);

		if (isNouveauTransporteur) {
			//Si nouveau transporteur alors retourner information d'inscription
			InscriptionTrans inscription = new InscriptionTrans(genererNumeroTransporteur(), demandeInscriptionTrans.nomTransporteur);
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
}
