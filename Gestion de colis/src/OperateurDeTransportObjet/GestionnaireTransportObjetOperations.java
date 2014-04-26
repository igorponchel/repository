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
    public void notifierOffreTransport(String numeroStation);

    /**
     * Operation notifierOffreAcceptee
     */
    public void notifierOffreAcceptee(String numeroTransporteur);

    /**
     * Operation verifierTransporteur
     */
    public boolean verifierTransporteur(String numeroTransporteur, String codeTransport);

    /**
     * Operation notifierEtatObjet
     */
    public void notifierEtatObjet(String numeroObjet, OperateurDeTransportObjet.GestionnaireTransportObjetPackage.EtatObjet etatObjet)
        throws OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ObjetInexistantException;

    /**
     * Operation consulterEtatObjet
     */
    public OperateurDeTransportObjet.GestionnaireTransportObjetPackage.EtatObjet consulterEtatObjet(String numeroObjet)
        throws OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ObjetInexistantException;

}
