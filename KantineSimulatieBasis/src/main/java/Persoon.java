
/**
 * Write a description of class Persoon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Persoon
{
    private int bsn;
    private String voornaam;
    private String achternaam;
    private int dag;
    private int maand;
    private int jaar;
    private char geslacht;
    private Betaalwijze betaalwijze;
    
    public Persoon(int bsn, String voornaam, String achternaam, int geboorteDag, int geboorteMaand, int geboorteJaar, char geslacht)
    {
        this.bsn = bsn;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.dag = geboorteDag;
        this.maand = geboorteMaand;
        this.jaar = geboorteJaar;
        setGeslacht(geslacht);
    }
    
    public Persoon()
    {
        this.bsn = 0;
        this.voornaam = "";
        this.achternaam = "";
        this.dag = 0;
        this.maand = 0;
        this.jaar = 0;
        geslacht = 'U';
    }
    
    private void setBsn(int bsn)
    {
        this.bsn = bsn;
    }
    
    private void setNaam(String voornaam, String achternaam)
    {
        this.voornaam = voornaam;
        this.achternaam = achternaam;
    }
    
    private void setGeboortedatum(int geboorteDag, int geboorteMaand, int geboorteJaar)
    {
        this.dag = geboorteDag;
        this.maand = geboorteMaand;
        this.jaar = geboorteJaar;
    }
    
    private void setGeslacht(char geslacht)
    {
        if(geslacht == 'M' || geslacht == 'V' || geslacht == 'X')
        {
            this.geslacht = geslacht;
        }
        else
        {
            System.out.println("onmogelijk geslacht");
        }
    }
    
    public void setBetaalwijze(Betaalwijze betaalwijze)
    {
        
            this.betaalwijze = betaalwijze;
        
    }
    
    public int getBsn()
    {
        return bsn;
    }
    
    public String getNaam()
    {
        return voornaam + achternaam;
    }
    
    public String getGeboortedatum()
    {
        Datum geboorteDatum = new Datum(dag, maand, jaar);
        if(dag == 0 && maand == 0 && jaar == 0)
        {
            return "Onbekend";
        }
        else
        {
            return geboorteDatum.getDatumAsString();
        }
    }
    
    public char getGeslacht()
    {
        return geslacht;
    }
    
    public Betaalwijze getBetaalwijze()
    {
        return betaalwijze;
    }
    
    public String toString()
    {
        return bsn + "\n" + getNaam() + "\n" + getGeboortedatum() + "\n" + geslacht;
    }
}
