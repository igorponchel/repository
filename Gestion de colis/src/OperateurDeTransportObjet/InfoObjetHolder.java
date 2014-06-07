package OperateurDeTransportObjet;

/**
 * Holder class for : InfoObjet
 * 
 * @author OpenORB Compiler
 */
final public class InfoObjetHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal InfoObjet value
     */
    public OperateurDeTransportObjet.InfoObjet value;

    /**
     * Default constructor
     */
    public InfoObjetHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public InfoObjetHolder(OperateurDeTransportObjet.InfoObjet initial)
    {
        value = initial;
    }

    /**
     * Read InfoObjet from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = InfoObjetHelper.read(istream);
    }

    /**
     * Write InfoObjet into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        InfoObjetHelper.write(ostream,value);
    }

    /**
     * Return the InfoObjet TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return InfoObjetHelper.type();
    }

}
