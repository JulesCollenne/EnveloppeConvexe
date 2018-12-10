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

    static boolean ProduitVectorielDroite(Point2D v1, Point2D v2){
        return v1.getX() * v2.getY() - v1.getY() * v2.getX() > 0;
    }

    static boolean ProduitVectorielGauche(Point2D v1, Point2D v2) {
        return !(v1.getX() * v2.getY() - v1.getY() * v2.getX() > 0);
    }

    static boolean CasDuSegment(ArrayList<Point2D> contour) {
        double valeurX = contour.get(0).getX();
        for (Point2D aContour : contour) {
            if (aContour.getX() != valeurX)
                return false;
        }
        return true;
    }

    static boolean DeuxPointsIdentiques(Point2D[] nuage,int taille){
        for(int i = 0;i < taille; i++){
            for(int j = i+1;j <= taille;j++){
                if(nuage[i].getX() == nuage[j].getX() && nuage[i].getY() == nuage[j].getY())
                    return true;
            }
        }
        return false;
    }

    public static double minX(Point2D[] nuage) {
        double min = nuage[0].getX();
        for(int i = 1;i < nuage.length; i++){
            if(min > nuage[i].getX())
                min = nuage[i].getX();
        }
        return min;
    }

    public static double maxX(Point2D[] nuage) {
        double max = nuage[0].getX();
        for(int i = 1;i < nuage.length; i++){
            if(max < nuage[i].getX())
                max = nuage[i].getX();
        }
        return max;
    }

    public static double minY(Point2D[] nuage) {
        double min = nuage[0].getX();
        for(int i = 1;i < nuage.length; i++){
            if(min > nuage[i].getY())
                min = nuage[i].getY();
        }
        return min;
    }

    public static double maxY(Point2D[] nuage) {
        double max = nuage[0].getY();
        for(int i = 1;i < nuage.length; i++){
            if(max < nuage[i].getY())
                max = nuage[i].getY();
        }
        return max;
    }
}
