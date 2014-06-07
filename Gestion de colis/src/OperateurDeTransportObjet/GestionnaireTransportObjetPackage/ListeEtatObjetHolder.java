package OperateurDeTransportObjet.GestionnaireTransportObjetPackage;

/**
 * Holder class for : ListeEtatObjet
 * 
 * @author OpenORB Compiler
 */
final public class ListeEtatObjetHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal ListeEtatObjet value
     */
    public OperateurDeTransportObjet.EtatObjet[] value;

    /**
     * Default constructor
     */
    public ListeEtatObjetHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public ListeEtatObjetHolder(OperateurDeTransportObjet.EtatObjet[] initial)
    {
        value = initial;
    }

    /**
     * Read ListeEtatObjet from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = ListeEtatObjetHelper.read(istream);
    }

    /**
     * Write ListeEtatObjet into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        ListeEtatObjetHelper.write(ostream,value);
    }

    /**
     * Return the ListeEtatObjet TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return ListeEtatObjetHelper.type();
    }

}
