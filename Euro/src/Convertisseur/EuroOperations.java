package Convertisseur;

/**
 * Interface definition : Euro
 * 
 * @author OpenORB Compiler
 */
public interface EuroOperations
{
    /**
     * Read accessor for taux attribute
     * @return the attribute value
     */
    public double taux();

    /**
     * Write accessor for taux attribute
     * @param value the attribute value
     */
    public void taux(double value);

    /**
     * Read accessor for devise attribute
     * @return the attribute value
     */
    public String devise();

    /**
     * Write accessor for devise attribute
     * @param value the attribute value
     */
    public void devise(String value);

    /**
     * Operation toEuro
     */
    public double toEuro(double devise);

    /**
     * Operation toDevise
     */
    public double toDevise(double euro);

}
