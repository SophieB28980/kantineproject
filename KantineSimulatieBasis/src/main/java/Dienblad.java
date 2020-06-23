import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Dienblad {
    private Stack<Artikel> artikelen;
    private Persoon klant;

    /**
     * Constructor
     */
    public Dienblad() {
        artikelen = new Stack<Artikel>();
    }
    
    public Dienblad(Persoon persoon)
    {
        this();
        this.klant = persoon;
    }
    
    private void setKlant(Persoon persoon)
    {
        this.klant = persoon;
    }
    
    public Persoon getKlant()
    {
        return klant;
    }

    /**
     * Methode om artikel aan dienblad toe te voegen
     *
     * @param artikel
     */
    public void voegToe(Artikel artikel) {
        artikelen.add(artikel);
    }

    /**
     * Methode om aantal artikelen op dienblad te tellen
     *
     * @return Het aantal artikelen
     */
    public int getAantalArtikelen() {
        return artikelen.size();
    }

    /**
     * Methode om de totaalprijs van de artikelen op dienblad uit te rekenen
     *
     * @return De totaalprijs
     */
    public double getTotaalPrijs() {
        int i = 0;
        double totaalPrijs = 0;
        while(i < artikelen.size())
        {
            totaalPrijs = totaalPrijs + artikelen.get(i).getPrijs();
            i++;
        }
        return totaalPrijs;
    }

    public Iterator<Artikel> getIterator() {
        return artikelen.iterator();
    }
}

