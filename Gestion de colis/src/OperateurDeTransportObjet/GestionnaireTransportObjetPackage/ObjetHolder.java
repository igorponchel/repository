package OperateurDeTransportObjet.GestionnaireTransportObjetPackage;

/**
 * Holder class for : Objet
 * 
 * @author OpenORB Compiler
 */
final public class ObjetHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal Objet value
     */
    public OperateurDeTransportObjet.GestionnaireTransportObjetPackage.Objet value;

    /**
     * Default constructor
     */
    public ObjetHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ObjetHolder(OperateurDeTransportObjet.GestionnaireTransportObjetPackage.Objet initial)
    {
        value = initial;
    }

    /**
     * Read Objet from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ObjetHelper.read(istream);
    }

    /**
     * Write Objet into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ObjetHelper.write(ostream,value);
    }

    /**
     * Return the Objet TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ObjetHelper.type();
    }

}
