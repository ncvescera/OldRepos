package depositodati;

/**
 * Classe per analizzare i dati del deposito dinamicamente
 * @author smpiccini e ncvescera
 */
public class Lettore extends Thread{
    private Deposito deposito;
    private final int toRead;
    
    /**
     * Metodo costruttore
     * @param deposito Risorsa condivisa
     * @param toRead Numero di elementi da leggere
     */
    public Lettore(Deposito deposito, int toRead){
        this.deposito=deposito;
        this.toRead=toRead;
    }
    
    @Override
    public void run(){
        deposito.leggi(toRead);
    }
}
