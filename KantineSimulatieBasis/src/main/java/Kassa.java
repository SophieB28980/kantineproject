import java.util.Iterator;

public class Kassa {
    
    private KassaRij kassarij;
    private Dienblad dienblad;
    private int aantalArtikelen;
    private double kassaInhoud;
    private int dagKorting;

    /**
     * Constructor
     */
    public Kassa(KassaRij kassarij) {
        this.kassarij = kassarij;
    }

    /**
     * Vraag het aantal artikelen en de totaalprijs op. Tel deze gegevens op bij de controletotalen
     * die voor de kassa worden bijgehouden. De implementatie wordt later vervangen door een echte
     * betaling door de persoon.
     *
     * @param klant die moet afrekenen
     */
    public void rekenAf(Dienblad klant) {
        double betaling = klant.getTotaalPrijs();
        double kortingsPercentage = 0.0;
        double kortingsBedrag = 0.0;
        boolean heeftMaximum = false;
        double kortingsArtikelPrijs = 0.0;

        for(int i = 0; i < KantineSimulatie.getKantine().getKantineAanbod().size(); i++)
        {
            if(KantineSimulatie.getKantine().getKantineAanbod().get(i).getKorting() != 0.0)
            {
                kortingsArtikelPrijs = KantineSimulatie.getKantine().getKantineAanbod().get(i).getPrijs();
                betaling -= KantineSimulatie.getKantine().getKantineAanbod().get(i).getPrijs();
            }
        }

        



        if(klant instanceof KortingskaartHouder) {
            KortingskaartHouder kaarthouder = (KortingskaartHouder)klant;
            kortingsPercentage = kaarthouder.geefKortingsPercentage();
            heeftMaximum = kaarthouder.heeftMaximum();
            if(kortingsPercentage > 0)
            {
                kortingsBedrag = betaling * kortingsPercentage;
            }
            if(heeftMaximum && kortingsBedrag > kaarthouder.geefMaximum())
            {
                kortingsBedrag = kaarthouder.geefMaximum();
            }
            
            
        }
        
        betaling = betaling - kortingsBedrag + kortingsArtikelPrijs;
        
        try {
            klant.getKlant().getBetaalwijze().betaal(betaling);
            kassaInhoud += betaling;
            aantalArtikelen += klant.getAantalArtikelen();
        }
        catch(TeWeinigGeldException e) {
            System.out.println(klant.getKlant().getNaam() + e.getMessage());
        }
        
    }

    /**
     * Geeft het aantal artikelen dat de kassa heeft gepasseerd, vanaf het moment dat de methode
     * resetWaarden is aangeroepen.
     *
     * @return aantal artikelen
     */
    public int aantalArtikelen() {
        return aantalArtikelen;
    }

    /**
     * Geeft het totaalbedrag van alle artikelen die de kass zijn gepasseerd, vanaf het moment dat
     * de methode resetKassa is aangeroepen.
     *
     * @return hoeveelheid geld in de kassa
     */
    public double hoeveelheidGeldInKassa() {
        return kassaInhoud;
    }

    /**
     * reset de waarden van het aantal gepasseerde artikelen en de totale hoeveelheid geld in de
     * kassa.
     */
    public void resetKassa() {
        aantalArtikelen = 0;
        kassaInhoud = 0.0;
    }

    public int dienbladArtikelen(Dienblad dienblad) {
        int artikelenaantal = 0;
        Iterator itr = dienblad.getIterator();
        while (itr.hasNext()) {
            artikelenaantal++;
            itr.next();
        } return artikelenaantal;
    }

    public double totaalPrijs(Dienblad dienblad) {
        double totaal = 0;
        Iterator itr = dienblad.getIterator();
        while (itr.hasNext()) {
            totaal += Artikel.getPrijs();
            itr.next();
        } return totaal;
    }
}
