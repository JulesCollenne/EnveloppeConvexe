import javafx.geometry.Point2D;

class Triangle {
    Point2D[] points = new Point2D[3];

    Triangle(Point2D p1, Point2D p2, Point2D p3) {
        points[0] = p1;
        points[1] = p2;
        points[2] = p3;
    }

    public boolean Contient(Point2D point){
        Point2D a = points[0],b =points[1],c = points[2];

        double contientX = point.getX()-a.getX();
        double contientY = point.getY()-a.getY();

        boolean s_ab = (b.getX()-a.getX()) * contientY - (b.getY()-a.getY())*contientX > 0;

        if((c.getX()-a.getX())*contientY-(c.getY()-a.getY())*contientX > 0 == s_ab) return false;

        return (c.getX() - b.getX()) * (point.getY() - b.getY()) - (c.getY() - b.getY()) * (point.getX() - b.getX()) > 0 == s_ab;
    }

    public Cercle CercleCirconscrit(){ //TODO
        return new Cercle();
    }
}

