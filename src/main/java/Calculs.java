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
}
