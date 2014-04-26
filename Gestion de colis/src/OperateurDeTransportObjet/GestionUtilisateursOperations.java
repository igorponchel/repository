package OperateurDeTransportObjet;

/**
 * Interface definition : GestionUtilisateurs
 * 
 * @author OpenORB Compiler
 */
public interface GestionUtilisateursOperations
{
    /**
     * Operation demandeAdhesion
     */
    public OperateurDeTransportObjet.GestionUtilisateursPackage.Adhesion demandeAdhesion(OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeAdhesion demandeAdhesion)
        throws OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentExistantException;

    /**
     * Operation demandeInscriptionTrans
     */
    public OperateurDeTransportObjet.GestionUtilisateursPackage.InscriptionTrans demandeInscriptionTrans(OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeInscriptionTrans demandeInscriptionTrans)
        throws OperateurDeTransportObjet.GestionUtilisateursPackage.TransExistantException;

    /**
     * Operation verifierAdherent
     */
    public boolean verifierAdherent(short codeVerif);

    /**
     * Operation verifierTransporteur
     */
    public boolean verifierTransporteur(short codeVerif);

    /**
     * Operation getNumAdherent
     */
    public String getNumAdherent(String nomAdherent, String prenom)
        throws OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentInexistantException;

}
