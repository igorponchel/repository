package utils;

public class OffreTransport {

	private String numeroOffre;
	private String nomStationDepart;
	private String nomStationArrivee;
	private EtatOffreTransport etatOffreTransport;
	
	public OffreTransport(String numeroOffre, String nomStationDepart,
			String nomStationArrivee, EtatOffreTransport etatOffreTransport) {
		super();
		this.numeroOffre = numeroOffre;
		this.nomStationDepart = nomStationDepart;
		this.nomStationArrivee = nomStationArrivee;
		this.etatOffreTransport = etatOffreTransport;
	}

	public String getNumeroOffre() {
		return numeroOffre;
	}

	public void setNumeroOffre(String numeroOffre) {
		this.numeroOffre = numeroOffre;
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

	public EtatOffreTransport getEtatOffreTransport() {
		return etatOffreTransport;
	}

	public void setEtatOffreTransport(EtatOffreTransport etatOffreTransport) {
		this.etatOffreTransport = etatOffreTransport;
	}
}
