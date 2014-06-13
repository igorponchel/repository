package OperateurDeTransportObjet;

/**
 * Interface definition : GestionnaireTransportObjet
 * 
 * @author OpenORB Compiler
 */
public class GestionnaireTransportObjetPOATie extends GestionnaireTransportObjetPOA
{

    //
    // Private reference to implementation object
    //
    private GestionnaireTransportObjetOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public GestionnaireTransportObjetPOATie(GestionnaireTransportObjetOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public GestionnaireTransportObjetPOATie(GestionnaireTransportObjetOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public GestionnaireTransportObjetOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(GestionnaireTransportObjetOperations delegate_)
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
     * Operation demandeInscriptionTrans
     */
    public OperateurDeTransportObjet.GestionnaireTransportObjetPackage.InscriptionTrans demandeInscriptionTrans(OperateurDeTransportObjet.GestionnaireTransportObjetPackage.DemandeInscriptionTrans demandeInscriptionTrans)
        throws OperateurDeTransportObjet.GestionnaireTransportObjetPackage.TransExistantException
    {
        return _tie.demandeInscriptionTrans( demandeInscriptionTrans);
    }

    /**
     * Operation notifierOffreTransport
     */
    public String notifierOffreTransport(String nomStationDepart, String nomStationArrivee)
    {
        return _tie.notifierOffreTransport( nomStationDepart,  nomStationArrivee);
    }

    /**
     * Operation notifierOffreAcceptee
     */
    public String notifierOffreAcceptee(int numeroTransporteur, String numeroOffre)
    {
        return _tie.notifierOffreAcceptee( numeroTransporteur,  numeroOffre);
    }

    /**
     * Operation verifierTransporteur
     */
    public boolean verifierTransporteur(int numeroTransporteur, String codeTransport)
    {
        return _tie.verifierTransporteur( numeroTransporteur,  codeTransport);
    }

    /**
     * Operation enregistrerObjet
     */
    public void enregistrerObjet(OperateurDeTransportObjet.Objet objet)
    {
        _tie.enregistrerObjet( objet);
    }

    /**
     * Operation notifierEtatObjet
     */
    public void notifierEtatObjet(String idObjet, OperateurDeTransportObjet.EtatObjet etatObjet)
        throws OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ObjetInexistantException
    {
        _tie.notifierEtatObjet( idObjet,  etatObjet);
    }

    /**
     * Operation consulterEtatObjet
     */
    public OperateurDeTransportObjet.InfoObjet[] consulterEtatObjet(int numeroAdherent)
        throws OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ObjetInexistantException
    {
        return _tie.consulterEtatObjet( numeroAdherent);
    }

    /**
     * Operation notifierConnexion
     */
    public void notifierConnexion(int numeroTransporteur, OperateurDeTransportObjet.Transporteur transporteur)
    {
        _tie.notifierConnexion( numeroTransporteur,  transporteur);
    }

    /**
     * Operation notifierDeconnexion
     */
    public void notifierDeconnexion(int numeroTransporteur)
    {
        _tie.notifierDeconnexion( numeroTransporteur);
    }

}
