package OperateurDeTransportObjet.GestionnaireTransportObjetPackage;

/**
 * Holder class for : ObjetInexistantException
 * 
 * @author OpenORB Compiler
 */
final public class ObjetInexistantExceptionHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ObjetInexistantException value
     */
    public OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ObjetInexistantException value;

    /**
     * Default constructor
     */
    public ObjetInexistantExceptionHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ObjetInexistantExceptionHolder(OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ObjetInexistantException initial)
    {
        value = initial;
    }

    /**
     * Read ObjetInexistantException from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ObjetInexistantExceptionHelper.read(istream);
    }

    /**
     * Write ObjetInexistantException into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ObjetInexistantExceptionHelper.write(ostream,value);
    }

    /**
     * Return the ObjetInexistantException TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ObjetInexistantExceptionHelper.type();
    }

}
