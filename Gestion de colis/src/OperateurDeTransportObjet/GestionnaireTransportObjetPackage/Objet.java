package OperateurDeTransportObjet.GestionnaireTransportObjetPackage;

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
    public OperateurDeTransportObjet.GestionnaireTransportObjetPackage.EtatObjet etatObjet;

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
     * @param numeroCasierDepart numeroCasierDepart struct member
     * @param numeroCasierArrivee numeroCasierArrivee struct member
     */
    public Objet(String idObjet, OperateurDeTransportObjet.GestionnaireTransportObjetPackage.EtatObjet etatObjet, int numeroCasierDepart, int numeroCasierArrivee)
    {
        this.idObjet = idObjet;
        this.etatObjet = etatObjet;
        this.numeroCasierDepart = numeroCasierDepart;
        this.numeroCasierArrivee = numeroCasierArrivee;
    }

}
