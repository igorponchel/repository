package impl;
import java.util.HashMap;
import java.util.List;

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
	private HashMap <Integer, List<Integer>> mapZoneDepartements;

	public GestionUtilisateursImpl () {

		mapAdherent = new HashMap<Integer, Adhesion>();
		mapAdherent.put(1, new Adhesion(1, "Ponchel", "Igor", 05));

		mapTransporteur = new HashMap<Integer, InscriptionTrans>();
		mapTransporteur.put(1, new InscriptionTrans(1, "Mory"));	

		List <Integer> departements01 = Ints.asList(75, 77, 78, 91, 92, 93, 94, 95);
		List <Integer> departements02 = Ints.asList(14, 18, 22, 27, 28, 29, 35, 36, 37, 41, 44, 45, 49, 50, 53, 56, 61, 72, 76, 85);
		List <Integer> departements03 = Ints.asList(2, 8, 10, 21, 25, 39, 51, 52, 54, 55, 57, 58, 59, 60, 62, 67, 68, 70, 71, 80, 88, 89, 90);
		List <Integer> departements04 = Ints.asList(1, 3, 4, 5, 6, 7, 11, 13, 15, 26, 30, 34, 38, 42, 43, 48, 63, 66, 69, 73, 74, 83, 84);	
		List <Integer> departements05 = Ints.asList(9, 12, 16, 17, 19, 23, 24, 31, 32, 33, 40, 46, 47, 64, 65, 49, 81, 82, 86, 87);		
		mapZoneDepartements = new HashMap<Integer, List<Integer>>();
		mapZoneDepartements.put(1, departements01);
		mapZoneDepartements.put(2, departements02);
		mapZoneDepartements.put(3, departements03);
		mapZoneDepartements.put(4, departements04);
		mapZoneDepartements.put(5, departements05);
	}

	@Override
	public Adhesion demandeAdhesion (DemandeAdhesion demandeAdhesion) throws AdherentExistantException {

		//v�rifier existance adh�rent
		boolean isNouvelAdherent = verifierAdherentExistant(demandeAdhesion);
		//d�biter paiement

		if (isNouvelAdherent) {
			//Si nouvel adherent alors retourner information d'adh�sion
			Adhesion adhesion = new Adhesion(genererNumeroAdherent(), demandeAdhesion.nomAdherent, demandeAdhesion.prenomAdherent, getZone(demandeAdhesion.adresseAdherent.departement));
			return adhesion;

		} else {
			//sinon lever exception
			throw new AdherentExistantException("Un adh�rent avec ces informations existe d�j�. Adh�sion impossible.");
		}
	}

	/**
	 * V�rifie l'existance d'un adh�rent
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
	 * G�n�re un nouveau num�ro d'adh�rent
	 */
	private int genererNumeroAdherent () {

		return mapAdherent.size() + 1;
	}

	/**
	 * Calcule la zone correspondante au d�partement de l'adh�rent
	 */
	private int getZone (int departement) {

		for (int i = 1; i <= mapZoneDepartements.size(); i++) {

			if(mapZoneDepartements.get(i).contains(departement)) {

				return i;
			}
		}

		return -1;
		//		throw new Exception("Le d�partement de l'adh�rent n'est pas pris en charge. Seule la France m�tropolitaine est �lligible.");
	}

	@Override
	public InscriptionTrans demandeInscriptionTrans(DemandeInscriptionTrans demandeInscriptionTrans) 
			throws TransExistantException {

		//v�rifier existance transporteur
		boolean isNouveauTransporteur = verifierTransporteurExistant(demandeInscriptionTrans);
		//d�biter paiement

		if (isNouveauTransporteur) {
			//Si nouvel adherent alors retourner information d'adh�sion
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
		}
		return isNouveauTransporteur;
	}

	/**
	 * G�n�re un nouveau num�ro de transporteur
	 */
	private int genererNumeroTransporteur () {

		return mapTransporteur.size() + 1;
	}
	
	@Override
	public boolean verifierAdherent(short codeVerif) {
		// TODO Auto-generated method stub
		return false;
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

}
