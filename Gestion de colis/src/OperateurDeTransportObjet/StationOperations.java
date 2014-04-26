package OperateurDeTransportObjet;

/**
 * Interface definition : Station
 * 
 * @author OpenORB Compiler
 */
public interface StationOperations
{
    /**
     * Operation verifierDispoCasier
     */
    public boolean verifierDispoCasier();

    /**
     * Operation reserverCasier
     */
    public int reserverCasier(String codeTransport)
        throws OperateurDeTransportObjet.StationPackage.AucunCasierDisponibleException;

}
