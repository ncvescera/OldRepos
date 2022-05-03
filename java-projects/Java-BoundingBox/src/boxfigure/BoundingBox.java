package boxfigure;

//import java.lang.reflect.*;
import javafx.geometry.Point2D;

public abstract class BoundingBox {
    protected Point2D max;
    protected Point2D min;
    
    abstract Point2D calcMin();
    abstract Point2D calcMax();
  
    public Point2D getMin(){
        return this.min;
    }
    
    public Point2D getMax(){
        return this.max;
    }
    
    public boolean contain(Point2D max, Point2D min){
        return ((min.getX() >= this.min.getX())&&(max.getX() <= this.max.getX())) && ((min.getY() <= this.min.getY())&&(max.getY() >= this.max.getY()));
    
        /*if(((min.getX() >= this.min.getX())&&(max.getX() <= this.max.getX())) && ((min.getY() <= this.min.getY())&&(max.getY() >= this.max.getY())))
                return true;
        else
            return false;*/
    }
    
    public boolean contain(BoundingBox figura){
        return ((figura.getMin().getX() >= this.min.getX())&&(figura.getMin().getX() <= this.max.getX())) && ((figura.getMin().getY() <= this.min.getY())&&(figura.getMax().getY() >= this.max.getY()));

    }
    
    //((min.getX() >= this.min.getX())&&(max.getX <= this.max.getX())) && ((min.getY() <= this.min.getY())&&(max.getY() >= this.max.getY()))
    
    
}
