package impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

import utils.RandomStr;
import OperateurDeTransportObjet.GestionUtilisateursPOA;
import OperateurDeTransportObjet.GestionnaireTransportObjet;
import OperateurDeTransportObjet.Transporteur;
import OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentExistantException;
import OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentInexistantException;
import OperateurDeTransportObjet.GestionUtilisateursPackage.Adhesion;
import OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeAdhesion;
import OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeInscriptionTrans;
import OperateurDeTransportObjet.GestionUtilisateursPackage.InscriptionTrans;
import OperateurDeTransportObjet.GestionUtilisateursPackage.TransExistantException;

import com.google.common.collect.Lists;

public class GestionUtilisateursImpl extends GestionUtilisateursPOA {

	private GestionnaireTransportObjet gestionnaireTransportObjet;

	//Contient l'ensemble des liens vers les transporteurs connectés
	private Map<Integer, Transporteur> mapNumeroTransporteursConnectes;

	private Map <Integer, Adhesion> mapAdherent;

	//Contient l'ensemble des transporteurs inscrits
	private Map <Integer, InscriptionTrans> mapTransporteur;
	private Map <Integer, List<Integer>> mapRegionZones;

	public GestionUtilisateursImpl (String args[]) {

		recupererGestionnaireTransportObjet(args);

		mapNumeroTransporteursConnectes = new HashMap<>();
		
		mapAdherent = new HashMap<>();
		mapAdherent.put(1, new Adhesion(1, "toto", "Ponchel", "Igor", 31));
		mapAdherent.put(2, new Adhesion(2, "toto", "Baadoud", "Kader", 32));

		mapTransporteur = new HashMap<Integer, InscriptionTrans>();
		mapTransporteur.put(1, new InscriptionTrans(1, "Mory"));	

		List <Integer> zones01 = Lists.newArrayList(75, 77, 78, 91, 92, 93, 94, 95);
		List <Integer> zones02 = Lists.newArrayList(14, 18, 22, 27, 28, 29, 35, 36, 37, 41, 44, 45, 49, 50, 53, 56, 61, 72, 76, 85);
		List <Integer> zones03 = Lists.newArrayList(2, 8, 10, 21, 25, 39, 51, 52, 54, 55, 57, 58, 59, 60, 62, 67, 68, 70, 71, 80, 88, 89, 90);
		List <Integer> zones04 = Lists.newArrayList(1, 3, 4, 5, 6, 7, 11, 13, 15, 26, 30, 34, 38, 42, 43, 48, 63, 66, 69, 73, 74, 83, 84);	
		List <Integer> zones05 = Lists.newArrayList(9, 12, 16, 17, 19, 23, 24, 31, 32, 33, 40, 46, 47, 64, 65, 49, 81, 82, 86, 87);		

		mapRegionZones = new HashMap<Integer, List<Integer>>();
		mapRegionZones.put(1, zones01);
		mapRegionZones.put(2, zones02);
		mapRegionZones.put(3, zones03);
		mapRegionZones.put(4, zones04);
		mapRegionZones.put(5, zones05);
	}

	@Override
	public Adhesion demandeAdhesion (DemandeAdhesion demandeAdhesion) throws AdherentExistantException {

		//vérifier existance adhérent
		boolean isNouvelAdherent = verifierAdherentExistant(demandeAdhesion);
		//débiter paiement

		if (isNouvelAdherent) {
			//Si nouvel adherent alors retourner information d'adhésion
			Adhesion adhesion = new Adhesion(genererNumeroAdherent(), genererMotDePasse(), demandeAdhesion.nomAdherent, demandeAdhesion.prenomAdherent, getZone(demandeAdhesion.adresseAdherent.departement));
			return adhesion;

		} else {
			//sinon lever exception
			throw new AdherentExistantException("Un adhérent avec ces informations existe déjà. Adhésion impossible.");
		}
	}

	/**
	 * Vérifie l'existance d'un adhérent
	 */
	private boolean verifierAdherentExistant (DemandeAdhesion demandeAdhesion) {

		boolean isNouvelAdherent = true;
		String prenomAdherent = demandeAdhesion.prenomAdherent;
		String nomAdherent = demandeAdhesion.nomAdherent;
		for (Adhesion tempAdhesion : mapAdherent.values()) {
			if (tempAdhesion.prenomAdherent.equals(prenomAdherent) && tempAdhesion.nomAdherent.equals(nomAdherent)) {	
				isNouvelAdherent = false;
				break;
			}
		}
		return isNouvelAdherent;
	}

