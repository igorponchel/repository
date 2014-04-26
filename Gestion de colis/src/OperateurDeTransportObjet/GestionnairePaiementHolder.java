package OperateurDeTransportObjet;

/**
 * Holder class for : GestionnairePaiement
 * 
 * @author OpenORB Compiler
 */
final public class GestionnairePaiementHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal GestionnairePaiement value
     */
    public OperateurDeTransportObjet.GestionnairePaiement value;

    /**
     * Default constructor
     */
    public GestionnairePaiementHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public GestionnairePaiementHolder(OperateurDeTransportObjet.GestionnairePaiement initial)
    {
        value = initial;
    }

    /**
     * Read GestionnairePaiement from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = GestionnairePaiementHelper.read(istream);
    }

    /**
     * Write GestionnairePaiement into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        GestionnairePaiementHelper.write(ostream,value);
    }

    /**
     * Return the GestionnairePaiement TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return GestionnairePaiementHelper.type();
    }

}
