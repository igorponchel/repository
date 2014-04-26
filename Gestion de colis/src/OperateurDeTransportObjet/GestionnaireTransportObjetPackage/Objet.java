package OperateurDeTransportObjet.GestionnaireTransportObjetPackage;

/**
 * Struct definition : Objet
 * 
 * @author OpenORB Compiler
*/
public final class Objet implements org.omg.CORBA.portable.IDLEntity
{
    /**
     * Struct member numeroObjet
     */
    public String numeroObjet;

    /**
     * Struct member etatObjet
     */
    public OperateurDeTransportObjet.GestionnaireTransportObjetPackage.EtatObjet etatObjet;

    /**
     * Default constructor
     */
    public Objet()
    { }

    /**
     * Constructor with fields initialization
     * @param numeroObjet numeroObjet struct member
     * @param etatObjet etatObjet struct member
     */
    public Objet(String numeroObjet, OperateurDeTransportObjet.GestionnaireTransportObjetPackage.EtatObjet etatObjet)
    {
        this.numeroObjet = numeroObjet;
        this.etatObjet = etatObjet;
    }

}
