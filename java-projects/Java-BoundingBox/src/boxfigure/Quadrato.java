package boxfigure;

import javafx.geometry.Point2D;

public class Quadrato extends BoundingBox {
    private final double lato;
    
    public Quadrato(double lato, Point2D min){
        this.lato = lato;
        
        this.min = min;
        this.max = calcMax();
    }
    
    @Override
    Point2D calcMin() {
        return this.min; 
    }

    @Override
    final Point2D calcMax() {
        Point2D punto;
        double x,y;
        
        y = this.min.getY()-this.lato;
        x = y + this.lato;
        punto = new Point2D(x,y);
        
        return punto;
    }
    
    public double getLato(){
        return this.lato;
    }
    
}
