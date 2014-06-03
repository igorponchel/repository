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
    public void notifierOffreTransport(int numeroStation);

    /**
     * Operation notifierOffreAcceptee
     */
    public void notifierOffreAcceptee(int numeroTransporteur);

    /**
     * Operation verifierTransporteur
     */
    public boolean verifierTransporteur(int numeroTransporteur, String codeTransport);

    /**
     * Operation notifierEtatObjet
     */
    public void notifierEtatObjet(int numeroObjet, OperateurDeTransportObjet.GestionnaireTransportObjetPackage.EtatObjet etatObjet)
        throws OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ObjetInexistantException;

    /**
     * Operation consulterEtatObjet
     */
    public OperateurDeTransportObjet.GestionnaireTransportObjetPackage.EtatObjet consulterEtatObjet(String numeroObjet)
        throws OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ObjetInexistantException;

}
