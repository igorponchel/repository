package impl;

import OperateurDeTransportObjet.AdherentPOA;
import entites.ui.GestionColisUI;

public class AdherentImpl extends AdherentPOA {

	private GestionColisUI gestionColisUI;
	
	public AdherentImpl(GestionColisUI gestionColisUI) {
		
		this.gestionColisUI = gestionColisUI;
	}

	@Override
	public void notifierColisArrive(String idObjet) {

		gestionColisUI.notifierColisArrive(idObjet);
	}

}
