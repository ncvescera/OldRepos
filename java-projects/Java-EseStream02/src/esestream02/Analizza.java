package esestream02;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ncvescera
 */
public class Analizza {
    
    private ArrayList<Record> array;
    
    public Analizza(ArrayList<Record> array){
        this.array = array;
    }
    /*
        Confronta il primo elemento con tutti gli altri, se cognome e nome sono uguali aggiunge l'indice di quell'elemento ad un array e somma alla media
        il voto di quell'elemento. L'array con gli indici viene ordinato e poi vengono rimossi questi ultimi dall'array con i Record 
        ( devono essere rimossi in ordine decrescente )
        
        Il ciclo si ferma quando non c'è più nessun elemento
    */
    public void analizza(){
        ArrayList<Integer> indexArray = new ArrayList(); //array per memorizzare gli indici da togliere
        
        while(this.array.size() != 0){
            Record tmp = this.array.get(0); //confronto sempre la prima posizione
            float media = tmp.getVoto(); //media per ogni ciclo
            indexArray.add(0); //sempre rimuovere la prima posizione
            
            //confronto per ogni materia
            for(int i=1; i< this.array.size(); i++){
                if(tmp.getCognome().equals(array.get(i).getCognome()) && tmp.getMateria().equals(array.get(i).getMateria())){
                    media += array.get(i).getVoto();
                    indexArray.add(i);
                }
            }
            
            Collections.sort(indexArray); //ordina l'array
            
            //rimozione indici già analizzati
            for (int i = indexArray.size()-1; i >= 0; i--) {
                int indexToRemove = indexArray.get(i);
                array.remove(indexToRemove);
            }           
            
            media /= indexArray.size(); //calcolo della media
            System.out.println(tmp.getCognome()+","+tmp.getMateria()+","+media);
            
            indexArray = new ArrayList(); //azzero array di indici
        }
    }
}
