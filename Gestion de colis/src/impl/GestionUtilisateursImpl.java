package impl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.RandomStr;
import OperateurDeTransportObjet.Adherent;
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

	private Map <Integer, Adhesion> mapAdherent;

	private Map <Integer, List<Integer>> mapRegionZones;

	public GestionUtilisateursImpl (String args[]) {

		mapNumeroAdherentConnectes = new HashMap<>();
		multimapNumAdherentIdObjet = ArrayListMultimap.create();

		mapAdherent = new HashMap<>();
		mapAdherent.put(1, new Adhesion(1, "toto", "Ponchel", "Igor", "Capitole"));
		mapAdherent.put(2, new Adhesion(2, "toto", "Baadoud", "Kader", "Mirail"));
		mapAdherent.put(3, new Adhesion(2, "toto", "Bastien", "Trevisan", "Minimes"));

	}

	@Override
	public Adhesion demandeAdhesion (DemandeAdhesion demandeAdhesion) throws AdherentExistantException {

		//v�rifier existance adh�rent
		boolean isNouvelAdherent = verifierAdherentExistant(demandeAdhesion);
		//d�biter paiement

		if (isNouvelAdherent) {
			//Si nouvel adherent alors retourner information d'adh�sion
			Adhesion adhesion = new Adhesion(genererNumeroAdherent(), genererMotDePasse(), demandeAdhesion.nomAdherent, demandeAdhesion.prenomAdherent, demandeAdhesion.adresseAdherent.quartier);
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
	 * Calcule la zone correspondante au d�partement de l'adh�rent
	 */
	private int getZone (int departement) {

		for (int i = 1; i <= mapRegionZones.size(); i++) {

			if(mapRegionZones.get(i).contains(departement)) {

				return i;
			}
		}

		return -1;
		//		throw new Exception("Le d�partement de l'adh�rent n'est pas pris en charge. Seule la France m�tropolitaine est �lligible.");
	}

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

	@Override
	public String verifierAdherent(int numeroAdherent, String motDePasse) {

		Adhesion adhesion = mapAdherent.get(numeroAdherent);
		if (adhesion != null) {
			
			if (adhesion.motDePasse.equals(motDePasse)) {
				return adhesion.zoneAdherent;
			}
		}

		return "";
	}

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
	 * Notifier l'adh�rent que le colis dont il est destinataire est arriv�.
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
