package utils;

public class OffreTransport {

	private String numeroOffre;
	private String idObjet;
	private String nomStationDepart;
	private String nomStationArrivee;
	private EtatOffreTransport etatOffreTransport;
	
	public OffreTransport(String numeroOffre, String idObjet, String nomStationDepart,
			String nomStationArrivee, EtatOffreTransport etatOffreTransport) {
		super();
		this.idObjet = idObjet;
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

	public String getIdObjet() {
		return idObjet;
	}

	public void setIdObjet(String idObjet) {
		this.idObjet = idObjet;
	}

	@Override
	public String toString() {
		return "OffreTransport [numeroOffre=" + numeroOffre + ", idObjet="
				+ idObjet + ", nomStationDepart=" + nomStationDepart
				+ ", nomStationArrivee=" + nomStationArrivee
				+ ", etatOffreTransport=" + etatOffreTransport + "]";
	}
}
