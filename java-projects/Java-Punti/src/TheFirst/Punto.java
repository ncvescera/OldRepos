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
public class Punto {
    private float x;
    private float y;
    /**
     * Metodo Costruttore che dati valori in input inizializza x e y
     * @param nuovoX valore numerico x
     * @param nuovoY valore numerico y
     */
    public Punto(float nuovoX, float nuovoY){
        x = nuovoX;
        y = nuovoY;
    }
    /**
     * Medoto Costruttore che inizializza xe y a 0
     */
    public Punto(){
        x = 0;
        y = 0;
    }
    /**
     * Ritorna il valore di x
     * @return il valore di x
     */
    public float getX(){
        return x;
    }
    /**
     * Ritorna il valore di y
     * @return valore di y
     */
    public float getY(){
        return y;
    }
    public float distToO(){
        float dist;
        dist = (float)Math.pow(x, 2) + (float)Math.pow(y,2);
        dist = (float)Math.sqrt(dist); // Math ritorna sempre un double
        return dist;
    }
    public void move(float nuovoX, float nuovoY){
        x = nuovoX;
        y = nuovoY;
    }
    public float distToPoint(Punto P){
        //pitagora 
        float dist;
        dist = (float) Math.pow((P.x - this.x),2) + (float)Math.pow((P.y - this.y), 2);
        dist = (float)Math.sqrt(dist);
        
        if(dist < 0)
            dist *= -1;
        
        return dist;
    }
}
