package impl;

import OperateurDeTransportObjet.CoordBancaire;
import OperateurDeTransportObjet.CoordBancairePro;
import OperateurDeTransportObjet.GestionnairePaiementPOA;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class GestionnairePaiementImpl extends GestionnairePaiementPOA {

	private Multimap<String, String> multiMap;
	
	
	public GestionnairePaiementImpl () {
		
		multiMap = ArrayListMultimap.create();
	}
	
	
	@Override
	public short debiter(CoordBancaire coordonneesBancaires,
			String stationDepart, String stationArrivee) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public short crediter(CoordBancairePro coordonneesBancairesPro,
			String stationDepart, String stationArrivee) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
}
