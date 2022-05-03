/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheFirst;

/**
 *
 * @author pythonraider
 */
public class TheFirst {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float distO;
        
        Punto P1 = new Punto(2,5);
        
        System.out.println("X: "+P1.getX());
        System.out.println("Y: "+P1.getY());
        
        Punto P2 = new Punto(1,2);
        
        System.out.println("X: "+P1.getX());
        System.out.println("Y: "+P1.getY());
        
        System.out.println("La distanza tra P1 e P2 è: "+P1.distToPoint(P2));
        /*P1.move(3, 7);
        System.out.println("X: "+P1.getX());
        System.out.println("Y: "+P1.getY());
        
        P1.move(6,P1.getY());
        System.out.println("X: "+P1.getX());
        System.out.println("Y: "+P1.getY());
        */
        distO = P1.distToO();
        System.out.println("La distanza dall'origine è: "+distO);
        
    }
    
}
