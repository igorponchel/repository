package OperateurDeTransportObjet.GestionUtilisateursPackage;

/**
 * Holder class for : Adhesion
 * 
 * @author OpenORB Compiler
 */
final public class AdhesionHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Adhesion value
     */
    public OperateurDeTransportObjet.GestionUtilisateursPackage.Adhesion value;

    /**
     * Default constructor
     */
    public AdhesionHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public AdhesionHolder(OperateurDeTransportObjet.GestionUtilisateursPackage.Adhesion initial)
    {
        value = initial;
    }

    /**
     * Read Adhesion from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = AdhesionHelper.read(istream);
    }

    /**
     * Write Adhesion into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        AdhesionHelper.write(ostream,value);
    }

    /**
     * Return the Adhesion TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return AdhesionHelper.type();
    }

}
