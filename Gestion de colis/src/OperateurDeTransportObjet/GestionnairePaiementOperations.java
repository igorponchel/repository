package OperateurDeTransportObjet;

/**
 * Interface definition : GestionnairePaiement
 * 
 * @author OpenORB Compiler
 */
public interface GestionnairePaiementOperations
{
    /**
     * Operation debiter
     */
    public short debiter(OperateurDeTransportObjet.CoordBancaire coordonneesBancaires, int somme);

    /**
     * Operation crediter
     */
    public short crediter(OperateurDeTransportObjet.CoordBancaire coordonneesBancaires, int somme);

}
