package OperateurDeTransportObjet;

/**
 * Holder class for : CoordBancaire
 * 
 * @author OpenORB Compiler
 */
final public class CoordBancaireHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal CoordBancaire value
     */
    public OperateurDeTransportObjet.CoordBancaire value;

    /**
     * Default constructor
     */
    public CoordBancaireHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public CoordBancaireHolder(OperateurDeTransportObjet.CoordBancaire initial)
    {
        value = initial;
    }

    /**
     * Read CoordBancaire from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = CoordBancaireHelper.read(istream);
    }

    /**
     * Write CoordBancaire into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        CoordBancaireHelper.write(ostream,value);
    }

    /**
     * Return the CoordBancaire TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return CoordBancaireHelper.type();
    }

}
