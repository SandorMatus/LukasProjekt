import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

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
}
