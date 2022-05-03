package assassination_airport;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Nicolò Vescera
 */
public class Aeroporto {
    public String           nome;
    private ArrayList<Volo>  voli;
    
    public Aeroporto(String nome){
        this.nome = nome;
        this.voli = new ArrayList();
    }
    
    public void addVolo(Volo nuovo){
        if(nuovo != null && !nuovo.codice_volo.equals("") && !nuovo.compagnia.equals("") && !nuovo.data.equals("") && !nuovo.destinazione.equals("")){
            if(checkVolo(nuovo)){
                this.voli.add(nuovo);
                JOptionPane.showMessageDialog(null, "Volo aggiunto correttamente :D");
            }
            else
                JOptionPane.showMessageDialog(null, "Non posso aggiungere 2 voli identici !");
        }
        else{
            JOptionPane.showMessageDialog(null, "C'è stato un errore, impossibile aggiungere il volo :/");
            System.err.println("Errore! Null.pointer.exception!");
        }
    }
    
    //funzione per controllare che non ci siano 2 voli uguali
    private boolean checkVolo(Volo nuovo){
        if(!this.voli.isEmpty()){
            for(Volo elem:this.voli){
                if(elem.codice_volo.equals(nuovo.codice_volo) || elem.data.equals(nuovo.data) && elem.compagnia.equals(nuovo.compagnia)  && elem.destinazione.equals(nuovo.destinazione)){
                    return false;
                }
            }
        }
        
        //altrimenti 
        return true;
    }
    
    //stampa dei voli
    public void printVoli(){
        for(Volo volo:this.voli){
            volo.print();
        }
    }
    
    //metodo che ritorna un arraylist con tutti i voli che hanno il codice uguale a quello passatogli
    public ArrayList cercaPerCodice(String codice){
        ArrayList<Volo> result = new ArrayList();
        
        for(Volo elem:this.voli){
            if(elem.codice_volo.equals(codice))
                result.add(elem);
        }
        
        return result;
    }
    
    //metodo che ritorna un arraylist con tutti i voli che hanno la destinazione uguale a quello passatogli
    public ArrayList cercaPerDestinazione(String codice){
        ArrayList<Volo> result = new ArrayList();
        
        for(Volo elem:this.voli){
            if(elem.destinazione.equals(codice))
                result.add(elem);
        }
        
        return result;
    }
}
