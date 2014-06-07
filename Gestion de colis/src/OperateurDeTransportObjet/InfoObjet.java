package OperateurDeTransportObjet;

/**
 * Struct definition : InfoObjet
 * 
 * @author OpenORB Compiler
*/
public final class InfoObjet implements org.omg.CORBA.portable.IDLEntity
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
     * Default constructor
     */
    public InfoObjet()
    { }

    /**
     * Constructor with fields initialization
     * @param idObjet idObjet struct member
     * @param etatObjet etatObjet struct member
     */
    public InfoObjet(String idObjet, OperateurDeTransportObjet.EtatObjet etatObjet)
    {
        this.idObjet = idObjet;
        this.etatObjet = etatObjet;
    }

}
