package impl;

import OperateurDeTransportObjet.AdherentPOA;
import entites.ui.AdherentUI;
import entites.ui.StationUI;

public class AdherentImpl extends AdherentPOA {

	private AdherentUI adherentUI;
	
	public AdherentImpl(StationUI stationUI) {
		
		this.adherentUI = adherentUI;
	}

	@Override
	public void notifierColisArrive(String idObjet) {

		adherentUI.notifierColisArrive(idObjet);
		
	}

}
