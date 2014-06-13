package impl;

import javax.swing.SwingUtilities;

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
		
		System.out.println("SD : " + nomStationDepart + "  SA : " + nomStationArrivee + "  numOffre : " + numeroOffre);
		transporteurUI.ajouterOffreTransport(numeroOffre, nomStationDepart, nomStationArrivee);
		
	}

	@Override
	public void notifierOffrePriseEnCharge(final String numeroOffre) {
		// ne pas bloquer le thread du service CORBA
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				transporteurUI.alerterOffreDejaPriseEnCharge(numeroOffre);
				
			}
		});
	}
}
