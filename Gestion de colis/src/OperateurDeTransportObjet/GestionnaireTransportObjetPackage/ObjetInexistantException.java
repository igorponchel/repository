package OperateurDeTransportObjet.GestionnaireTransportObjetPackage;

/**
 * Exception definition : ObjetInexistantException
 * 
 * @author OpenORB Compiler
 */
public final class ObjetInexistantException extends org.omg.CORBA.UserException
{
    /**
     * Exception member explication
     */
    public String explication;

    /**
     * Default constructor
     */
    public ObjetInexistantException()
    {
        super(ObjetInexistantExceptionHelper.id());
    }

    /**
     * Constructor with fields initialization
     * @param explication explication exception member
     */
    public ObjetInexistantException(String explication)
    {
        super(ObjetInexistantExceptionHelper.id());
        this.explication = explication;
    }

    /**
     * Full constructor with fields initialization
     * @param explication explication exception member
     */
    public ObjetInexistantException(String orb_reason, String explication)
    {
        super(ObjetInexistantExceptionHelper.id() +" " +  orb_reason);
        this.explication = explication;
    }

}
