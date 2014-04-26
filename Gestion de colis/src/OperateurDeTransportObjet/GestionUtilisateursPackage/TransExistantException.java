package OperateurDeTransportObjet.GestionUtilisateursPackage;

/**
 * Exception definition : TransExistantException
 * 
 * @author OpenORB Compiler
 */
public final class TransExistantException extends org.omg.CORBA.UserException
{
    /**
     * Exception member explication
     */
    public String explication;

    /**
     * Default constructor
     */
    public TransExistantException()
    {
        super(TransExistantExceptionHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param explication explication exception member
     */
    public TransExistantException(String explication)
    {
        super(TransExistantExceptionHelper.id());
        this.explication = explication;
    }

    /**
     * Full constructor with fields initialization
     * @param explication explication exception member
     */
    public TransExistantException(String orb_reason, String explication)
    {
        super(TransExistantExceptionHelper.id() +" " +  orb_reason);
        this.explication = explication;
    }

}
