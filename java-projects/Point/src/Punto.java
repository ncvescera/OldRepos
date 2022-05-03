public class Punto {

    private float x;

    private float y;

    public Punto(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Punto() {
        x = 0;
        y = 0;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void spostaPunto(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float distanzaOrigine() {
        float distanza;
        
        distanza = (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        return distanza;
    }

    public float distanzaAltroPunto(Punto P) {
        float distanza;
       
        distanza = (float) Math.sqrt(Math.pow((this.x - P.x), 2) + Math.pow((this.y - P.y), 2));
        return distanza;
    }
}
