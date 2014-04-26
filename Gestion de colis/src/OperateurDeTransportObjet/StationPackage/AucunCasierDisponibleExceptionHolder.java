package OperateurDeTransportObjet.StationPackage;

/**
 * Holder class for : AucunCasierDisponibleException
 * 
 * @author OpenORB Compiler
 */
final public class AucunCasierDisponibleExceptionHolder
        implements org.omg.CORBA.portable.Streamable
{
    /**
     * Internal AucunCasierDisponibleException value
     */
    public OperateurDeTransportObjet.StationPackage.AucunCasierDisponibleException value;

    /**
     * Default constructor
     */
    public AucunCasierDisponibleExceptionHolder()
    { }

    /**
     * Constructor with value initialisation
     * @param initial the initial value
     */
    public AucunCasierDisponibleExceptionHolder(OperateurDeTransportObjet.StationPackage.AucunCasierDisponibleException initial)
    {
        value = initial;
    }

    /**
     * Read AucunCasierDisponibleException from a marshalled stream
     * @param istream the input stream
     */
    public void _read(org.omg.CORBA.portable.InputStream istream)
    {
        value = AucunCasierDisponibleExceptionHelper.read(istream);
    }

    /**
     * Write AucunCasierDisponibleException into a marshalled stream
     * @param ostream the output stream
     */
    public void _write(org.omg.CORBA.portable.OutputStream ostream)
    {
        AucunCasierDisponibleExceptionHelper.write(ostream,value);
    }

    /**
     * Return the AucunCasierDisponibleException TypeCode
     * @return a TypeCode
     */
    public org.omg.CORBA.TypeCode _type()
    {
        return AucunCasierDisponibleExceptionHelper.type();
    }

}
