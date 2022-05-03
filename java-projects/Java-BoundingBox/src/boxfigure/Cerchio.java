package boxfigure;

import javafx.geometry.Point2D;

public class Cerchio extends BoundingBox{
    private final Point2D centro;
    private final double raggio;
    
    public Cerchio(double x, double y, double raggio){
        this.centro = new Point2D(x,y);
        this.raggio = raggio;
        this.max = this.calcMax();
        this.min = this.calcMin();
    }

    @Override
    public final Point2D calcMin() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Point2D point;
        point = new Point2D((this.centro.getX()-this.raggio),(this.centro.getY()+this.raggio));
        return point;
    }

    @Override
    public final Point2D calcMax() {
        Point2D point;
        point = new Point2D((this.centro.getX()+this.raggio),(this.centro.getY()-this.raggio));
        return point;
    }

    public Point2D getCentro(){
        return this.centro;
    }
    
    public double getRaggio(){
        return this.raggio;
    }
}
