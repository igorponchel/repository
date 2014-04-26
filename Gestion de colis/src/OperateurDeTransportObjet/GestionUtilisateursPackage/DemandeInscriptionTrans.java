package OperateurDeTransportObjet.GestionUtilisateursPackage;

/**
 * Struct definition : DemandeInscriptionTrans
 * 
 * @author OpenORB Compiler
*/
public final class DemandeInscriptionTrans implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member nomTransporteur
     */
    public String nomTransporteur;

    /**
     * Struct member adresseTransporteur
     */
    public OperateurDeTransportObjet.Adresse adresseTransporteur;

    /**
     * Struct member coordonneesBancaires
     */
    public OperateurDeTransportObjet.CoordBancaire coordonneesBancaires;

    /**
     * Default constructor
     */
    public DemandeInscriptionTrans()
    { }

    /**
     * Constructor with fields initialization
     * @param nomTransporteur nomTransporteur struct member
     * @param adresseTransporteur adresseTransporteur struct member
     * @param coordonneesBancaires coordonneesBancaires struct member
     */
    public DemandeInscriptionTrans(String nomTransporteur, OperateurDeTransportObjet.Adresse adresseTransporteur, OperateurDeTransportObjet.CoordBancaire coordonneesBancaires)
    {
        this.nomTransporteur = nomTransporteur;
        this.adresseTransporteur = adresseTransporteur;
        this.coordonneesBancaires = coordonneesBancaires;
    }

}
