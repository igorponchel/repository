package OperateurDeTransportObjet.GestionUtilisateursPackage;

/**
 * Holder class for : InscriptionTrans
 * 
 * @author OpenORB Compiler
 */
final public class InscriptionTransHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal InscriptionTrans value
     */
    public OperateurDeTransportObjet.GestionUtilisateursPackage.InscriptionTrans value;

    /**
     * Default constructor
     */
    public InscriptionTransHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public InscriptionTransHolder(OperateurDeTransportObjet.GestionUtilisateursPackage.InscriptionTrans initial)
    {
        value = initial;
    }

    /**
     * Read InscriptionTrans from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = InscriptionTransHelper.read(istream);
    }

    /**
     * Write InscriptionTrans into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        InscriptionTransHelper.write(ostream,value);
    }

    /**
     * Return the InscriptionTrans TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return InscriptionTransHelper.type();
    }

}
