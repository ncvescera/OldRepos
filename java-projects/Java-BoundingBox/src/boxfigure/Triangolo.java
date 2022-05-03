package boxfigure;

import javafx.geometry.Point2D;

public class Triangolo extends BoundingBox{
    private final Point2D a;
    private final Point2D b;
    private final Point2D c;
    
    public Triangolo(Point2D a, Point2D b, Point2D c){
        this.a = a;
        this.b = b;
        this.c = c;
        
        this.min = calcMin();
        this.max = calcMax();
    }
    @Override
    final Point2D calcMin() {
        Point2D punto = new Point2D(this.a.getX(),this.c.getY());
        return punto;
    }

    @Override
    final Point2D calcMax() {
        return this.b;
    }
    
    public Point2D getA(){
        return this.a;
    }
    
    public Point2D getB(){
        return this.b;
    }
    
    public Point2D getC(){
        return this.c;
    }
}
