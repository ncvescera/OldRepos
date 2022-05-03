package assassination_airport;

/**
 *
 * @author Nicolò Vescera
 */
public class Volo {
    public String codice_volo;
    public String compagnia;
    public String destinazione;
    public String data;
    
    public Volo(String codice_volo, String compagnia, String destinazione, String data){
        this.codice_volo = codice_volo;
        this.compagnia = compagnia;
        this.destinazione = destinazione;
        this.data = data;
    }
    
    public void print(){
        System.out.println("\t\tCodice: "+this.codice_volo+"\n\t\tCompagnia: "+this.compagnia+"\n\t\tDestinazione: "+this.destinazione+"\n\t\tData: "+this.data);
    }
}
