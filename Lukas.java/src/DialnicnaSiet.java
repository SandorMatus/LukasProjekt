import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;

public class DialnicnaSiet {
    ArrayList<Usek> siet;

    private DialnicnaSiet(ArrayList<Usek> siet) {
        this.siet = siet;
    }

    public static DialnicnaSiet nacitajSiet(String nazovSuboru){
        ArrayList<Usek> siet = new ArrayList<>();
        try {
            List<String> allLines = Files.readAllLines(Paths.get(System.getProperty("user.dir") + nazovSuboru + ".txt"));

            for (String line : allLines) {
                siet.add(Usek.zoStringu(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new DialnicnaSiet(siet);
    }
    public void ulozSiet(String nazovSuboru) throws IOException {
        File novySubor = new File(nazovSuboru + ".txt");
        novySubor.createNewFile();
        FileWriter writer = new FileWriter(nazovSuboru + ".txt");
        for (Usek n : siet) {
            if(n.getCena() != 0) {
                writer.write(n.getNazov() + "\\t" + n.getOznacenie() + "\\t" + n.getDlzka() + "\\t" + n.getTunel() + "\\t" + n.getIntenzita() + "\\t" + n.getDatumVystavby() + "\\t" + n.getPocetMesiacovVystavby() + "\\t" + n.getCena() + "\n");
            }else{
                writer.write(n.getNazov() + "\\t" + n.getOznacenie() + "\\t" + n.getDlzka() + "\\t" + n.getTunel() + "\\t" + n.getIntenzita() + "\\t" + n.getDatumVystavby() + "\\t" + n.getPocetMesiacovVystavby() + "\n");
            }
        }
        writer.close();
    }

    @Override
    public String toString() {
        return "DialnicnaSiet{" +
                "siet=" + siet +
                '}';
    }
    public double dlzkaDialnice(String oznacenie){//VZDIALENOST MA AJ DESATINNE CISLA PRETO DOUBLE A NIE INT!!!!!
        double celkovaDlzka = 0;
        for (Usek n : siet) {
            if (n.getOznacenie() == oznacenie) {
                celkovaDlzka += n.getDlzka();
            }
        }
        return celkovaDlzka;
    }
    public int pocetStavieb(){
        int pocetStavieb = 0;
        for (Usek n : siet) {
            if(n.voVystavbe()){
                pocetStavieb++;
            }
        }
        return pocetStavieb;
    }
    public void noveScitanie(Map<String, Integer> scitanie){
        for (Usek n : siet) {
            if(scitanie.containsKey(n.getNazov())){
                n.setIntenzita(scitanie.get(n.getNazov()));
            }
        }
    }
    public Set<String> dialniceNaScitanie(String aktualnyDatum){
        Set<String> dialnice = null;
        LocalDate datum = LocalDate.parse(aktualnyDatum);
        for (Usek n : siet) {
            if(n.getIntenzita() == 0){
                int pocetMesiacovPrevadzke = LocalDate.parse(n.datumUkonceniaVystavby()).compareTo(datum);
                if(pocetMesiacovPrevadzke >= 12){
                    dialnice.add(n.getNazov());
                }
            }
        }
        return dialnice;
    }
}
