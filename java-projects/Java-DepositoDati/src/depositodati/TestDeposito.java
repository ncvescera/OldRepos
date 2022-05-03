package depositodati;

/**
 * Classe principale
 * @author smpiccini e ncvescera
 */
public class TestDeposito {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Deposito deposito = new Deposito(10000+(int)(Math.random()*5000));
        Produttore p = new Produttore(deposito);
        
        p.start();
        
        final int dataPerThread=400;
        Lettore [] lettori= new Lettore[deposito.getSize()/dataPerThread];
        
        for(int i = 0; i < lettori.length; i++){
            lettori[i] = new Lettore(deposito, dataPerThread);
            lettori[i].start();
        }
    }
    
}
