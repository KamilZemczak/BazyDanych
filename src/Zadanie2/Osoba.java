package Zadanie2;

/**
 *
 * @author Kamil Zemczak
 */
public class Osoba {
    private final String nazwisko;
    private final String imie;
    private final String ulica;
    private final String numerDomu;
    private final String[] kodPocztowy; 
    private final String miasto;
    private static final String infoSeparator = " /#/ ";
    
    public Osoba(String nazwisko, String imie, String ulica, String numerDomu, String postCode, String miasto) {
        this.nazwisko = nazwisko;
        this.imie = imie;
        this.ulica = ulica;
        this.numerDomu = numerDomu;
        this.kodPocztowy = postCode.split("-");
        this.miasto = miasto;
    }

    public String getDanedoZapisu(){
        return nazwisko + infoSeparator + 
                imie + infoSeparator + 
                ulica + infoSeparator + 
                numerDomu + infoSeparator + 
                kodPocztowy[0] + "-" + kodPocztowy[1] + infoSeparator + 
                miasto;
    }
    
    public String getSformatowaneDane(){
        return nazwisko + " " + 
                imie + ", " + 
                ulica + " " + 
                numerDomu + ", " + 
                kodPocztowy[0] + "-" + kodPocztowy[1] + " " + 
                miasto;
    }
    
    public static Osoba getOsobaDoStringa(String line){
        String[] info = line.split(infoSeparator);
        return new Osoba(info[0], info[1], info[2], info[3], info[4], info[5]);
    }
    
    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getUlica() {
        return ulica;
    }

    public String getNumerDomu() {
        return numerDomu;
    }

    public String[] getKodPocztowy() {
        return kodPocztowy;
    }

    public String getMiasto() {
        return miasto;
    }
}
