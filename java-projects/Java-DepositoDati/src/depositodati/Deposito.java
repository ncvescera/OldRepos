package depositodati;

/**
 * Risorsa condivisa
 * @author smpiccini e ncvescera
 */
public class Deposito {
    private int[] data;
    private int lastRead;
    
    /**
     * Metodo costruttore
     * @param dim Dimensione dell'array
     */
    public Deposito(int dim){
        data = new int[dim];
        lastRead = 0;
    }
    
    /**
     * Metodo per riempire una posizione dell'array
     * @param pos Posizione dell'array
     * @param n Valore da inserire
     */
    public void scrivi(int pos, int n){
        data[pos] = n;
    }
    
    /**
     * 
     * @return Dimensione dell'array
     */
    public int getSize(){
        return data.length;
    }
    
    /**
     * Metodo per leggere gli elementi dell'array
     * @param n Elementi da leggere
     */
    synchronized public void leggi(int n){
        int toRead = lastRead;
        lastRead += n;
        System.out.println(Thread.currentThread().getName()+" legge:");
        for(int i = toRead; i < lastRead; i++){
            System.out.println(data[i]);
        }
    }
}
