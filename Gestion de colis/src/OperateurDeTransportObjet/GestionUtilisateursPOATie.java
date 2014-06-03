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
     * Operation demandeInscriptionTrans
     */
    public OperateurDeTransportObjet.GestionUtilisateursPackage.InscriptionTrans demandeInscriptionTrans(OperateurDeTransportObjet.GestionUtilisateursPackage.DemandeInscriptionTrans demandeInscriptionTrans)
        throws OperateurDeTransportObjet.GestionUtilisateursPackage.TransExistantException
    {
        return _tie.demandeInscriptionTrans( demandeInscriptionTrans);
    }

    /**
     * Operation verifierAdherent
     */
    public boolean verifierAdherent(short codeVerif)
    {
        return _tie.verifierAdherent( codeVerif);
    }

    /**
     * Operation verifierTransporteur
     */
    public boolean verifierTransporteur(short codeVerif)
    {
        return _tie.verifierTransporteur( codeVerif);
    }

    /**
     * Operation getNumAdherent
     */
    public int getNumAdherent(String nomAdherent, String prenomAdherent)
        throws OperateurDeTransportObjet.GestionUtilisateursPackage.AdherentInexistantException
    {
        return _tie.getNumAdherent( nomAdherent,  prenomAdherent);
    }

}
