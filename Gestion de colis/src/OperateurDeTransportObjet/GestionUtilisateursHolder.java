package OperateurDeTransportObjet;

/**
 * Holder class for : GestionUtilisateurs
 * 
 * @author OpenORB Compiler
 */
final public class GestionUtilisateursHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal GestionUtilisateurs value
     */
    public OperateurDeTransportObjet.GestionUtilisateurs value;

    /**
     * Default constructor
     */
    public GestionUtilisateursHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public GestionUtilisateursHolder(OperateurDeTransportObjet.GestionUtilisateurs initial)
    {
        value = initial;
    }

    /**
     * Read GestionUtilisateurs from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = GestionUtilisateursHelper.read(istream);
    }

    /**
     * Write GestionUtilisateurs into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        GestionUtilisateursHelper.write(ostream,value);
    }

    /**
     * Return the GestionUtilisateurs TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return GestionUtilisateursHelper.type();
    }

}
