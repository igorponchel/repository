package OperateurDeTransportObjet.GestionUtilisateursPackage;

/**
 * Exception definition : TransInexistantException
 * 
 * @author OpenORB Compiler
 */
public final class TransInexistantException extends org.omg.CORBA.UserException
{
    /**
     * Exception member explication
     */
    public String explication;

    /**
     * Default constructor
     */
    public TransInexistantException()
    {
        super(TransInexistantExceptionHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param explication explication exception member
     */
    public TransInexistantException(String explication)
    {
        super(TransInexistantExceptionHelper.id());
        this.explication = explication;
    }

    /**
     * Full constructor with fields initialization
     * @param explication explication exception member
     */
    public TransInexistantException(String orb_reason, String explication)
    {
        super(TransInexistantExceptionHelper.id() +" " +  orb_reason);
        this.explication = explication;
    }

}
