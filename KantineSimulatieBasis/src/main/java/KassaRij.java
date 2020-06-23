import java.util.ArrayList;
import java.util.LinkedList;

public class KassaRij {
    
    private LinkedList<Dienblad> wachtenden;

    /**
     * Constructor
     */
    public KassaRij() {
        //LinkedList<Dienblad> wachtenden = new LinkedList();
        this.wachtenden = new LinkedList<Dienblad>();
    }

    /**
     * Persoon sluit achter in de rij aan
     *
     * @param klant
     */
    public void sluitAchteraan(Dienblad klant) {
        this.wachtenden.add(klant);
    }

    /**
     * Indien er een rij bestaat, de eerste klant uit de rij verwijderen en retourneren. Als er
     * niemand in de rij staat geeft deze null terug.
     *
     * @return Eerste klant in de rij of null
     */
    public Dienblad eerstePersoonInRij() {
        if(wachtenden.size() > 0)
        {
            Dienblad eersteKlant = wachtenden.get(0);
            wachtenden.remove(0);
            return eersteKlant;
        }
        else
        {
            return null;
        }
    }

    /**
     * Methode kijkt of er personen in de rij staan.
     *
     * @return Of er wel of geen rij bestaat
     */
    public boolean erIsEenRij() {
        boolean isErEenRij;
        if(wachtenden.size() > 0)
        {
            isErEenRij = true;
        }
        else
        {
            isErEenRij = false;
        }
        return isErEenRij;
    }
}
