package OperateurDeTransportObjet;

/**
 * Holder class for : CoordBancairePro
 * 
 * @author OpenORB Compiler
 */
final public class CoordBancaireProHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal CoordBancairePro value
     */
    public OperateurDeTransportObjet.CoordBancairePro value;

    /**
     * Default constructor
     */
    public CoordBancaireProHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public CoordBancaireProHolder(OperateurDeTransportObjet.CoordBancairePro initial)
    {
        value = initial;
    }

    /**
     * Read CoordBancairePro from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = CoordBancaireProHelper.read(istream);
    }

    /**
     * Write CoordBancairePro into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        CoordBancaireProHelper.write(ostream,value);
    }

    /**
     * Return the CoordBancairePro TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return CoordBancaireProHelper.type();
    }

}
