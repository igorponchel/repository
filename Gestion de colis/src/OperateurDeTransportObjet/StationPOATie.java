package OperateurDeTransportObjet;

/**
 * Interface definition : Station
 * 
 * @author OpenORB Compiler
 */
public class StationPOATie extends StationPOA
{

    //
    // Private reference to implementation object
    //
    private StationOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public StationPOATie(StationOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public StationPOATie(StationOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public StationOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(StationOperations delegate_)
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
     * Operation reserverCasier
     */
    public int reserverCasier(String idObjet)
        throws OperateurDeTransportObjet.StationPackage.AucunCasierDisponibleException
    {
        return _tie.reserverCasier( idObjet);
    }

    /**
     * Operation notifierCodeTransport
     */
    public void notifierCodeTransport(int numeroCasier, String codeTransport)
    {
        _tie.notifierCodeTransport( numeroCasier,  codeTransport);
    }

}
