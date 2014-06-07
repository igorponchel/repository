package impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import utils.EtatOffre;
import utils.EtatOffreTransport;
import utils.OffreTransport;
import utils.RandomStr;
import OperateurDeTransportObjet.GestionnaireTransportObjetPOA;
import OperateurDeTransportObjet.Transporteur;
import OperateurDeTransportObjet.GestionnaireTransportObjetPackage.EtatObjet;
import OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ObjetInexistantException;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class GestionnaireTransportObjetImpl extends GestionnaireTransportObjetPOA {

	//Contient l'ensemble des liens vers les transporteurs connectés
	private Map<Integer, Transporteur> mapNumeroTransporteursConnectes;
	
	//Contient les offres de transport associées à leur code de transport
	private Map <String, OffreTransport> mapCodeTransportOffre;
	
	private Map <Integer, String> mapNumeroNomTransporteurs;
	private Multimap<Integer, String> multimapNumTransCodeTrans;
	private Map <String, EtatObjet> mapObjetEtat;
	private Map <String, String> mapNumOffreCodeTransport;

	private String args[];


	public GestionnaireTransportObjetImpl (String args[]) {

		this.args = args;

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

			//notifier tous les transporteurs (même celui qui a pris en charge l'offre => confirmation)
			for (Transporteur transporteur : mapNumeroTransporteursConnectes.values()) {

				transporteur.notifierOffrePriseEnCharge(codeTransport);
			}

			multimapNumTransCodeTrans.put(numeroTransporteur, codeTransport);
			//on enlève l'offre vu qu'elle vient d'être acceptée
			mapNumOffreCodeTransport.remove(numeroOffre);

			return codeTransport;
		}
		else {

			//L'offre de transport a déjà été acceptée par un autre transporteur
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
	public void notifierEtatObjet(String idObjet, EtatObjet etatObjet)
			throws ObjetInexistantException {

		if (etatObjet == EtatObjet.depose) {

			mapObjetEtat.put(idObjet, etatObjet);
		}
		else { 
			if (mapObjetEtat.get(idObjet) != null) {

				mapObjetEtat.put(idObjet, etatObjet);
			}
			else {
				throw new ObjetInexistantException("L'objet notifié n'existe pas.");
			}
		}
	}

	@Override
	public EtatObjet consulterEtatObjet(String idObjet)
			throws ObjetInexistantException {

		EtatObjet etatObjet = mapObjetEtat.get(idObjet);

		if (etatObjet != null) {

			return etatObjet;
		}
		else {
			throw new ObjetInexistantException("L'objet à consulter n'existe pas.");
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
}
