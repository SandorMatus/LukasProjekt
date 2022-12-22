import java.time.LocalDate;
import java.util.Date;

public class Usek implements Comparable<Usek>{
    private String nazov;
    private String oznacenie;
    private double dlzka;
    private String tunel;
    private int intenzita;
    private LocalDate datumVystavby;
    private int pocetMesiacovVystavby;
    private double cena = 0;

    @Override
    public int compareTo(Usek o) {
        return 0;
    }

    public boolean voVystavbe(){
        if(pocetMesiacovVystavby != 0){
            return true;
        }else{
            return false;
        }
    }
    public boolean maTunel(){
        if(tunel != "") {
            return true;
        }else{
            return false;
        }
    }
    public String datumUkonceniaVystavby(){
        LocalDate datumUkoncenia = datumVystavby;
        datumUkoncenia.plusMonths(pocetMesiacovVystavby);
        return datumUkoncenia.toString();
    }
    public static Usek zoStringu(String popis){
        String[] result = popis.split("\t");
        if(result.length == 7) {
            return new Usek(result[0], result[1], Double.parseDouble(result[2]), result[3], Integer.parseInt(result[4]), LocalDate.parse(result[5]), Integer.parseInt(result[6]));
        }else{
            return new Usek(result[0], result[1], Double.parseDouble(result[2]), result[3], Integer.parseInt(result[4]), LocalDate.parse(result[5]), Integer.parseInt(result[6]), Double.parseDouble(result[7]));
        }
    }
    @Override
    public String toString(){
        return "Nazov :" + nazov + "Oznacenie :" + oznacenie + "Dlzka :" + dlzka + "Tunel :" + tunel + "Intenzita :" + intenzita + "Datum Vystavby :" + datumVystavby + "Pocet mesiacov vystavby :" + pocetMesiacovVystavby + "Cena :" + cena;
    }
    //GET,SET,CONST

    public Usek(String nazov, String oznacenie, double dlzka, String tunel, int intenzita, LocalDate datumVystavby, int pocetMesiacovVystavby) {
        this.nazov = nazov;
        this.oznacenie = oznacenie;
        this.dlzka = dlzka;
        this.tunel = tunel;
        this.intenzita = intenzita;
        this.datumVystavby = datumVystavby;
        this.pocetMesiacovVystavby = pocetMesiacovVystavby;
    }

    public Usek(String nazov, String oznacenie, double dlzka, String tunel, int intenzita, LocalDate datumVystavby, int pocetMesiacovVystavby, double cena) {
        this.nazov = nazov;
        this.oznacenie = oznacenie;
        this.dlzka = dlzka;
        this.tunel = tunel;
        this.intenzita = intenzita;
        this.datumVystavby = datumVystavby;
        this.pocetMesiacovVystavby = pocetMesiacovVystavby;
        this.cena = cena;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public String getOznacenie() {
        return oznacenie;
    }

    public void setOznacenie(String oznacenie) {
        this.oznacenie = oznacenie;
    }

    public double getDlzka() {
        return dlzka;
    }

    public void setDlzka(double dlzka) {
        this.dlzka = dlzka;
    }

    public String getTunel() {
        return tunel;
    }

    public void setTunel(String tunel) {
        this.tunel = tunel;
    }

    public int getIntenzita() {
        return intenzita;
    }

    public void setIntenzita(int intenzita) {
        this.intenzita = intenzita;
    }

    public LocalDate getDatumVystavby() {
        return datumVystavby;
    }

    public void setDatumVystavby(LocalDate datumVystavby) {
        this.datumVystavby = datumVystavby;
    }

    public int getPocetMesiacovVystavby() {
        return pocetMesiacovVystavby;
    }

    public void setPocetMesiacovVystavby(int pocetMesiacovVystavby) {
        this.pocetMesiacovVystavby = pocetMesiacovVystavby;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

}
