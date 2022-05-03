public class Cerchio {
    private float raggio;
    private Punto centro;
    
    
Cerchio(){
raggio=0;
}
    Cerchio(Punto centro, float raggio){
        this.centro = centro;
        this.raggio = raggio;
} 


public float area(float raggio){
    return (float)( Math.pow(raggio,raggio) * Math.PI);
}

public float circonferenza(float raggio){
    return (float)(2 * (Math.PI) * raggio);
}

public boolean contienePunto(Punto P0){
    boolean contiene;
    if((P0.distanzaOrigine())<=(this.raggio)){
        contiene = true;
    }
    else {
        contiene = false;
    }
    
    return contiene;
}

public float getRaggio(){
    return raggio;
}

public void setRaggio(float raggio){
    this.raggio = raggio;
}
}

