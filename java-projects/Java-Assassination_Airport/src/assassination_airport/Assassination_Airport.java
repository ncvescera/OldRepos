package assassination_airport;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Nicolò Vescera
 */
public class Assassination_Airport {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //inizializzazione e dichiarazione dell'array associativo nazione
        Map<String, Nazione> nazioni = new HashMap<>();
        for (String nazione : Database.nazioni) {
            nazioni.put(nazione, new Nazione(nazione));
        }
        
        //avvio dell'interfaccia grafica
        new GUI(nazioni);
    }
    
}
