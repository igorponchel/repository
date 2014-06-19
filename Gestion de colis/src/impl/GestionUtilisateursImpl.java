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

	//Contient l'ensemble des liens vers les adherents connectés
	private Map<Integer, Adherent> mapNumeroAdherentConnectes;

	//Contient les notifications de colis arrivé en attente. 
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

		//vérifier existance adhérent
		boolean isNouvelAdherent = verifierAdherentExistant(demandeAdhesion);
		//débiter paiement

		if (isNouvelAdherent) {
			//Si nouvel adherent alors retourner information d'adhésion
			Adhesion adhesion = new Adhesion(genererNumeroAdherent(), genererMotDePasse(), demandeAdhesion.nomAdherent, demandeAdhesion.prenomAdherent, demandeAdhesion.adresseAdherent.quartier);
			mapAdherent.put(adhesion.numeroAdherent, adhesion);
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
	public int getNumAdherent(String nomAdherent, String prenom) throws AdherentInexistantException {
	
		Collection<Adhesion> adherents = mapAdherent.values();
		for (Adhesion tempAdhesion : adherents) {
			
			if (tempAdhesion.nomAdherent.equals(nomAdherent) && tempAdhesion.prenomAdherent.equals(prenom)) {
				
				return tempAdhesion.numeroAdherent;
			}		
		}
		
		throw new AdherentInexistantException("L'adherent recherché n'existe pas.");
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
			throw new AdherentInexistantException("L'adhérent n'existe pas.");
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
	 * Notifier l'adhérent que le colis dont il est destinataire est arrivé.
	 */
	@Override
	public void notifierColisArrive(int numeroAdherent, String idObjet) {

		Adherent adherent = mapNumeroAdherentConnectes.get(numeroAdherent);
		//Si l'adhérent est connecté on le notifie
		if(adherent != null) {

			adherent.notifierColisArrive(idObjet);
			
		} else { //Si l'adhérent n'est pas connecté on stocke la notif pour plus tard

			multimapNumAdherentIdObjet.put(numeroAdherent, idObjet);
		}
	}

	/**
	 * Notifie l'adhérent lors de sa reconnection de toutes les notifications en attente qui le concernent
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
