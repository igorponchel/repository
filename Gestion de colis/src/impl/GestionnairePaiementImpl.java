package impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import OperateurDeTransportObjet.CoordBancaire;
import OperateurDeTransportObjet.CoordBancairePro;
import OperateurDeTransportObjet.GestionnairePaiementPOA;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class GestionnairePaiementImpl extends GestionnairePaiementPOA {

	//Contient pour chaque région, l'ensemble des zones correspondantes
	//Ici on a choisit 6 régions (correspondants aux 6 codes postaux de Toulouse centre)
	//et les zones sont les quartiers correspondant
	private Multimap<String, String> multiMapRegionZones;
	private ArrayList<String> q31000;
	private ArrayList<String> q31100;
	private ArrayList<String> q31200;
	private ArrayList<String> q31300;
	private ArrayList<String> q31400;
	private ArrayList<String> q31500;
	private ArrayList<String> v31000;
	private ArrayList<String> v31100;
	private ArrayList<String> v31200;
	private ArrayList<String> v31300;
	private ArrayList<String> v31400;
	private ArrayList<String> v31500;
	
	//Contient pour chaque région la liste de ses régions voisines
	private Multimap<String, String> voisins;

	//cout d'adhésion
	private static double COUT_ADHESION = 10.00;

	public GestionnairePaiementImpl () {
		q31000 = new ArrayList<>();
		q31000.add("Capitole");
		q31000.add("Amidonniers");
		q31000.add("Caffarelli");
		q31000.add("St-Aubin");

		q31100 = new ArrayList<>();
		q31100.add("Arènes Romaines");
		q31100.add("Saint-Martin-du-Touch");
		q31100.add("Lardenne");
		q31100.add("Les Pradettes");
		q31100.add("Basso Cambo");
		q31100.add("Mirail");
		q31100.add("Saint-Simon");
		q31100.add("Lafaourette");
		
		q31200 = new ArrayList<>();
		q31200.add("Barrière-de-Paris");
		q31200.add("Minimes");
		q31200.add("Sept Deniers");
		q31200.add("Trois Cocus");
		q31200.add("Borderouge");
		q31200.add("Croix-Daurade");
		
		q31300 = new ArrayList<>();
		q31300.add("Patte d’Oie");
		q31300.add("Saint-Cyprien");
		q31300.add("Saint-Martin");
		q31300.add("Purpan");
		
		q31400 = new ArrayList<>();
		q31400.add("Montaudran");
		q31400.add("Ranueil");
		q31400.add("Saouzelong");
		q31400.add("Pouvourville");
		q31400.add("Saint-Michel");
		q31400.add("Le Busca");
		q31400.add("Saint-Agne");
		q31400.add("Empalot");
		
		q31500 = new ArrayList<>();
		q31500.add("La Roseraie");
		q31500.add("Bonnefoy");
		q31500.add("Jolimont");
		q31500.add("Soupetard");
		q31500.add("Côte Pavée");
		
		v31000 = new ArrayList<>();
		v31000.add("31100");
		v31000.add("31200");
		v31000.add("31300");
		v31000.add("31400");
		v31000.add("31500");
	
		v31100 = new ArrayList<>();
		v31100.add("31000");
		v31100.add("31300");
		v31100.add("31400");
		
		v31200 = new ArrayList<>();
		v31200.add("31000");
		v31200.add("31300");
		v31200.add("31500");
		
		v31300 = new ArrayList<>();
		v31300.add("31000");
		v31300.add("31100");
		v31300.add("31200");
	
		v31400 = new ArrayList<>();
		v31400.add("31000");
		v31400.add("31100");
		v31400.add("31500");
		
		v31500 = new ArrayList<>();
		v31500.add("31000");
		v31500.add("31200");
		v31500.add("31400");
		
		voisins = ArrayListMultimap.create();
		voisins.putAll("31000",v31000);
		voisins.putAll("31100",v31100);
		voisins.putAll("31200",v31200);
		voisins.putAll("31300",v31300);
		voisins.putAll("31400",v31400);
		voisins.putAll("31500",v31500);

		multiMapRegionZones = ArrayListMultimap.create();
		multiMapRegionZones.putAll("31000",q31000);
		multiMapRegionZones.putAll("31100",q31100);
		multiMapRegionZones.putAll("31200",q31200);
		multiMapRegionZones.putAll("31300",q31300);
		multiMapRegionZones.putAll("31400",q31400);
		multiMapRegionZones.putAll("31500",q31500);
	}

	/**
	 * Retourne la liste des zones correspondant au code postal saisi
	 * 
	 * @param codePostal ex:31000, 31100
	 * @return la liste des zones correspondant au code postal
	 */
	public String[] getListZones(String codePostal) {

		Collection<String> zones = multiMapRegionZones.get(codePostal);

		return (zones.toArray(new String[]{}));
	}

	/**
	 * Retourne la région à laquelle appartient une station
	 * @param station
	 * @return
	 */
	private String getCP(String station)
	{
		for (String cp : multiMapRegionZones.keySet()) {
			
			if(multiMapRegionZones.get(cp).contains(station)) {
				return cp;
			}
		}
		return "";		
	}
	
	/**
	 * Détermine si deux stations sont voisines
	 * @param stationD
	 * @param stationA
	 * @return
	 */
	private boolean estVoisin (String stationD, String stationA)
	{
		boolean estvoisin = false;

		String cpStationD = getCP(stationD);
		Collection<String> lesVoisins = voisins.get(cpStationD);
		if(lesVoisins.contains(getCP(stationA))) {
			estvoisin = true;
		}
		
		return(estvoisin);
	}

	/**
	 * Retourne le prix que l'adhérent doit payer pour la prise en charge de son colis
	 * @param stationD
	 * @param stationA
	 * @return
	 */
	private double getTarif (String stationD, String stationA)
	{
		double tar;
		//Si les deux stations sont dans la même région alors prix 1
		if(getCP(stationD).equals(getCP(stationA)))
		{
			tar = 3.00;
		}
		else
		{
			//Si les deux stations sont dans deux régions différentes voisines alors prix 2
			if(estVoisin(stationD, stationA))
				tar = 4.00;
			else //Si les deux stations sont dans deux régions différentes non voisines alors prix 3
				tar = 5.50;
		}

		return(tar);
	}

	/**
	 * Débite l'adhérent et retourne le prix de la prise en charge de son objet
	 */
	@Override
	public double debiter(CoordBancaire coordonneesBancaires,
			String stationDepart, String stationArrivee) {

		double montant = getTarif(stationDepart,stationArrivee);

		return montant;
	}

	/**
	 * Crédite le transporteur à la fin de chaque transport
	 */
	@Override
	public double crediter(CoordBancairePro coordonneesBancairesPro,
			String stationDepart, String stationArrivee) {

		double montant = getTarif(stationDepart,stationArrivee) * 0.9;

		return montant;
	}

	/**
	 * Retourne le prix qu'un adhérent devra s'acquitter lors de son adhésion au service
	 */
	@Override
	public double getCoutAdhesion() {
		// TODO Auto-generated method stub
		return COUT_ADHESION;
	}

}