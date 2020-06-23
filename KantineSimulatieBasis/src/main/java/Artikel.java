
/**
 * Write a description of class Artikel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Artikel
{
    private String naam;
    private static double prijs;
    private double korting;
    
    public Artikel(String naam, double prijs)
    {
        this.naam = naam;
        this.prijs = prijs;
        this.korting = 0.0;
    }
    
    public Artikel(String naam, double prijs, double korting)
    {
        this.naam = naam;
        this.prijs = prijs;
        this.korting = korting;
    }
    
    public Artikel()
    {
        
    }

    private void setNaam(String naam)
    {
        this.naam = naam;
    }
    
    private void setPrijs(double prijs)
    {
        this.prijs = prijs;
    }
    
    public void setKorting(double korting)
    {
        this.korting = korting;
    }
    
    public String getNaam()
    {
        return naam;
    }
    
    public static double getPrijs()
    {
        return prijs;
    }
    
    public double getKorting()
    {
        return korting;
    }
    
    public String toString()
    {
        return naam + "\n" + prijs;
    }
}
