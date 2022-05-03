package esestream02;

import java.util.ArrayList;

/**
 *
 * @author ncvescera
 */
public class JavaEseStream02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String cognome;
        String materia;
        String valutazione;
        int voto;
        
        ScriviFile fileWriter = new ScriviFile();
        
        do{
            cognome = EasyInput.inputS("Cognome: ");
            materia = EasyInput.inputS("Materia: ");
            valutazione = EasyInput.inputS("Valutazione: ");
            voto = EasyInput.inputI("Voto: ");
            
            fileWriter.scrivi(cognome,materia,valutazione,voto); //scrive i dati in input nel file
            
        }while(!(EasyInput.inputS("Continuare?\t[no-0]").equals("0")));
        
        fileWriter.close(); //chiusura del fileWriter
        
        LeggiFile fileReader = new LeggiFile();
        ArrayList<Record> rows = new ArrayList(); //array che conterrà ogni riga del file
        
        
        fileReader.readAll(rows); //legge tutti i dati presenti nel file
        fileReader.close(); //chiusura del fileReader
        
        //Stampa dei dati letti
        for(Record elem:rows)
            elem.print();
        
        //Stampa delle medie
        System.out.println("MEDIE");
        
        Analizza recordAnalizer = new Analizza(rows);
        recordAnalizer.analizza();
    }
    
}
