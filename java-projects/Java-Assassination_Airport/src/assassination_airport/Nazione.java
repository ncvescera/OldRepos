package assassination_airport;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Nicolò Vescera
 */
public class Nazione {
    public String nome;
    public Map<String, Aeroporto> aeroporti;
    
    public Nazione(String nome){
        this.nome = nome;
        this.aeroporti = new HashMap<>();
        
        //inizializzazione dell'array aeroporti
        switch(this.nome){
            case "Islanda":
                for(String aeroporto:Database.areoporto_ICE){
                    aeroporti.put(aeroporto, new Aeroporto(aeroporto));
                }
                break;
            case "Finalndia":
                for(String aeroporto:Database.areoporto_FIN){
                    aeroporti.put(aeroporto, new Aeroporto(aeroporto));
                }
                break; 
            case "Italia":
                for(String aeroporto:Database.areoporto_ITA){
                    aeroporti.put(aeroporto, new Aeroporto(aeroporto));
                }
                break;
            case "Germania":
                for(String aeroporto:Database.areoporto_GER){
                    aeroporti.put(aeroporto, new Aeroporto(aeroporto));
                }
                break;
        }
    }
    
    public void print(){
        System.out.println("Nazione: "+this.nome);
        
        //lambda expression per stampare il contenuto dell'array associativo ( quanto sono fighe ste funzioni :333 )
        aeroporti.forEach((String s, Aeroporto a) -> {
            System.out.println("\tNome: "+a.nome);
            a.printVoli();
        });
    }
}
