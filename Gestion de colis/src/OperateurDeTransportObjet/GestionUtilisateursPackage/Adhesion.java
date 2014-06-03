package OperateurDeTransportObjet.GestionUtilisateursPackage;

/**
 * Struct definition : Adhesion
 * 
 * @author OpenORB Compiler
*/
public final class Adhesion implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member numeroAdherent
     */
    public int numeroAdherent;

    /**
     * Struct member nomAdherent
     */
    public String nomAdherent;

    /**
     * Struct member prenomAdherent
     */
    public String prenomAdherent;

    /**
     * Struct member zoneAdherent
     */
    public int zoneAdherent;

    /**
     * Default constructor
     */
    public Adhesion()
    { }

    /**
     * Constructor with fields initialization
     * @param numeroAdherent numeroAdherent struct member
     * @param nomAdherent nomAdherent struct member
     * @param prenomAdherent prenomAdherent struct member
     * @param zoneAdherent zoneAdherent struct member
     */
    public Adhesion(int numeroAdherent, String nomAdherent, String prenomAdherent, int zoneAdherent)
    {
        this.numeroAdherent = numeroAdherent;
        this.nomAdherent = nomAdherent;
        this.prenomAdherent = prenomAdherent;
        this.zoneAdherent = zoneAdherent;
    }

}
