package OperateurDeTransportObjet;

/**
 * Struct definition : Adresse
 * 
 * @author OpenORB Compiler
*/
public final class Adresse implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member numeroRue
     */
    public String numeroRue;

    /**
     * Struct member nomRue
     */
    public String nomRue;

    /**
     * Struct member ville
     */
    public String ville;

    /**
     * Struct member pays
     */
    public String pays;

    /**
     * Default constructor
     */
    public Adresse()
    { }

    /**
     * Constructor with fields initialization
     * @param numeroRue numeroRue struct member
     * @param nomRue nomRue struct member
     * @param ville ville struct member
     * @param pays pays struct member
     */
    public Adresse(String numeroRue, String nomRue, String ville, String pays)
    {
        this.numeroRue = numeroRue;
        this.nomRue = nomRue;
        this.ville = ville;
        this.pays = pays;
    }

}