	/**
	 * Génére un nouveau numéro d'adhérent
	 */
	private int genererNumeroAdherent () {

		return mapAdherent.size() + 1;
	}

	/**
	 * Génére un mot de passe aléatoire
	 */
	private String genererMotDePasse () {

		RandomStr rand = new RandomStr();

		return rand.get(6);
	}

	/**
	 * Calcule la zone correspondante au département de l'adhérent
	 */
	private int getZone (int departement) {

		for (int i = 1; i <= mapRegionZones.size(); i++) {

			if(mapRegionZones.get(i).contains(departement)) {

				return i;
			}
		}

		return -1;
		//		throw new Exception("Le département de l'adhérent n'est pas pris en charge. Seule la France métropolitaine est élligible.");
	}

	@Override
	public InscriptionTrans demandeInscriptionTrans(DemandeInscriptionTrans demandeInscriptionTrans) 
			throws TransExistantException {

		//vérifier existance transporteur
		boolean isNouveauTransporteur = verifierTransporteurExistant(demandeInscriptionTrans);
		//débiter paiement

		if (isNouveauTransporteur) {
			//Si nouvel adherent alors retourner information d'adhésion
			InscriptionTrans inscription = new InscriptionTrans(genererNumeroTransporteur(), demandeInscriptionTrans.nomTransporteur);
			return inscription;

		} else {
			//sinon lever exception
			throw new TransExistantException("Un transporteur avec ces informations existe déjà. Inscription impossible.");
		}

	}

	/**
	 * Vérifie l'existance d'un transporteur
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
	 * Génére un nouveau numéro de transporteur
	 */
	private int genererNumeroTransporteur () {

		return mapTransporteur.size() + 1;
	}


	@Override
	public boolean verifierTransporteur(short codeVerif) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getNumAdherent(String nomAdherent, String prenom)
			throws AdherentInexistantException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean verifierAdherent(int numeroAdherent, String motDePasse) {

		Adhesion adhesion = mapAdherent.get(numeroAdherent);
		if (adhesion != null) {
			return adhesion.motDePasse.equals(motDePasse);
		}

		return false;
	}

	@Override
	public int getZoneAdherent(String nomAdherent, String prenomAdherent)
			throws AdherentInexistantException {

		int zoneAdherent = 0;

		for (Adhesion tempAdhesion : mapAdherent.values()) {

			if(tempAdhesion.nomAdherent.equals(nomAdherent) && tempAdhesion.prenomAdherent.equals(prenomAdherent)) {

				zoneAdherent = tempAdhesion.zoneAdherent;
				break;
			}
		}

		if (zoneAdherent != 0) {
			return zoneAdherent;
		} 
		else {
			throw new AdherentInexistantException("L'adhérent n'existe pas.");
		}
	}

	@Override
	public void notifierConnexion(int numeroTransporteur, Transporteur transporteur) {

		mapNumeroTransporteursConnectes.put(numeroTransporteur, transporteur);
		gestionnaireTransportObjet.notifierConnexion(numeroTransporteur, transporteur);
	}

	@Override
	public void notifierDeconnexion(int numeroTransporteur) {

		mapNumeroTransporteursConnectes.remove(numeroTransporteur);
		gestionnaireTransportObjet.notifierDeconnexion(numeroTransporteur);
	}

	private void recupererGestionnaireTransportObjet(String args[]) {

		// Intialisation de l'ORB
		//************************
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

		// Gestion du POA
		//****************
		// Recuperation du POA
		try {
			POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));

			// Recuperation du naming service
			org.omg.CosNaming.NamingContext nameRoot =
					org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

			//********************* RECUPERATION DU SERVANT GESTIONNAIRE TRANSPORT OBJET
			// Saisie du nom de l'objet (si utilisation du service de nommage)
			System.out.println("Quel objet Corba voulez-vous contacter ?");

			String idObj2 = "GTransportObjet";

			// Construction du nom a rechercher
			org.omg.CosNaming.NameComponent[] nameToFind2 = new org.omg.CosNaming.NameComponent[1];
			nameToFind2[0] = new org.omg.CosNaming.NameComponent(idObj2,"");

			// Recherche aupres du naming service
			org.omg.CORBA.Object distantGestionTransportObjet = nameRoot.resolve(nameToFind2);
			System.out.println("Objet '" + idObj2 + "' trouve aupres du service de noms. IOR de l'objet :");
			System.out.println(orb.object_to_string(distantGestionTransportObjet));

			gestionnaireTransportObjet = OperateurDeTransportObjet.GestionnaireTransportObjetHelper.narrow(distantGestionTransportObjet);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
