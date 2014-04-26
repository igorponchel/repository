package OperateurDeTransportObjet.StationPackage;

/**
 * Holder class for : EtatCasier
 * 
 * @author OpenORB Compiler
 */
final public class EtatCasierHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal EtatCasier value
     */
    public OperateurDeTransportObjet.StationPackage.EtatCasier value;

    /**
     * Default constructor
     */
    public EtatCasierHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public EtatCasierHolder(OperateurDeTransportObjet.StationPackage.EtatCasier initial)
    {
        value = initial;
    }

    /**
     * Read EtatCasier from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = EtatCasierHelper.read(istream);
    }

    /**
     * Write EtatCasier into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        EtatCasierHelper.write(ostream,value);
    }

    /**
     * Return the EtatCasier TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return EtatCasierHelper.type();
    }

}
