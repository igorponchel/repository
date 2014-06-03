package OperateurDeTransportObjet;

/**
 * Interface definition : GestionnairePaiement
 * 
 * @author OpenORB Compiler
 */
public class GestionnairePaiementPOATie extends GestionnairePaiementPOA
{

    //
    // Private reference to implementation object
    //
    private GestionnairePaiementOperations _tie;

    //
    // Private reference to POA
    //
    private org.omg.PortableServer.POA _poa;

    /**
     * Constructor
     */
    public GestionnairePaiementPOATie(GestionnairePaiementOperations tieObject)
    {
        _tie = tieObject;
    }

    /**
     * Constructor
     */
    public GestionnairePaiementPOATie(GestionnairePaiementOperations tieObject, org.omg.PortableServer.POA poa)
    {
        _tie = tieObject;
        _poa = poa;
    }

    /**
     * Get the delegate
     */
    public GestionnairePaiementOperations _delegate()
    {
        return _tie;
    }

    /**
     * Set the delegate
     */
    public void _delegate(GestionnairePaiementOperations delegate_)
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
     * Operation debiter
     */
    public short debiter(OperateurDeTransportObjet.CoordBancaire coordonneesBancaires, int somme)
    {
        return _tie.debiter( coordonneesBancaires,  somme);
    }

    /**
     * Operation crediter
     */
    public short crediter(OperateurDeTransportObjet.CoordBancairePro coordonneesBancairesPro, int somme)
    {
        return _tie.crediter( coordonneesBancairesPro,  somme);
    }

}
