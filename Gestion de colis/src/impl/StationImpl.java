package impl;

import entites.ui.StationUI;
import OperateurDeTransportObjet.StationPOA;
import OperateurDeTransportObjet.StationPackage.AucunCasierDisponibleException;

public class StationImpl extends StationPOA {

	private StationUI maStation;
	
	public StationImpl(StationUI station) {
		
		this.maStation = station;
		
	}

	@Override
	public int reserverCasier(String idObjet)
			throws AucunCasierDisponibleException {
		// TODO Auto-generated method stub
		
		int numeroCasier = maStation.getNumeroCasierLibre();
		
		if (numeroCasier != 0) {
			
			return numeroCasier;
		}
		else {
			throw new AucunCasierDisponibleException("Aucune casier n'est disponible");
		}
	}
	
	
}
