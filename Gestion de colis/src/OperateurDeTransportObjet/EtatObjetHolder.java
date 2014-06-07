package OperateurDeTransportObjet;

/**
 * Holder class for : EtatObjet
 * 
 * @author OpenORB Compiler
 */
final public class EtatObjetHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal EtatObjet value
     */
    public OperateurDeTransportObjet.EtatObjet value;

    /**
     * Default constructor
     */
    public EtatObjetHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public EtatObjetHolder(OperateurDeTransportObjet.EtatObjet initial)
    {
        value = initial;
    }

    /**
     * Read EtatObjet from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = EtatObjetHelper.read(istream);
    }

    /**
     * Write EtatObjet into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        EtatObjetHelper.write(ostream,value);
    }

    /**
     * Return the EtatObjet TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return EtatObjetHelper.type();
    }

}
