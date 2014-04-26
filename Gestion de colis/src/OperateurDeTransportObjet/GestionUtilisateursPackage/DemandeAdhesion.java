package OperateurDeTransportObjet.GestionUtilisateursPackage;

/**
 * Struct definition : DemandeAdhesion
 * 
 * @author OpenORB Compiler
*/
public final class DemandeAdhesion implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member prenomAdherent
     */
    public String prenomAdherent;

    /**
     * Struct member nomAdherent
     */
    public String nomAdherent;

    /**
     * Struct member adresseAdherent
     */
    public OperateurDeTransportObjet.Adresse adresseAdherent;

    /**
     * Struct member coordonneesBancaires
     */
    public OperateurDeTransportObjet.CoordBancaire coordonneesBancaires;

    /**
     * Default constructor
     */
    public DemandeAdhesion()
    { }

    /**
     * Constructor with fields initialization
     * @param prenomAdherent prenomAdherent struct member
     * @param nomAdherent nomAdherent struct member
     * @param adresseAdherent adresseAdherent struct member
     * @param coordonneesBancaires coordonneesBancaires struct member
     */
    public DemandeAdhesion(String prenomAdherent, String nomAdherent, OperateurDeTransportObjet.Adresse adresseAdherent, OperateurDeTransportObjet.CoordBancaire coordonneesBancaires)
    {
        this.prenomAdherent = prenomAdherent;
        this.nomAdherent = nomAdherent;
        this.adresseAdherent = adresseAdherent;
        this.coordonneesBancaires = coordonneesBancaires;
    }

}
