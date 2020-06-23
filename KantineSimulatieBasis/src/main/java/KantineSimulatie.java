import java.util.*;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class KantineSimulatie {

    // kantine
    private Kantine kantine;

    // kantineaanbod
    private KantineAanbod kantineaanbod;

    // random generator
    private Random random;

    // aantal artikelen
    private static final int AANTAL_ARTIKELEN = 4;

    // artikelen
    private static final String[] artikelnamen =
            new String[] {"Koffie", "Broodje pindakaas", "Broodje kaas", "Appelsap"};

    // prijzen
    private static double[] artikelprijzen = new double[] {1.50, 2.10, 1.65, 1.65};
    private static double[] artikelKorting = new double[] {0.0, 0.0, 0.0, 0.0};

    // minimum en maximum aantal artikelen per soort
    private static final int MIN_ARTIKELEN_PER_SOORT = 10;
    private static final int MAX_ARTIKELEN_PER_SOORT = 20;

    // minimum en maximum aantal personen per dag
    private static final int MIN_PERSONEN_PER_DAG = 50;
    private static final int MAX_PERSONEN_PER_DAG = 100;

    // minimum en maximum artikelen per persoon
    private static final int MIN_ARTIKELEN_PER_PERSOON = 1;
    private static final int MAX_ARTIKELEN_PER_PERSOON = 4;
    
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("KantineSimulatie");
    private EntityManager manager;
    
    private int dagKorting;

    /**
     * Constructor
     *
     */
    public KantineSimulatie() {
        kantine = new Kantine();
        random = new Random();
        int[] hoeveelheden =
                getRandomArray(AANTAL_ARTIKELEN, MIN_ARTIKELEN_PER_SOORT, MAX_ARTIKELEN_PER_SOORT);
        kantineaanbod = new KantineAanbod(artikelnamen, artikelprijzen, hoeveelheden, artikelKorting);

        kantine.setKantineAanbod(kantineaanbod);
    }
    
    public void runVoorbeeld()
    {
        manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        manager.close();
        ENTITY_MANAGER_FACTORY.close();
    }

    public Kantine getKantine()
    {
        return kantine;
    }

    /**
     * Methode om een array van random getallen liggend tussen min en max van de gegeven lengte te
     * genereren
     *
     * @param lengte
     * @param min
     * @param max
     * @return De array met random getallen
     */
    private int[] getRandomArray(int lengte, int min, int max) {
        int[] temp = new int[lengte];
        for (int i = 0; i < lengte; i++) {
            temp[i] = getRandomValue(min, max);
        }

        return temp;
    }

    /**
     * Methode om een random getal tussen min(incl) en max(incl) te genereren.
     *
     * @param min
     * @param max
     * @return Een random getal
     */
    private int getRandomValue(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    /**
     * Methode om op basis van een array van indexen voor de array artikelnamen de bijhorende array
     * van artikelnamen te maken
     *
     * @param indexen
     * @return De array met artikelnamen
     */
    private String[] geefArtikelNamen(int[] indexen) {
        String[] artikelen = new String[indexen.length];

        for (int i = 0; i < indexen.length; i++) {
            artikelen[i] = artikelnamen[indexen[i]];

        }

        return artikelen;
    }

    private void setDagKorting()
    {
        dagKorting = getRandomValue(0, artikelnamen.length - 1);
        kantine.getKantineAanbod().getArtikel(artikelnamen[dagKorting]).setKorting(artikelprijzen[dagKorting] * 0.2);
    }

    /**
     * Deze methode simuleert een aantal dagen
     * in het verloop van de kantine
     *
     * @param dagen
     */
    public void simuleer(int dagen) {
        // for lus voor dagen
        for(int i = 0; i < dagen; i++) {

            // bedenk hoeveel personen vandaag binnen lopen
            
            int aantalStudenten = 0;
            int aantalDocenten = 0;
            int aantalKantineMedewerkers = 0;
            setDagKorting();
            
            

            
            for(int x = 1; x <= 100; x++)
            {
                int randomInt = random.nextInt(100);
                if(randomInt == 1)
                {
                    aantalKantineMedewerkers++;
                }
                else if(randomInt >= 2 && randomInt <= 90)
                {
                    aantalStudenten++;
                }
                else
                {
                    aantalDocenten++;
                }
            }

            // laat de personen maar komen...
            for (int j = 0; j < aantalStudenten; j++) {

                // maak persoon en dienblad aan, koppel ze
                Student student = new Student();
                Dienblad dienblad = new Dienblad(student);
                int randomWijze = getRandomValue(1,2);
                Contant contantbetaalwijze;
                Pinpas pinbetaalwijze;
                
                if(randomWijze == 1)
                {
                    contantbetaalwijze = new Contant();
                    student.setBetaalwijze(contantbetaalwijze);
                    contantbetaalwijze.setSaldo(getRandomValue(10,100));
                }
                else
                {
                    pinbetaalwijze = new Pinpas();
                    pinbetaalwijze.setKredietLimiet(getRandomValue(0,200));
                    student.setBetaalwijze(pinbetaalwijze);
                    pinbetaalwijze.setSaldo(getRandomValue(10,100));
                }
                
                
                // en bedenk hoeveel artikelen worden gepakt
                int aantalartikelen= getRandomValue(MIN_ARTIKELEN_PER_PERSOON,MAX_ARTIKELEN_PER_PERSOON);

                // genereer de "artikelnummers", dit zijn indexen
                // van de artikelnamen
                int[] tepakken=getRandomArray(aantalartikelen, 0,
                        AANTAL_ARTIKELEN-1);

                // vind de artikelnamen op basis van
                // de indexen hierboven
                String[] artikelen = geefArtikelNamen(tepakken);
                
                // loop de kantine binnen, pak de gewenste
                // artikelen, sluit aan
                kantine.loopPakSluitAan(dienblad, artikelen);

            }
            
            for (int j = 0; j < aantalDocenten; j++) {

                // maak persoon en dienblad aan, koppel ze
                Docent docent = new Docent();
                Dienblad dienblad = new Dienblad(docent);
                int randomWijze = getRandomValue(1,2);
                Contant contantbetaalwijze;
                Pinpas pinbetaalwijze;
                
                if(randomWijze == 1)
                {
                    contantbetaalwijze = new Contant();
                    docent.setBetaalwijze(contantbetaalwijze);
                    contantbetaalwijze.setSaldo(getRandomValue(10,100));
                }
                else
                {
                    pinbetaalwijze = new Pinpas();
                    pinbetaalwijze.setKredietLimiet(getRandomValue(0,200));
                    docent.setBetaalwijze(pinbetaalwijze);
                    pinbetaalwijze.setSaldo(getRandomValue(10,100));
                }
                // en bedenk hoeveel artikelen worden gepakt
                 int aantalartikelen= getRandomValue(MIN_ARTIKELEN_PER_PERSOON,MAX_ARTIKELEN_PER_PERSOON);

                // genereer de "artikelnummers", dit zijn indexen
                // van de artikelnamen
                int[] tepakken=getRandomArray(aantalartikelen, 0,
                        AANTAL_ARTIKELEN-1);

                // vind de artikelnamen op basis van
                // de indexen hierboven
                String[] artikelen = geefArtikelNamen(tepakken);
                
                // loop de kantine binnen, pak de gewenste
                // artikelen, sluit aan
                kantine.loopPakSluitAan(dienblad, artikelen);

            }
            
            for (int j = 0; j < aantalKantineMedewerkers; j++) {

                // maak persoon en dienblad aan, koppel ze
                KantineMedewerker kantineMedewerker = new KantineMedewerker();
                Dienblad dienblad = new Dienblad(kantineMedewerker);
                int randomWijze = getRandomValue(1,2);
                Contant contantbetaalwijze;
                Pinpas pinbetaalwijze;
                
                if(randomWijze == 1)
                {
                    contantbetaalwijze = new Contant();
                    kantineMedewerker.setBetaalwijze(contantbetaalwijze);
                    contantbetaalwijze.setSaldo(getRandomValue(10,100));
                }
                else
                {
                    pinbetaalwijze = new Pinpas();
                    pinbetaalwijze.setKredietLimiet(getRandomValue(0,200));
                    kantineMedewerker.setBetaalwijze(pinbetaalwijze);
                    pinbetaalwijze.setSaldo(getRandomValue(10,100));
                }
                // en bedenk hoeveel artikelen worden gepakt
                 int aantalartikelen= getRandomValue(MIN_ARTIKELEN_PER_PERSOON,MAX_ARTIKELEN_PER_PERSOON);

                // genereer de "artikelnummers", dit zijn indexen
                // van de artikelnamen
                int[] tepakken=getRandomArray(aantalartikelen, 0,
                        AANTAL_ARTIKELEN-1);

                // vind de artikelnamen op basis van
                // de indexen hierboven
                String[] artikelen = geefArtikelNamen(tepakken);
                
                // loop de kantine binnen, pak de gewenste
                // artikelen, sluit aan
                kantine.loopPakSluitAan(dienblad, artikelen);

            }

            // verwerk rij voor de kassa
            kantine.verwerkRijVoorKassa();
            
            // druk de dagtotalen af en hoeveel personen binnen

            // zijn gekomen
            int aantalpersonen = aantalStudenten + aantalDocenten + aantalKantineMedewerkers;
            System.out.println("***********************************");
             System.out.println("Aantal personen : " + aantalpersonen);  
             System.out.println("Totaal dag omzet : €" + kantine.hoeveelheidGeldInKassa() + ",-");
             System.out.println("totaal aantal artikelen :" + kantine.aantalArtikelen());
            // reset de kassa voor de volgende dag
            kantine.resetKassa();
        }
    }
}
