package OperateurDeTransportObjet;

/**
 * Holder class for : Adherent
 * 
 * @author OpenORB Compiler
 */
final public class AdherentHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Adherent value
     */
    public OperateurDeTransportObjet.Adherent value;

    /**
     * Default constructor
     */
    public AdherentHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public AdherentHolder(OperateurDeTransportObjet.Adherent initial)
    {
        value = initial;
    }

    /**
     * Read Adherent from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = AdherentHelper.read(istream);
    }

    /**
     * Write Adherent into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        AdherentHelper.write(ostream,value);
    }

    /**
     * Return the Adherent TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return AdherentHelper.type();
    }

}
