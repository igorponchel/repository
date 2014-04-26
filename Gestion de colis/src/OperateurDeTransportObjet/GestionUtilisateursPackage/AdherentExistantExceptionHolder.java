package OperateurDeTransportObjet.GestionUtilisateursPackage;

/**
 * Holder class for : AdherentExistantException
 * 
 * @author OpenORB Compiler
 */
final public class AdherentExistantExceptionHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal AdherentExistantException value
     */
    public OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentExistantException value;

    /**
     * Default constructor
     */
    public AdherentExistantExceptionHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public AdherentExistantExceptionHolder(OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentExistantException initial)
    {
        value = initial;
    }

    /**
     * Read AdherentExistantException from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = AdherentExistantExceptionHelper.read(istream);
    }

    /**
     * Write AdherentExistantException into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        AdherentExistantExceptionHelper.write(ostream,value);
    }

    /**
     * Return the AdherentExistantException TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return AdherentExistantExceptionHelper.type();
    }

}
