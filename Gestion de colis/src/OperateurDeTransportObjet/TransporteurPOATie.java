package OperateurDeTransportObjet;

/**
 * Interface definition : Transporteur
 * 
 * @author OpenORB Compiler
 */
public class TransporteurPOATie extends TransporteurPOA
{

    //
    // Private reference to implementation object
    //
    private TransporteurOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public TransporteurPOATie(TransporteurOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public TransporteurPOATie(TransporteurOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public TransporteurOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(TransporteurOperations delegate_)
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
    public void notifierOffreTransport(String nomStationDepart, String nomStationArrivee, String codeTransport)
    {
        _tie.notifierOffreTransport( nomStationDepart,  nomStationArrivee,  codeTransport);
    }

}
