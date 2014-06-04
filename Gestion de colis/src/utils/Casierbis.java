package utils;

import OperateurDeTransportObjet.GestionnaireTransportObjetPackage.Objet;

public class Casierbis {

	private int numeroCasier;
	private Objet objet;
	
	public Casierbis (int numeroCasier) {
		
		this.numeroCasier = numeroCasier;	
	}

	public int getNumeroCasier() {
		return numeroCasier;
	}

	public void setNumeroCasier(int numeroCasier) {
		this.numeroCasier = numeroCasier;
	}

	public Objet getObjet() {
		return objet;
	}

	public void setObjet(Objet objet) {
		this.objet = objet;
	}
	
}
