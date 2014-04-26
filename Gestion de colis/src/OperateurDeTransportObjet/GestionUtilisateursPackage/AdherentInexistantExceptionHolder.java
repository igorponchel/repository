package OperateurDeTransportObjet.GestionUtilisateursPackage;

/**
 * Holder class for : AdherentInexistantException
 * 
 * @author OpenORB Compiler
 */
final public class AdherentInexistantExceptionHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal AdherentInexistantException value
     */
    public OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentInexistantException value;

    /**
     * Default constructor
     */
    public AdherentInexistantExceptionHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public AdherentInexistantExceptionHolder(OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentInexistantException initial)
    {
        value = initial;
    }

    /**
     * Read AdherentInexistantException from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = AdherentInexistantExceptionHelper.read(istream);
    }

    /**
     * Write AdherentInexistantException into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        AdherentInexistantExceptionHelper.write(ostream,value);
    }

    /**
     * Return the AdherentInexistantException TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return AdherentInexistantExceptionHelper.type();
    }

}
