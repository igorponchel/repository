package OperateurDeTransportObjet.GestionUtilisateursPackage;

/**
 * Exception definition : AdherentInexistantException
 * 
 * @author OpenORB Compiler
 */
public final class AdherentInexistantException extends org.omg.CORBA.UserException
{
    /**
     * Exception member explication
     */
    public String explication;

    /**
     * Default constructor
     */
    public AdherentInexistantException()
    {
        super(AdherentInexistantExceptionHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param explication explication exception member
     */
    public AdherentInexistantException(String explication)
    {
        super(AdherentInexistantExceptionHelper.id());
        this.explication = explication;
    }

    /**
     * Full constructor with fields initialization
     * @param explication explication exception member
     */
    public AdherentInexistantException(String orb_reason, String explication)
    {
        super(AdherentInexistantExceptionHelper.id() +" " +  orb_reason);
        this.explication = explication;
    }

}
