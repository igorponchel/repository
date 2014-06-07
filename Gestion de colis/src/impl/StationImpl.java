package impl;

import OperateurDeTransportObjet.Objet;
import OperateurDeTransportObjet.StationPOA;
import OperateurDeTransportObjet.StationPackage.AucunCasierDisponibleException;
import entites.ui.StationUI;

public class StationImpl extends StationPOA {

	private StationUI maStation;
	
	public StationImpl(StationUI station) {
		
		this.maStation = station;
		
	}

	@Override
	public int reserverCasier(int numeroAdherent)
			throws AucunCasierDisponibleException {
		// TODO Auto-generated method stub
		
		int numeroCasier = maStation.getNumeroCasierLibre();
		
		if (numeroCasier < 20 ) {
			
			return numeroCasier;
		}
		else {
			throw new AucunCasierDisponibleException("Aucun casier n'est disponible");
		}
	}

	@Override
	public void notifierCodeTransport(int numeroCasier, String codeTransport) {
		// TODO Auto-generated method stub
		
		maStation.ajouterCoupleCodeTransportCasier(codeTransport, numeroCasier);
	}
	
	
}
