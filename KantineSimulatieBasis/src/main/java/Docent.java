
/**
 * Write a description of class Docent here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Docent extends Persoon implements KortingskaartHouder
{
    private String afkorting;
    
    public Docent(int bsn, String voornaam, String achternaam, int geboorteDag, int geboorteMaand, int geboorteJaar, char geslacht, String afkorting)
    {
        super(bsn, voornaam, achternaam, geboorteDag, geboorteMaand, geboorteJaar, geslacht);
        this.afkorting = afkorting;
    }
    
    public Docent()
    {
        
    }
    
    private void setAfkorting(String afkorting)
    {
        this.afkorting = afkorting;
    }
    
    public String getAfkorting()
    {
        return afkorting;
    }
    
    @Override
    public double geefKortingsPercentage()
    {
        return 0.25;
    }
    
    @Override
    public boolean heeftMaximum()
    {
        return true;
    }
    
    @Override
    public double geefMaximum()
    {
        return 1.0;
    }
}
