package esestream02;

/**
 * Classe per contenere i dati pesenti nel file
 * @author ncvescera
 */
public class Record {
    private String cognome;
    private String materia;
    private String valutazione;
    private int voto;
    
    public Record(String cognome, String materia, String valutazione, int voto){
        this.cognome = cognome;
        this.materia = materia;
        this.valutazione = valutazione;
        this.voto = voto;
    }
    
    public void print(){
        System.out.println(cognome+","+materia+","+valutazione+","+voto);
    }
    
    public String getCognome() {
        return cognome;
    }

    public String getMateria() {
        return materia;
    }

    public String getValutazione() {
        return valutazione;
    }

    public int getVoto() {
        return voto;
    } 
    
}
