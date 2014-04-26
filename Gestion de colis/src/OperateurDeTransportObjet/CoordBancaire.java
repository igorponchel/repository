package OperateurDeTransportObjet;

/**
 * Struct definition : CoordBancaire
 * 
 * @author OpenORB Compiler
*/
public final class CoordBancaire implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member numeroCarte
     */
    public int numeroCarte;

    /**
     * Struct member proprietaire
     */
    public String proprietaire;

    /**
     * Struct member date
     */
    public String date;

    /**
     * Struct member numDos
     */
    public int numDos;

    /**
     * Default constructor
     */
    public CoordBancaire()
    { }

    /**
     * Constructor with fields initialization
     * @param numeroCarte numeroCarte struct member
     * @param proprietaire proprietaire struct member
     * @param date date struct member
     * @param numDos numDos struct member
     */
    public CoordBancaire(int numeroCarte, String proprietaire, String date, int numDos)
    {
        this.numeroCarte = numeroCarte;
        this.proprietaire = proprietaire;
        this.date = date;
        this.numDos = numDos;
    }

}
