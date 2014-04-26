package OperateurDeTransportObjet.GestionUtilisateursPackage;

/**
 * Holder class for : DemandeAdhesion
 * 
 * @author OpenORB Compiler
 */
final public class DemandeAdhesionHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal DemandeAdhesion value
     */
    public OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeAdhesion value;

    /**
     * Default constructor
     */
    public DemandeAdhesionHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public DemandeAdhesionHolder(OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeAdhesion initial)
    {
        value = initial;
    }

    /**
     * Read DemandeAdhesion from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = DemandeAdhesionHelper.read(istream);
    }

    /**
     * Write DemandeAdhesion into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        DemandeAdhesionHelper.write(ostream,value);
    }

    /**
     * Return the DemandeAdhesion TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return DemandeAdhesionHelper.type();
    }

}
