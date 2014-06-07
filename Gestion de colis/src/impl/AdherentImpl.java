package impl;

import OperateurDeTransportObjet.AdherentPOA;
import entites.ui.AdherentUI;

public class AdherentImpl extends AdherentPOA {

	private AdherentUI adherentUI;
	
	public AdherentImpl(AdherentUI adherentUI) {
		
		this.adherentUI = adherentUI;
	}

	@Override
	public void notifierColisArrive(String idObjet) {

		adherentUI.notifierColisArrive(idObjet);
		
	}

}
