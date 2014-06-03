package OperateurDeTransportObjet;

/**
 * Interface definition : Adherent
 * 
 * @author OpenORB Compiler
 */
public class AdherentPOATie extends AdherentPOA
{

    //
    // Private reference to implementation object
    //
    private AdherentOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public AdherentPOATie(AdherentOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public AdherentPOATie(AdherentOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public AdherentOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(AdherentOperations delegate_)
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
     * Operation notifierColisArrive
     */
    public void notifierColisArrive(int numeroObjet)
    {
        _tie.notifierColisArrive( numeroObjet);
    }

}
