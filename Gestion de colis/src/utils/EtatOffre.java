package utils;



public class EtatOffre {

	public static final int _aPrendreEnCharge = 0;
    public static final EtatOffre aPrendreEnCharge = new EtatOffre(_aPrendreEnCharge);
	public static final int _priseEnCharge = 1;
    public static final EtatOffre priseEnCharge = new EtatOffre(_priseEnCharge);
	public static final int _terminee = 2;
    public static final EtatOffre terminee = new EtatOffre(_terminee);
	

    private final int _EtatOffre_value;


    private EtatOffre( final int value )
    {
    	_EtatOffre_value = value;
    }
}
