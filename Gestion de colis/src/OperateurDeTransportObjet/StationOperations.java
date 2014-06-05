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

    /**
     * Operation notifierCodeTransport
     */
    public void notifierCodeTransport(int numeroCasier, String codeTransport);

}
