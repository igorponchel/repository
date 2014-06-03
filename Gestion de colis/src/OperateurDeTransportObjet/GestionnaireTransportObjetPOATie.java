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
     * Operation notifierOffreTransport
     */
    public void notifierOffreTransport(int numeroStation)
    {
        _tie.notifierOffreTransport( numeroStation);
    }

    /**
     * Operation notifierOffreAcceptee
     */
    public void notifierOffreAcceptee(int numeroTransporteur)
    {
        _tie.notifierOffreAcceptee( numeroTransporteur);
    }

    /**
     * Operation verifierTransporteur
     */
    public boolean verifierTransporteur(int numeroTransporteur, String codeTransport)
    {
        return _tie.verifierTransporteur( numeroTransporteur,  codeTransport);
    }

    /**
     * Operation notifierEtatObjet
     */
    public void notifierEtatObjet(int numeroObjet, OperateurDeTransportObjet.GestionnaireTransportObjetPackage.EtatObjet etatObjet)
        throws OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ObjetInexistantException
    {
        _tie.notifierEtatObjet( numeroObjet,  etatObjet);
    }

    /**
     * Operation consulterEtatObjet
     */
    public OperateurDeTransportObjet.GestionnaireTransportObjetPackage.EtatObjet consulterEtatObjet(String numeroObjet)
        throws OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ObjetInexistantException
    {
        return _tie.consulterEtatObjet( numeroObjet);
    }

}
