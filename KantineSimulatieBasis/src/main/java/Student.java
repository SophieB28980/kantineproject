
/**
 * Write a description of class Student here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Student extends Persoon
{
    private int studentNummer;
    private String studieRichting;
    
    public Student(int bsn, String voornaam, String achternaam, int geboorteDag, int geboorteMaand, int geboorteJaar, char geslacht, int studentNummer, String studieRichting)
    {
        super(bsn, voornaam, achternaam, geboorteDag, geboorteMaand, geboorteJaar, geslacht);
        this.studentNummer = studentNummer;
        this.studieRichting = studieRichting;
    }
    
    public Student()
    {
        
    }
    
    private void setStudentNummer(int studentNummer)
    {
        this.studentNummer = studentNummer;
    }
    
    private void setStudieRichting(String studieRichting)
    {
        this.studieRichting = studieRichting;
    }
    
    public int getStudentNummer()
    {
        return studentNummer;
    }
    
    public String getStudieRichting()
    {
        return studieRichting;
    }
}
