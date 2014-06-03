package OperateurDeTransportObjet;

/**
 * Struct definition : CoordBancairePro
 * 
 * @author OpenORB Compiler
*/
public final class CoordBancairePro implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member codeBanque
     */
    public int codeBanque;

    /**
     * Struct member codeGuichet
     */
    public int codeGuichet;

    /**
     * Struct member numCompte
     */
    public int numCompte;

    /**
     * Struct member cleRIB
     */
    public int cleRIB;

    /**
     * Default constructor
     */
    public CoordBancairePro()
    { }

    /**
     * Constructor with fields initialization
     * @param codeBanque codeBanque struct member
     * @param codeGuichet codeGuichet struct member
     * @param numCompte numCompte struct member
     * @param cleRIB cleRIB struct member
     */
    public CoordBancairePro(int codeBanque, int codeGuichet, int numCompte, int cleRIB)
    {
        this.codeBanque = codeBanque;
        this.codeGuichet = codeGuichet;
        this.numCompte = numCompte;
        this.cleRIB = cleRIB;
    }

}
