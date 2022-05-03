package esethread;

public class EseThread {

    public static void main(String[] args) throws Exception{
        Risorsa risorsa = new Risorsa();
        
        Thread uno = new Vigenere(0,13,0,13,"1",risorsa);
        Thread due = new Vigenere(0,13,13,26,"2",risorsa);
        Thread tre = new Vigenere(13,26,0,13,"3",risorsa);
        Thread quattro = new Vigenere(13,26,13,26,"4",risorsa);
        
        uno.start();
        System.out.println(uno.getName());
        due.start();
        System.out.println(due.getName());
        tre.start();
        System.out.println(tre.getName());
        quattro.start();
        System.out.println(quattro.getName());
        
        System.out.print("\nMatrice:\n");
        
        uno.join();
        due.join();
        tre.join();
        quattro.join();
        
        risorsa.print();
    }

}
