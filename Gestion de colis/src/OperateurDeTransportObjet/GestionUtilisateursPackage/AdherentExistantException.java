package OperateurDeTransportObjet.GestionUtilisateursPackage;

/**
 * Exception definition : AdherentExistantException
 * 
 * @author OpenORB Compiler
 */
public final class AdherentExistantException extends org.omg.CORBA.UserException
{
    /**
     * Exception member explication
     */
    public String explication;

    /**
     * Default constructor
     */
    public AdherentExistantException()
    {
        super(AdherentExistantExceptionHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param explication explication exception member
     */
    public AdherentExistantException(String explication)
    {
        super(AdherentExistantExceptionHelper.id());
        this.explication = explication;
    }

    /**
     * Full constructor with fields initialization
     * @param explication explication exception member
     */
    public AdherentExistantException(String orb_reason, String explication)
    {
        super(AdherentExistantExceptionHelper.id() +" " +  orb_reason);
        this.explication = explication;
    }

}
