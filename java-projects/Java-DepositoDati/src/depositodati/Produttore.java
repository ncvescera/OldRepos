package depositodati;

/**
 * Classe per popolare il deposito dinamicamnete
 * @author smpiccini e ncvescera
 */
public class Produttore extends Thread{
    private Deposito deposito;
    
    /**
     * Metodo costruttore
     * @param deposito Risorsa condivisa
     */
    public Produttore(Deposito deposito){
        this.deposito=deposito;
    }
    
    @Override
    public void run(){
        for(int i = 0; i < deposito.getSize(); i++){
            deposito.scrivi(i, i);
        }
    }
}
