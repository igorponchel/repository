package OperateurDeTransportObjet;

/**
 * Interface definition : GestionnaireTransportObjet
 * 
 * @author OpenORB Compiler
 */
public interface GestionnaireTransportObjetOperations
{
    /**
     * Operation demandeInscriptionTrans
     */
    public OperateurDeTransportObjet.GestionnaireTransportObjetPackage.InscriptionTrans demandeInscriptionTrans(OperateurDeTransportObjet.GestionnaireTransportObjetPackage.DemandeInscriptionTrans demandeInscriptionTrans)
        throws OperateurDeTransportObjet.GestionnaireTransportObjetPackage.TransExistantException;

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
     * Operation enregistrerObjet
     */
    public void enregistrerObjet(OperateurDeTransportObjet.Objet objet);

    /**
     * Operation notifierEtatObjet
     */
    public void notifierEtatObjet(String idObjet, OperateurDeTransportObjet.EtatObjet etatObjet)
        throws OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ObjetInexistantException;

    /**
     * Operation consulterEtatObjet
     */
    public OperateurDeTransportObjet.InfoObjet[] consulterEtatObjet(int numeroAdherent)
        throws OperateurDeTransportObjet.GestionnaireTransportObjetPackage.ObjetInexistantException;

    /**
     * Operation notifierConnexion
     */
    public void notifierConnexion(int numeroTransporteur, OperateurDeTransportObjet.Transporteur transporteur);

    /**
     * Operation notifierDeconnexion
     */
    public void notifierDeconnexion(int numeroTransporteur);

}
