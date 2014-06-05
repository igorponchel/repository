package OperateurDeTransportObjet;

/**
 * Interface definition : GestionnaireTransportObjet
 * 
 * @author OpenORB Compiler
 */
public interface GestionnaireTransportObjetOperations
{
    /**
     * Operation notifierOffreTransport
     */
    public String notifierOffreTransport(String nomStationDepart, String nomStationArrivee);

    /**
     * Operation notifierOffreAcceptee
     */
    public String notifierOffreAcceptee(int numeroTransporteur, String numeroOffre);

    /**
     * Operation verifierTransporteur
     */
    public boolean verifierTransporteur(int numeroTransporteur, String codeTransport);

    /**
     * Operation notifierEtatObjet
     */
    public void notifierEtatObjet(String idObjet, OperateurDeTransportObjet.GestionnaireTransportObjetPackage.EtatObjet etatObjet)
        throws OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ObjetInexistantException;

    /**
     * Operation consulterEtatObjet
     */
    public OperateurDeTransportObjet.GestionnaireTransportObjetPackage.EtatObjet consulterEtatObjet(String idObjet)
        throws OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ObjetInexistantException;

}
