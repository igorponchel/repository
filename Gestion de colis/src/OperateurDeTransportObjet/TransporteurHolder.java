package OperateurDeTransportObjet;

/**
 * Holder class for : Transporteur
 * 
 * @author OpenORB Compiler
 */
final public class TransporteurHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Transporteur value
     */
    public OperateurDeTransportObjet.Transporteur value;

    /**
     * Default constructor
     */
    public TransporteurHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public TransporteurHolder(OperateurDeTransportObjet.Transporteur initial)
    {
        value = initial;
    }

    /**
     * Read Transporteur from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = TransporteurHelper.read(istream);
    }

    /**
     * Write Transporteur into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        TransporteurHelper.write(ostream,value);
    }

    /**
     * Return the Transporteur TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return TransporteurHelper.type();
    }

}
