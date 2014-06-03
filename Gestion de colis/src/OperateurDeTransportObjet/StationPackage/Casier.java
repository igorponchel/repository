package OperateurDeTransportObjet.StationPackage;

/**
 * Struct definition : Casier
 * 
 * @author OpenORB Compiler
*/
public final class Casier implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member numeroCasier
     */
    public int numeroCasier;

    /**
     * Struct member etatCasier
     */
    public OperateurDeTransportObjet.StationPackage.EtatCasier etatCasier;

    /**
     * Default constructor
     */
    public Casier()
    { }

    /**
     * Constructor with fields initialization
     * @param numeroCasier numeroCasier struct member
     * @param etatCasier etatCasier struct member
     */
    public Casier(int numeroCasier, OperateurDeTransportObjet.StationPackage.EtatCasier etatCasier)
    {
        this.numeroCasier = numeroCasier;
        this.etatCasier = etatCasier;
    }

}
