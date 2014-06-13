package OperateurDeTransportObjet.GestionnaireTransportObjetPackage;

/**
 * Holder class for : TransExistantException
 * 
 * @author OpenORB Compiler
 */
final public class TransExistantExceptionHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal TransExistantException value
     */
    public OperateurDeTransportObjet.GestionnaireTransportObjetPackage.TransExistantException value;

    /**
     * Default constructor
     */
    public TransExistantExceptionHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public TransExistantExceptionHolder(OperateurDeTransportObjet.GestionnaireTransportObjetPackage.TransExistantException initial)
    {
        value = initial;
    }

    /**
     * Read TransExistantException from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = TransExistantExceptionHelper.read(istream);
    }

    /**
     * Write TransExistantException into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        TransExistantExceptionHelper.write(ostream,value);
    }

    /**
     * Return the TransExistantException TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return TransExistantExceptionHelper.type();
    }

}
