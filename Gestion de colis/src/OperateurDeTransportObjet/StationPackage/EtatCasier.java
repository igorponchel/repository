package OperateurDeTransportObjet.StationPackage;

/**
 * Enum definition : EtatCasier
 *
 * @author OpenORB Compiler
*/
public final class EtatCasier implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Enum member vide value 
     */
    public static final int _vide = 0;

    /**
     * Enum member vide
     */
    public static final EtatCasier vide = new EtatCasier(_vide);

    /**
     * Enum member occupe value 
     */
    public static final int _occupe = 1;

    /**
     * Enum member occupe
     */
    public static final EtatCasier occupe = new EtatCasier(_occupe);

    /**
     * Internal member value 
     */
    private final int _EtatCasier_value;

    /**
     * Private constructor
     * @param  the enum value for this new member
     */
    private EtatCasier( final int value )
    {
        _EtatCasier_value = value;
    }

    /**
     * Maintains singleton property for serialized enums.
     * Issue 4271: IDL/Java issue, Mapping for IDL enum.
     */
    public java.lang.Object readResolve() throws java.io.ObjectStreamException
    {
        return from_int( value() );
    }

    /**
     * Return the internal member value
     * @return the member value
     */
    public int value()
    {
        return _EtatCasier_value;
    }

    /**
     * Return a enum member from its value
     * @param  an enum value
     * @return an enum member
         */
    public static EtatCasier from_int(int value)
    {
        switch (value)
        {
        case 0 :
            return vide;
        case 1 :
            return occupe;
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

    /**
     * Return a string representation
     * @return a string representation of the enumeration
     */
    public java.lang.String toString()
    {
        switch (_EtatCasier_value)
        {
        case 0 :
            return "vide";
        case 1 :
            return "occupe";
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

}
