public class Datum {

    private int dag;
    private int maand;
    private int jaar;

    /**
     * Constructor
     */
    public Datum(int dag, int maand, int jaar)
    {
        if(bestaatDatum(dag, maand, jaar))
        {
            this.dag = dag;
            this.maand = maand;
            this.jaar = jaar;
        }
        else
        {
            System.out.println("datum bestaat niet");
            this.dag = 0;
            this.maand = 0;
            this.jaar = 0;
        }
    }
    
    public Datum()
    {
        this.dag = 0;
        this.maand = 0;
        this.jaar = 0;
    }
    
    private void setDag(int dag)
    {
        this.dag = dag;
    }
    
    private void setMaand(int maand)
    {
        this.maand = maand;
    }
    
    private void setJaar(int jaar)
    {
        this.jaar = jaar;
    }
    
    public int getDag()
    {
        return dag;
    }
    
    public int getMaand()
    {
        return maand;
    }
    
    public int getJaar()
    {
        return jaar;
    }

    public boolean bestaatDatum(int dag, int maand, int jaar) {
        int truthCounter = 0;
        
        if(dag >= 1)
        {
            truthCounter++;
        }
        if(maand >= 1 && maand <= 12)
        {
            truthCounter++;
        }
        if(jaar >= 1900 && jaar <= 2100)
        {
            truthCounter++;
        }
        if(maand == 1 || maand == 3 || maand == 5 || maand == 7 || maand == 8 || maand == 10 || maand == 12 && dag <= 31)
        {
            truthCounter++;
        }
        if(maand == 4 || maand == 6 || maand == 9 || maand == 11 && dag <= 30)
        {
            truthCounter++;
        }
        if(maand == 2 && jaar%4 == 0 && jaar%100 != 0 || jaar%400 == 0 && dag <= 29)
        {
            truthCounter++;
        }
        if(maand == 2 && jaar%4 != 0 && dag <= 28)
        {
            truthCounter++;
        }
        
        if(truthCounter == 4)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Getter voor Sting weergave van datum
     *
     * @return Geboortedatum
     */
    public String getDatumAsString() {
        return dag + "-" + maand + "-" + jaar;
    }
}
