package OperateurDeTransportObjet;

/**
 * Interface definition : Station
 * 
 * @author OpenORB Compiler
 */
public interface StationOperations
{
    /**
     * Operation reserverCasier
     */
    public int reserverCasier(String idObjet)
        throws OperateurDeTransportObjet.StationPackage.AucunCasierDisponibleException;

}
