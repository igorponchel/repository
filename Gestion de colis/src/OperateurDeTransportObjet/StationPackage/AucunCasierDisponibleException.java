package OperateurDeTransportObjet.StationPackage;

/**
 * Exception definition : AucunCasierDisponibleException
 * 
 * @author OpenORB Compiler
 */
public final class AucunCasierDisponibleException extends org.omg.CORBA.UserException
{
    /**
     * Exception member explication
     */
    public String explication;

    /**
     * Default constructor
     */
    public AucunCasierDisponibleException()
    {
        super(AucunCasierDisponibleExceptionHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param explication explication exception member
     */
    public AucunCasierDisponibleException(String explication)
    {
        super(AucunCasierDisponibleExceptionHelper.id());
        this.explication = explication;
    }

    /**
     * Full constructor with fields initialization
     * @param explication explication exception member
     */
    public AucunCasierDisponibleException(String orb_reason, String explication)
    {
        super(AucunCasierDisponibleExceptionHelper.id() +" " +  orb_reason);
        this.explication = explication;
    }

}
