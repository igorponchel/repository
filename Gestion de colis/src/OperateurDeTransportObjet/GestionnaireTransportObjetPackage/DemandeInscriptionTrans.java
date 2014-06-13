package OperateurDeTransportObjet.GestionnaireTransportObjetPackage;

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
     * Struct member coordonneesBancairesPro
     */
    public OperateurDeTransportObjet.CoordBancairePro coordonneesBancairesPro;

    /**
     * Default constructor
     */
    public DemandeInscriptionTrans()
    { }

    /**
     * Constructor with fields initialization
     * @param nomTransporteur nomTransporteur struct member
     * @param adresseTransporteur adresseTransporteur struct member
     * @param coordonneesBancairesPro coordonneesBancairesPro struct member
     */
    public DemandeInscriptionTrans(String nomTransporteur, OperateurDeTransportObjet.Adresse adresseTransporteur, OperateurDeTransportObjet.CoordBancairePro coordonneesBancairesPro)
    {
        this.nomTransporteur = nomTransporteur;
        this.adresseTransporteur = adresseTransporteur;
        this.coordonneesBancairesPro = coordonneesBancairesPro;
    }

}
