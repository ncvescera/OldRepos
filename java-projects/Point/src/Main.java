public class Main {

    public static void main(String argv[]){
        float distanza;
        
        Punto P0 = new Punto(2,4);
        Punto P1 = new Punto(-2,1);
        
        Cerchio c1 = new Cerchio();
        
        distanza = P1.distanzaOrigine();
        System.out.println("La distanza di P1 dall'origine e': " + distanza);
        
        distanza = P1.distanzaAltroPunto(P0);
        System.out.println("La distanza di P1 da P0 e': " + distanza);
        
        
        
        
    }
}
