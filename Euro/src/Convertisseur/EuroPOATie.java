package Convertisseur;

/**
 * Interface definition : Euro
 * 
 * @author OpenORB Compiler
 */
public class EuroPOATie extends EuroPOA
{

    //
    // Private reference to implementation object
    //
    private EuroOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public EuroPOATie(EuroOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public EuroPOATie(EuroOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public EuroOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(EuroOperations delegate_)
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
     * Read accessor for taux attribute
     */
    public double taux()
    {
        return _tie.taux();
    }

    /**
     * Write accessor for taux attribute
     */
    public void taux(double value)
    {
        _tie.taux(value);
    }

    /**
     * Read accessor for devise attribute
     */
    public String devise()
    {
        return _tie.devise();
    }

    /**
     * Write accessor for devise attribute
     */
    public void devise(String value)
    {
        _tie.devise(value);
    }

    /**
     * Operation toEuro
     */
    public double toEuro(double devise)
    {
        return _tie.toEuro( devise);
    }

    /**
     * Operation toDevise
     */
    public double toDevise(double euro)
    {
        return _tie.toDevise( euro);
    }

}
