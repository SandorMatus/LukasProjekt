import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class Main {
    Map<String, DialnicnaSiet> dialnice;
    public String najviacStavieb() {
        String nazovDialnice = null;
        int pocetStavieb = 0;
        for(DialnicnaSiet n : dialnice.values()){
            if(pocetStavieb < n.pocetStavieb()) {
                pocetStavieb = n.pocetStavieb();
                nazovDialnice = dialnice.get(n).toString();
            }
        }
        return nazovDialnice;
    }
    public static void main(String[] args) throws IOException {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Zadaj nazov suboru pre nacitanie dialnicnej siete :");
        String nazov = myObj.nextLine();
        DialnicnaSiet siet1 = DialnicnaSiet.nacitajSiet(nazov);
        System.out.println(siet1);
        System.out.println("Dlzka dialnice D1 : " + siet1.dlzkaDialnice("D1"));
        System.out.println("Pocet stavieb pre siet1 : " + siet1.pocetStavieb());
        System.out.println("Dialnice na scitanie : " + siet1.dialniceNaScitanie(LocalDate.now().toString()));
        System.out.println("Scitanie pre dialnicu D1, zadaj novu hodnotu intenzity : ");
        int hodnota = myObj.nextInt();
        Map<String, Integer> scitanie = new HashMap<>();
        scitanie.put("D1", hodnota);
        siet1.noveScitanie(scitanie);
        System.out.println("Zadaj nazov suboru pre ulozenie : ");
        nazov = myObj.next();
        siet1.ulozSiet(nazov);
    }
}
