package impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import utils.EtatOffre;
import utils.RandomStr;
import OperateurDeTransportObjet.GestionnaireTransportObjetPOA;
import OperateurDeTransportObjet.Transporteur;
import OperateurDeTransportObjet.GestionnaireTransportObjetPackage.EtatObjet;
import OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ObjetInexistantException;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class GestionnaireTransportObjetImpl extends GestionnaireTransportObjetPOA {

	private List<Transporteur> listeTransporteurs;
	private Map <String, EtatOffre> mapCodeTransportEtat;
	private Map <Integer, String> mapNumeroNomTransporteurs;
	private Multimap<Integer, String> multimapNumTransCodeTrans;
	private Map <String, EtatObjet> mapObjetEtat;
	private Map <String, String> mapNumOffreCodeTransport;
	
	private String args[];
	

	public GestionnaireTransportObjetImpl (String args[]) {

		this.args = args;
		
		mapNumeroNomTransporteurs = new HashMap<>();
		initNumeroNomTransporteurs();
		listeTransporteurs = new ArrayList<>();
		initListeTransporteursViaNamingService();
		mapCodeTransportEtat = new HashMap<>();
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
		mapCodeTransportEtat.put(codeTransport, EtatOffre.aPrendreEnCharge);

		//notifier tous les transporteurs
		for (Transporteur transporteur : listeTransporteurs) {
			
			transporteur.notifierOffreTransport(nomStationDepart, nomStationArrivee, codeTransport);
		}
		
		return codeTransport;
	}

	@Override
	public String notifierOffreAcceptee(int numeroTransporteur,
			String numeroOffre) {
		
		String codeTransport = mapNumOffreCodeTransport.get(numeroOffre);
		
		if (mapCodeTransportEtat.get(codeTransport) == EtatOffre.aPrendreEnCharge) {
			
			mapCodeTransportEtat.put(codeTransport, EtatOffre.priseEnCharge);
		
			//notifier tous les transporteurs (même celui qui a pris en charge l'offre => confirmation)
			for (Transporteur transporteur : listeTransporteurs) {
				
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
	
	private void initNumeroNomTransporteurs() {
		
		//La map devra être remplie en demandant les infos au GEstionnaire Utilisateurs
		mapNumeroNomTransporteurs.put(1, "Mory");
	
	}
	
	private void initListeTransporteursViaNamingService() {
		
		OperateurDeTransportObjet.Transporteur transporteurDistant = null;

		// Intialisation de l'orb
		org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args, null);
		
		//on devra récupérer cette liste de transporteur via le Gestionnaire Utilisateurs
		List<Integer> listeNumeroTransporteurs = new ArrayList<Integer>(mapNumeroNomTransporteurs.keySet());
		
		// Recuperation du naming service
		org.omg.CosNaming.NamingContext nameRoot;
		try {
			nameRoot = org.omg.CosNaming.NamingContextHelper.narrow(orb.resolve_initial_references("NameService"));

			// Construction des noms à rechercher
			for(int numeroTransporteur : listeNumeroTransporteurs) {
				
				org.omg.CosNaming.NameComponent[] nameToFind = new org.omg.CosNaming.NameComponent[1];
				nameToFind[0] = new org.omg.CosNaming.NameComponent("Transporteur" + numeroTransporteur,"");

				// Recherche aupres du naming service
				org.omg.CORBA.Object transporteurDestinataire = nameRoot.resolve(nameToFind);
				System.out.println("Objet '" + "Transporteur" + numeroTransporteur + "' trouve aupres du service de noms. IOR de l'objet :");
				System.out.println(orb.object_to_string(transporteurDestinataire));			

				transporteurDistant = OperateurDeTransportObjet.TransporteurHelper.narrow(transporteurDestinataire);
				
				listeTransporteurs.add(transporteurDistant);
			}
		} catch (InvalidName e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotFound e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (CannotProceed e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (org.omg.CosNaming.NamingContextPackage.InvalidName e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
	}
}
