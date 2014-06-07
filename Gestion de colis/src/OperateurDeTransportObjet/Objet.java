package OperateurDeTransportObjet;

/**
 * Struct definition : Objet
 * 
 * @author OpenORB Compiler
*/
public final class Objet implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member idObjet
     */
    public String idObjet;

    /**
     * Struct member etatObjet
     */
    public OperateurDeTransportObjet.EtatObjet etatObjet;

    /**
     * Struct member numExpediteur
     */
    public int numExpediteur;

    /**
     * Struct member numDestinataire
     */
    public int numDestinataire;

    /**
     * Struct member numeroCasierDepart
     */
    public int numeroCasierDepart;

    /**
     * Struct member numeroCasierArrivee
     */
    public int numeroCasierArrivee;

    /**
     * Default constructor
     */
    public Objet()
    { }

    /**
     * Constructor with fields initialization
     * @param idObjet idObjet struct member
     * @param etatObjet etatObjet struct member
     * @param numExpediteur numExpediteur struct member
     * @param numDestinataire numDestinataire struct member
     * @param numeroCasierDepart numeroCasierDepart struct member
     * @param numeroCasierArrivee numeroCasierArrivee struct member
     */
    public Objet(String idObjet, OperateurDeTransportObjet.EtatObjet etatObjet, int numExpediteur, int numDestinataire, int numeroCasierDepart, int numeroCasierArrivee)
    {
        this.idObjet = idObjet;
        this.etatObjet = etatObjet;
        this.numExpediteur = numExpediteur;
        this.numDestinataire = numDestinataire;
        this.numeroCasierDepart = numeroCasierDepart;
        this.numeroCasierArrivee = numeroCasierArrivee;
    }

}
