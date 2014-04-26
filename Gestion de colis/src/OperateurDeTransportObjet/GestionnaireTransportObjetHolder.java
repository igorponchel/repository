package OperateurDeTransportObjet;

/**
 * Holder class for : GestionnaireTransportObjet
 * 
 * @author OpenORB Compiler
 */
final public class GestionnaireTransportObjetHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal GestionnaireTransportObjet value
     */
    public OperateurDeTransportObjet.GestionnaireTransportObjet value;

    /**
     * Default constructor
     */
    public GestionnaireTransportObjetHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public GestionnaireTransportObjetHolder(OperateurDeTransportObjet.GestionnaireTransportObjet initial)
    {
        value = initial;
    }

    /**
     * Read GestionnaireTransportObjet from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = GestionnaireTransportObjetHelper.read(istream);
    }

    /**
     * Write GestionnaireTransportObjet into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        GestionnaireTransportObjetHelper.write(ostream,value);
    }

    /**
     * Return the GestionnaireTransportObjet TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return GestionnaireTransportObjetHelper.type();
    }

}
