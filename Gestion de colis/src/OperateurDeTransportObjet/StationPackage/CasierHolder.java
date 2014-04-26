package OperateurDeTransportObjet.StationPackage;

/**
 * Holder class for : Casier
 * 
 * @author OpenORB Compiler
 */
final public class CasierHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Casier value
     */
    public OperateurDeTransportObjet.StationPackage.Casier value;

    /**
     * Default constructor
     */
    public CasierHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public CasierHolder(OperateurDeTransportObjet.StationPackage.Casier initial)
    {
        value = initial;
    }

    /**
     * Read Casier from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = CasierHelper.read(istream);
    }

    /**
     * Write Casier into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        CasierHelper.write(ostream,value);
    }

    /**
     * Return the Casier TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return CasierHelper.type();
    }

}
