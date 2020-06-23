public class Administratie {
    
    private static final int DAYS_IN_WEEK = 7;

    private Administratie()
    {
        
    }
    
    /**
     * Deze methode berekent van de int array aantal de gemiddelde waarde
     *
     * @param aantal
     * @return het gemiddelde
     */
    public static double berekenGemiddeldAantal(int[] aantal) {
        double gemiddelde = 0;
        int aantalDienbladen = 0;
        int aantalArtikelen = 0;
        
        for(int i = 0; i <= aantal.length - 1; i++)
        {
            aantalArtikelen = aantalArtikelen + aantal[i];
            aantalDienbladen++;
        }
        gemiddelde = aantalArtikelen / aantalDienbladen;
        return gemiddelde;
    }

    /**
     * Deze methode berekent van de double array omzet de gemiddelde waarde
     *
     * @param omzet
     * @return het gemiddelde
     */
    public static double berekenGemiddeldeOmzet(double[] omzet) {
        double gemiddelde = 0;
        int aantalDagen = 0;
        double hoeveelheidOmzet = 0;
        
        for(int i = 0; i <= omzet.length - 1; i++)
        {
            hoeveelheidOmzet = hoeveelheidOmzet + omzet[i];
            aantalDagen++;
        }
        gemiddelde = hoeveelheidOmzet / aantalDagen;
        return gemiddelde;
    }

    /**
     * Methode om dagomzet uit te rekenen
     *
     * @param omzet
     * @return array (7 elementen) met dagomzetten
     */

    public static double[] berekenDagOmzet(double[] omzet) {
        double[] temp = new double[7];
        for(int i = 0; i < 7; i++) {

            int j = 0;
            while (i+DAYS_IN_WEEK*j < omzet.length) {
                temp[i] += omzet[i + 7 * j];
                
                j++;

            }
        }
        return temp;
    }
}