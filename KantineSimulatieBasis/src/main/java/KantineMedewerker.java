
/**
 * Write a description of class KantineMedewerker here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class KantineMedewerker extends Persoon implements KortingskaartHouder
{
    private boolean magBijKassa;
    
    public KantineMedewerker(int bsn, String voornaam, String achternaam, int geboorteDag, int geboorteMaand, int geboorteJaar, char geslacht, boolean magBijKassa)
    {
        super(bsn, voornaam, achternaam, geboorteDag, geboorteMaand, geboorteJaar, geslacht);
        this.magBijKassa = magBijKassa;
    }
    
    public KantineMedewerker()
    {
        
    }
    
    private void setMagBijKassa(boolean magBijKassa)
    {
        this.magBijKassa = magBijKassa;
    }
    
    public boolean getMagBijKassa()
    {
        return magBijKassa;
    }
    
    @Override
    public double geefKortingsPercentage()
    {
        return 0.35;
    }
    
    @Override
    public boolean heeftMaximum()
    {
        return false;
    }
    
    @Override
    public double geefMaximum()
    {
        return 0.0;
    }
}
