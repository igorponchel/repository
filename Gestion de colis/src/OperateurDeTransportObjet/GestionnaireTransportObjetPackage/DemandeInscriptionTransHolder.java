package OperateurDeTransportObjet.GestionnaireTransportObjetPackage;

/**
 * Holder class for : DemandeInscriptionTrans
 * 
 * @author OpenORB Compiler
 */
final public class DemandeInscriptionTransHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal DemandeInscriptionTrans value
     */
    public OperateurDeTransportObjet.GestionnaireTransportObjetPackage.DemandeInscriptionTrans value;

    /**
     * Default constructor
     */
    public DemandeInscriptionTransHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public DemandeInscriptionTransHolder(OperateurDeTransportObjet.GestionnaireTransportObjetPackage.DemandeInscriptionTrans initial)
    {
        value = initial;
    }

    /**
     * Read DemandeInscriptionTrans from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = DemandeInscriptionTransHelper.read(istream);
    }

    /**
     * Write DemandeInscriptionTrans into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        DemandeInscriptionTransHelper.write(ostream,value);
    }

    /**
     * Return the DemandeInscriptionTrans TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return DemandeInscriptionTransHelper.type();
    }

}
