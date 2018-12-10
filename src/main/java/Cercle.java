import javafx.geometry.Point2D;

public class Cercle {
    Point2D centre;
    double rayon;

    public boolean Contient(Point2D point) {
        return Math.sqrt(Math.pow(point.getX()-centre.getX(),2)+Math.pow(point.getY()-centre.getY(),2)) < rayon;
    }
}
