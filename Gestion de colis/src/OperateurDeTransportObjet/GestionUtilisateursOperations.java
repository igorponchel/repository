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
     * Operation verifierAdherent
     */
    public boolean verifierAdherent(int numeroAdherent, String motDePasse);

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

    /**
     * Operation notifierConnexionAdh
     */
    public void notifierConnexionAdh(int numeroAdherent, OperateurDeTransportObjet.Adherent adherent);

    /**
     * Operation notifierDeconnexionAdh
     */
    public void notifierDeconnexionAdh(int numeroAdherent);

    /**
     * Operation getAdherentSiConnecte
     */
    public OperateurDeTransportObjet.Adherent getAdherentSiConnecte(int numeroAdherent);

}
