package OperateurDeTransportObjet;

/**
 * Holder class for : Station
 * 
 * @author OpenORB Compiler
 */
final public class StationHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Station value
     */
    public OperateurDeTransportObjet.Station value;

    /**
     * Default constructor
     */
    public StationHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public StationHolder(OperateurDeTransportObjet.Station initial)
    {
        value = initial;
    }

    /**
     * Read Station from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = StationHelper.read(istream);
    }

    /**
     * Write Station into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        StationHelper.write(ostream,value);
    }

    /**
     * Return the Station TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return StationHelper.type();
    }

}
