package impl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import utils.RandomStr;
import OperateurDeTransportObjet.Adherent;
import OperateurDeTransportObjet.CoordBancaire;
import OperateurDeTransportObjet.GestionUtilisateursPOA;
import OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentExistantException;
import OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentInexistantException;
import OperateurDeTransportObjet.GestionUtilisateursPackage.Adhesion;
import OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeAdhesion;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class GestionUtilisateursImpl extends GestionUtilisateursPOA {

	//Contient l'ensemble des liens vers les adherents connect�s
	private Map<Integer, Adherent> mapNumeroAdherentConnectes;

	//Contient les notifications de colis arriv� en attente. 
	private Multimap<Integer, String> multimapNumAdherentIdObjet;

	//Contient l'ensemble des adhesion effectu�es
	private Map <Integer, Adhesion> mapAdherent;

	public GestionUtilisateursImpl () {

		mapNumeroAdherentConnectes = new HashMap<>();
		multimapNumAdherentIdObjet = ArrayListMultimap.create();

		mapAdherent = new HashMap<>();
		mapAdherent.put(1, new Adhesion(1, "toto", "Ponchel", "Igor", "Capitole", new CoordBancaire(11111111, "", "", 0)));
		mapAdherent.put(2, new Adhesion(2, "toto", "Baadoud", "Kader", "Mirail", new CoordBancaire(22232222, "", "", 0)));
		mapAdherent.put(3, new Adhesion(3, "toto", "Trevisan", "Bastien", "Minimes", new CoordBancaire(33333333, "", "", 0)));
		mapAdherent.put(4, new Adhesion(4, "toto", "Delpech", "Thomas", "St-Aubin", new CoordBancaire(4444444, "", "", 0)));

	}

	/**
	 * Permet � un utilisateur d'adh�rer au service
	 */
	@Override
	public Adhesion demandeAdhesion (DemandeAdhesion demandeAdhesion) throws AdherentExistantException {

		//v�rifier existance adh�rent
		boolean isNouvelAdherent = verifierAdherentExistant(demandeAdhesion);
		//d�biter paiement

		if (isNouvelAdherent) {
			//Si nouvel adherent alors retourner information d'adh�sion
			Adhesion adhesion = new Adhesion(genererNumeroAdherent(), genererMotDePasse(), demandeAdhesion.nomAdherent, demandeAdhesion.prenomAdherent, demandeAdhesion.adresseAdherent.quartier, demandeAdhesion.coordonneesBancaires);
			mapAdherent.put(adhesion.numeroAdherent, adhesion);
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
	 * G�n�re un mot de passe al�atoire
	 */
	private String genererMotDePasse () {

		RandomStr rand = new RandomStr();

		return rand.get(6);
	}

	/**
	 * Retourne le num�ro d'un adh�rent � partir de son nom et de son pr�nom
	 */
	@Override
	public int getNumAdherent(String nomAdherent, String prenom) throws AdherentInexistantException {
	
		Collection<Adhesion> adherents = mapAdherent.values();
		for (Adhesion tempAdhesion : adherents) {
			
			if (tempAdhesion.nomAdherent.equals(nomAdherent) && tempAdhesion.prenomAdherent.equals(prenom)) {
				
				return tempAdhesion.numeroAdherent;
			}		
		}
		
		throw new AdherentInexistantException("L'adherent recherch� n'existe pas.");
	}

	/**
	 * V�rifie le couple num�roAdh�rent/Motdepasse d'une adh�sion inscrit
	 */
	@Override
	public String verifierAdherent(int numeroAdherent, String motDePasse) throws AdherentInexistantException {

		Adhesion adhesion = mapAdherent.get(numeroAdherent);
		if (adhesion != null) {
			
			if (adhesion.motDePasse.equals(motDePasse)) {
				return adhesion.zoneAdherent;
			}
		}

		throw new AdherentInexistantException("L'adherent recherch� n'existe pas.");
	}

	/**
	 * Permet d'obtenir les coordonn�es bancaires d'un adh�rent pour pouvoir le facturer
	 */
	@Override
	public CoordBancaire getCoordBancairesAdherent(int numAdherent)
			throws AdherentInexistantException {
		
		if (mapAdherent.containsKey(numAdherent)) {
			
			return mapAdherent.get(numAdherent).coordonnesBancaires;
		}
		else {
			throw new AdherentInexistantException();
		}
	}
	
	/**
	 * Permet d'obtenir la zone de l'adh�rent
	 */
	@Override
	public String getZoneAdherent(String nomAdherent, String prenomAdherent)
			throws AdherentInexistantException {

		String zoneAdherent = "";

		for (Adhesion tempAdhesion : mapAdherent.values()) {

			if(tempAdhesion.nomAdherent.equals(nomAdherent) && tempAdhesion.prenomAdherent.equals(prenomAdherent)) {

				zoneAdherent = tempAdhesion.zoneAdherent;
				break;
			}
		}

		if (!zoneAdherent.equals("")) {
			return zoneAdherent;
		} 
		else {
			throw new AdherentInexistantException("L'adh�rent n'existe pas.");
		}
	}

	@Override
	public void notifierConnexionAdh(int numeroAdherent, Adherent adherent) {

		mapNumeroAdherentConnectes.put(numeroAdherent, adherent);
		gererNotificationEnAbsence(numeroAdherent, adherent);
	}

	@Override
	public void notifierDeconnexionAdh(int numeroAdherent) {

		mapNumeroAdherentConnectes.remove(numeroAdherent);

	}

	/**
	 * Notifie l'adh�rent que le colis dont il est destinataire est arriv� en station.
	 */
	@Override
	public void notifierColisArrive(int numeroAdherent, String idObjet) {

		Adherent adherent = mapNumeroAdherentConnectes.get(numeroAdherent);
		//Si l'adh�rent est connect� on le notifie
		if(adherent != null) {

			adherent.notifierColisArrive(idObjet);
			
		} else { //Si l'adh�rent n'est pas connect� on stocke la notif pour plus tard

			multimapNumAdherentIdObjet.put(numeroAdherent, idObjet);
		}
	}

	/**
	 * Notifie l'adh�rent lors de sa reconnection de toutes les notifications en attente qui le concernent
	 * 
	 * @param numeroAdherent
	 * @param adherent
	 */
	private void gererNotificationEnAbsence (int numeroAdherent, Adherent adherent) {
		
		ArrayList<String> listeIdObjet = new ArrayList(multimapNumAdherentIdObjet.get(numeroAdherent));
		
		if (!listeIdObjet.isEmpty()) {
			
			for (String idObjet : listeIdObjet) {
				
				adherent.notifierColisArrive(idObjet);
			}
			
			multimapNumAdherentIdObjet.removeAll(numeroAdherent);
		}
	}

}
