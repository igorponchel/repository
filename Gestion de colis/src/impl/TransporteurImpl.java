package impl;

import OperateurDeTransportObjet.TransporteurPOA;
import entites.ui.TransporteurUI;

public class TransporteurImpl extends TransporteurPOA {

	private TransporteurUI transporteurUI;
	
	public TransporteurImpl(TransporteurUI transporteurUI) {

		this.transporteurUI = transporteurUI;
	}

	@Override
	public void notifierOffreTransport(String nomStationDepart,
			String nomStationArrivee, String numeroOffre) {
		
		transporteurUI.ajouterOffreTransport(numeroOffre, nomStationDepart, nomStationArrivee);
		
	}

	@Override
	public void notifierOffrePriseEnCharge(String numeroOffre) {
		
		transporteurUI.alerterOffreDejaPriseEnCharge(numeroOffre);
	}

}
