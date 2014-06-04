package impl;
import java.util.HashMap;
import java.util.List;

import utils.RandomStr;
import OperateurDeTransportObjet.GestionUtilisateursPOA;
import OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentExistantException;
import OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentInexistantException;
import OperateurDeTransportObjet.GestionUtilisateursPackage.Adhesion;
import OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeAdhesion;
import OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeInscriptionTrans;
import OperateurDeTransportObjet.GestionUtilisateursPackage.InscriptionTrans;
import OperateurDeTransportObjet.GestionUtilisateursPackage.TransExistantException;

import com.google.common.primitives.Ints;

public class GestionUtilisateursImpl extends GestionUtilisateursPOA {

	private HashMap <Integer, Adhesion> mapAdherent;
	private HashMap <Integer, InscriptionTrans> mapTransporteur;
	private HashMap <Integer, List<Integer>> mapRegionZones;

	public GestionUtilisateursImpl () {

		mapAdherent = new HashMap<Integer, Adhesion>();
		mapAdherent.put(1, new Adhesion(1, "toto", "Ponchel", "Igor", 05));

		mapTransporteur = new HashMap<Integer, InscriptionTrans>();
		mapTransporteur.put(1, new InscriptionTrans(1, "Mory"));	

		List <Integer> zones01 = Ints.asList(75, 77, 78, 91, 92, 93, 94, 95);
		List <Integer> zones02 = Ints.asList(14, 18, 22, 27, 28, 29, 35, 36, 37, 41, 44, 45, 49, 50, 53, 56, 61, 72, 76, 85);
		List <Integer> zones03 = Ints.asList(2, 8, 10, 21, 25, 39, 51, 52, 54, 55, 57, 58, 59, 60, 62, 67, 68, 70, 71, 80, 88, 89, 90);
		List <Integer> zones04 = Ints.asList(1, 3, 4, 5, 6, 7, 11, 13, 15, 26, 30, 34, 38, 42, 43, 48, 63, 66, 69, 73, 74, 83, 84);	
		List <Integer> zones05 = Ints.asList(9, 12, 16, 17, 19, 23, 24, 31, 32, 33, 40, 46, 47, 64, 65, 49, 81, 82, 86, 87);		
		
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
			break;
		}
		
		if (zoneAdherent != 0) {
			return zoneAdherent;
		} 
		else {
			throw new AdherentInexistantException("L'adhérent n'existe pas.");
		}
	}
}
