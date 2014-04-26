package OperateurDeTransportObjet.GestionnaireTransportObjetPackage;

/**
 * Enum definition : EtatObjet
 *
 * @author OpenORB Compiler
*/
public final class EtatObjet implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Enum member depose value 
     */
    public static final int _depose = 0;

    /**
     * Enum member depose
     */
    public static final EtatObjet depose = new EtatObjet(_depose);

    /**
     * Enum member enTransit value 
     */
    public static final int _enTransit = 1;

    /**
     * Enum member enTransit
     */
    public static final EtatObjet enTransit = new EtatObjet(_enTransit);

    /**
     * Enum member livre value 
     */
    public static final int _livre = 2;

    /**
     * Enum member livre
     */
    public static final EtatObjet livre = new EtatObjet(_livre);

    /**
     * Enum member delivre value 
     */
    public static final int _delivre = 3;

    /**
     * Enum member delivre
     */
    public static final EtatObjet delivre = new EtatObjet(_delivre);

    /**
     * Internal member value 
     */
    private final int _EtatObjet_value;

    /**
     * Private constructor
     * @param  the enum value for this new member
     */
    private EtatObjet( final int value )
    {
        _EtatObjet_value = value;
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
        return _EtatObjet_value;
    }

    /**
     * Return a enum member from its value
     * @param  an enum value
     * @return an enum member
         */
    public static EtatObjet from_int(int value)
    {
        switch (value)
        {
        case 0 :
            return depose;
        case 1 :
            return enTransit;
        case 2 :
            return livre;
        case 3 :
            return delivre;
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

    /**
     * Return a string representation
     * @return a string representation of the enumeration
     */
    public java.lang.String toString()
    {
        switch (_EtatObjet_value)
        {
        case 0 :
            return "depose";
        case 1 :
            return "enTransit";
        case 2 :
            return "livre";
        case 3 :
            return "delivre";
        }
        throw new org.omg.CORBA.BAD_OPERATION();
    }

}
