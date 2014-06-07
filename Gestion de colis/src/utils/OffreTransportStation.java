package utils;

import OperateurDeTransportObjet.StationPackage.Casier;

public class OffreTransportStation {

	private String codeTransport;
	private String nomStationDepart;
	private String nomStationArrivee;
	private Casier casierLocal;
	
	public OffreTransportStation(String codeTransport, String nomStationDepart,
			String nomStationArrivee, Casier casierLocal) {
		super();
		this.codeTransport = codeTransport;
		this.nomStationDepart = nomStationDepart;
		this.nomStationArrivee = nomStationArrivee;
		this.casierLocal = casierLocal;
	}

	public String getCodeTransport() {
		return codeTransport;
	}

	public void setCodeTransport(String codeTransport) {
		this.codeTransport = codeTransport;
	}

	public String getNomStationDepart() {
		return nomStationDepart;
	}

	public void setNomStationDepart(String nomStationDepart) {
		this.nomStationDepart = nomStationDepart;
	}

	public String getNomStationArrivee() {
		return nomStationArrivee;
	}

	public void setNomStationArrivee(String nomStationArrivee) {
		this.nomStationArrivee = nomStationArrivee;
	}

	public Casier getCasierLocal() {
		return casierLocal;
	}

	public void setCasierLocal(Casier casierLocal) {
		this.casierLocal = casierLocal;
	}

	@Override
	public String toString() {
		return "OffreTransportStation [codeTransport=" + codeTransport
				+ ", nomStationDepart=" + nomStationDepart
				+ ", nomStationArrivee=" + nomStationArrivee + ", casierLocal="
				+ casierLocal.toString() + "]";
	}
}

