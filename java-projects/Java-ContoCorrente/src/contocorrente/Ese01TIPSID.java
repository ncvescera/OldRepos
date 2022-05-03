package contocorrente;

/**
 *
 * @author informatica
 */
public class Ese01TIPSID {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Contocorrente conto = new Contocorrente("iiosonoiban",400);
   
        Correntista uno = new Correntista("UNO","aaa",conto,"prelievo",100);
        Correntista due = new Correntista("DUE","bbb",conto,"versamento",200);
        
        uno.start();
        due.start();
        
        due.join();
        uno.join();
        
        conto.printMovimenti();
        System.out.println(conto.getSaldo());
    }
    
}
