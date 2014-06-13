package OperateurDeTransportObjet;

/**
 * Interface definition : GestionUtilisateurs
 * 
 * @author OpenORB Compiler
 */
public class GestionUtilisateursPOATie extends GestionUtilisateursPOA
{

    //
    // Private reference to implementation object
    //
    private GestionUtilisateursOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public GestionUtilisateursPOATie(GestionUtilisateursOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public GestionUtilisateursPOATie(GestionUtilisateursOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public GestionUtilisateursOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(GestionUtilisateursOperations delegate_)
    {
        _tie = delegate_;
    }

    /**
     * _default_POA method
     */
    public org.omg.PortableServer.POA _default_POA()
    {
        if (_poa != null)
            return _poa;
        else
            return super._default_POA();
    }

    /**
     * Operation demandeAdhesion
     */
    public OperateurDeTransportObjet.GestionUtilisateursPackage.Adhesion demandeAdhesion(OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeAdhesion demandeAdhesion)
        throws OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentExistantException
    {
        return _tie.demandeAdhesion( demandeAdhesion);
    }

    /**
     * Operation verifierAdherent
     */
    public boolean verifierAdherent(int numeroAdherent, String motDePasse)
    {
        return _tie.verifierAdherent( numeroAdherent,  motDePasse);
    }

    /**
     * Operation getNumAdherent
     */
    public int getNumAdherent(String nomAdherent, String prenomAdherent)
        throws OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentInexistantException
    {
        return _tie.getNumAdherent( nomAdherent,  prenomAdherent);
    }

    /**
     * Operation getZoneAdherent
     */
    public int getZoneAdherent(String nomAdherent, String prenomAdherent)
        throws OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentInexistantException
    {
        return _tie.getZoneAdherent( nomAdherent,  prenomAdherent);
    }

    /**
     * Operation notifierConnexionAdh
     */
    public void notifierConnexionAdh(int numeroAdherent, OperateurDeTransportObjet.Adherent adherent)
    {
        _tie.notifierConnexionAdh( numeroAdherent,  adherent);
    }

    /**
     * Operation notifierDeconnexionAdh
     */
    public void notifierDeconnexionAdh(int numeroAdherent)
    {
        _tie.notifierDeconnexionAdh( numeroAdherent);
    }

    /**
     * Operation getAdherentSiConnecte
     */
    public OperateurDeTransportObjet.Adherent getAdherentSiConnecte(int numeroAdherent)
    {
        return _tie.getAdherentSiConnecte( numeroAdherent);
    }

}
