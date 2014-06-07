package OperateurDeTransportObjet.GestionnaireTransportObjetPackage;

/**
 * Holder class for : ListeInfoObjet
 * 
 * @author OpenORB Compiler
 */
final public class ListeInfoObjetHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ListeInfoObjet value
     */
    public OperateurDeTransportObjet.InfoObjet[] value;

    /**
     * Default constructor
     */
    public ListeInfoObjetHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ListeInfoObjetHolder(OperateurDeTransportObjet.InfoObjet[] initial)
    {
        value = initial;
    }

    /**
     * Read ListeInfoObjet from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ListeInfoObjetHelper.read(istream);
    }

    /**
     * Write ListeInfoObjet into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ListeInfoObjetHelper.write(ostream,value);
    }

    /**
     * Return the ListeInfoObjet TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ListeInfoObjetHelper.type();
    }

}
