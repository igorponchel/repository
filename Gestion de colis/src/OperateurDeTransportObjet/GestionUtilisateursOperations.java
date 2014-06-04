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
    public boolean verifierAdherent(int numeroAdherent, String motDePasse);

    /**
     * Operation verifierTransporteur
     */
    public boolean verifierTransporteur(short codeVerif);

    /**
     * Operation getNumAdherent
     */
    public int getNumAdherent(String nomAdherent, String prenomAdherent)
        throws OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentInexistantException;

    /**
     * Operation getZoneAdherent
     */
    public int getZoneAdherent(String nomAdherent, String prenomAdherent)
        throws OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentInexistantException;

}
