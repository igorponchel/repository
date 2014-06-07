package utils;



public class EtatOffreTransport {

	public static final int _aPrendreEnCharge = 0;
	public static final EtatOffreTransport aPrendreEnCharge = new EtatOffreTransport(_aPrendreEnCharge);
	public static final int _priseEnCharge = 1;
	public static final EtatOffreTransport priseEnCharge = new EtatOffreTransport(_priseEnCharge);


	private int _EtatOffre_value;


	private EtatOffreTransport( final int value )
	{
		_EtatOffre_value = value;
	}


	public void setEtatOffreTransport(int value) {

		_EtatOffre_value = value;
	}

	public String toString() {

		switch (_EtatOffre_value) {
		case _aPrendreEnCharge:
			return "A prendre en charge";
		case _priseEnCharge:	
			return "Prise en charge";
		default:
			return "";
		}
	}
}
