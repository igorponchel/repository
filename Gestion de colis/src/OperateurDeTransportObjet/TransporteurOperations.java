package OperateurDeTransportObjet;

/**
 * Interface definition : Transporteur
 * 
 * @author OpenORB Compiler
 */
public interface TransporteurOperations
{
    /**
     * Operation notifierOffreTransport
     */
    public void notifierOffreTransport(String nomStationDepart, String nomStationArrivee, String numeroOffre);

    /**
     * Operation notifierOffrePriseEnCharge
     */
    public void notifierOffrePriseEnCharge(String numeroOffre);

}
