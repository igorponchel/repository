package OperateurDeTransportObjet;

/**
 * Holder class for : Adresse
 * 
 * @author OpenORB Compiler
 */
final public class AdresseHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Adresse value
     */
    public OperateurDeTransportObjet.Adresse value;

    /**
     * Default constructor
     */
    public AdresseHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public AdresseHolder(OperateurDeTransportObjet.Adresse initial)
    {
        value = initial;
    }

    /**
     * Read Adresse from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = AdresseHelper.read(istream);
    }

    /**
     * Write Adresse into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        AdresseHelper.write(ostream,value);
    }

    /**
     * Return the Adresse TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return AdresseHelper.type();
    }

}
