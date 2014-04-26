package OperateurDeTransportObjet.GestionUtilisateursPackage;

/**
 * Holder class for : TransInexistantException
 * 
 * @author OpenORB Compiler
 */
final public class TransInexistantExceptionHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal TransInexistantException value
     */
    public OperateurDeTransportObjet.GestionUtilisateursPackage.TransInexistantException value;

    /**
     * Default constructor
     */
    public TransInexistantExceptionHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public TransInexistantExceptionHolder(OperateurDeTransportObjet.GestionUtilisateursPackage.TransInexistantException initial)
    {
        value = initial;
    }

    /**
     * Read TransInexistantException from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = TransInexistantExceptionHelper.read(istream);
    }

    /**
     * Write TransInexistantException into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        TransInexistantExceptionHelper.write(ostream,value);
    }

    /**
     * Return the TransInexistantException TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return TransInexistantExceptionHelper.type();
    }

}
