package Convertisseur;

/**
 * Holder class for : Euro
 * 
 * @author OpenORB Compiler
 */
final public class EuroHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Euro value
     */
    public Convertisseur.Euro value;

    /**
     * Default constructor
     */
    public EuroHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public EuroHolder(Convertisseur.Euro initial)
    {
        value = initial;
    }

    /**
     * Read Euro from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = EuroHelper.read(istream);
    }

    /**
     * Write Euro into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        EuroHelper.write(ostream,value);
    }

    /**
     * Return the Euro TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return EuroHelper.type();
    }

}
