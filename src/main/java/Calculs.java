import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.Arrays;

class Calculs {

    static Point2D[] TriParXCroissant(Point2D[] nuage){
        Point2D[] nuageFinal = new Point2D[nuage.length];
        double nuageX[] = new double[nuage.length];

        for(int i = 0;i < nuage.length; i++){
            nuageX[i] = nuage[i].getX();
        }
        Arrays.sort(nuageX);

        for(int i = 0;i< nuage.length; i++){
            nuageFinal[i] = new Point2D(nuageX[i],nuage[i].getY());
        }
        return nuageFinal;
    }

    static int IndexDuMinX(ArrayList<Point2D> contour){
        double min = contour.get(0).getX();
        int indexMin = 0;
        for(int i = 0;i < contour.size();i++){
            if(min > contour.get(i).getX()){
                min = contour.get(i).getX();
                indexMin = i;
            }
        }
        return indexMin;
    }

    static int IndexDuMaxX(ArrayList<Point2D> contour){
        double max = contour.get(0).getX();
        int indexMax = 0;
        for(int i = 0;i < contour.size();i++){
            if(max < contour.get(i).getX()){
                max = contour.get(i).getX();
                indexMax = i;
            }
        }
        return indexMax;
    }

    static double ProduitScalaire(Point2D v1, Point2D v2){
        return v1.getX() * v2.getX() + v1.getY() * v2.getY();
    }

    static boolean ProduitVectorielDroite(Point2D v1, Point2D v2){
        return v1.getX() * v2.getY() - v1.getY() * v2.getX() > 0;
    }

    static boolean ProduitVectorielGauche(Point2D v1, Point2D v2) {
        return !(v1.getX() * v2.getY() - v1.getY() * v2.getX() > 0);
    }

    public static boolean CasSegment(Point2D pointGauche, Point2D pointDroite) {
        //return pointGauche.getX() == pointDroite.getX();
        return false;
    }

    public static boolean Intesectionne(Enveloppe env,int indexP1,int indexP2){
        for(int i=0;i<env.contour.size();i++){

        }
        return true;
    }

    public static double signe(Point2D p1,Point2D p2,Point2D p3){
        return (p1.getX() - p3.getX()) * (p2.getY() - p3.getY()) - (p2.getX() - p3.getX()) * (p1.getY() - p3.getY());
    }

    public static boolean DansTriangle(Triangle triangle,Point2D point){
        double d1,d2,d3;

        d1 = signe()
    }
}
