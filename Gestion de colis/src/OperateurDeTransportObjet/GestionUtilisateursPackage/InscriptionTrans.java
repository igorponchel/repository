package OperateurDeTransportObjet.GestionUtilisateursPackage;

/**
 * Struct definition : InscriptionTrans
 * 
 * @author OpenORB Compiler
*/
public final class InscriptionTrans implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member numeroInscritTrans
     */
    public String numeroInscritTrans;

    /**
     * Struct member nomTransporteur
     */
    public String nomTransporteur;

    /**
     * Default constructor
     */
    public InscriptionTrans()
    { }

    /**
     * Constructor with fields initialization
     * @param numeroInscritTrans numeroInscritTrans struct member
     * @param nomTransporteur nomTransporteur struct member
     */
    public InscriptionTrans(String numeroInscritTrans, String nomTransporteur)
    {
        this.numeroInscritTrans = numeroInscritTrans;
        this.nomTransporteur = nomTransporteur;
    }

}
