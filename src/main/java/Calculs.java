import javafx.geometry.Point2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Calculs {

    public static Point2D[] TriParXCroissant(Point2D[] nuage){
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

    public static double ProduitScalaire(Point2D v1, Point2D v2){
        return v1.getX()*v2.getX() + v1.getY()*v2.getY();
    }

    public static Point2D Vecteur(Point2D p1,Point2D p2){
        return new Point2D(p2.getX()-p1.getX(),p2.getY()-p1.getY());
    }

    public static double Norme(Point2D v1){
        return Math.sqrt(Math.pow(v1.getX(),2) + Math.pow(v1.getY(),2));
    }

    public static double CalculAngle(Point2D v1,Point2D v2){
        return Math.acos(ProduitScalaire(v1,v2)/(Norme(v1)*Norme(v2)));
    }

    public static double CalculAngleDansPlan(Point2D p1, Point2D p2){

        Point2D vecteur = Vecteur(new Point2D(0,1),new Point2D(0,0));//Vecteur(p1,p2);
        Point2D vecteurI = new Point2D(1.,0.);
        System.out.println(CalculAngle(vecteur,vecteurI));
        return CalculAngle(vecteur,vecteurI);
    }

    public static double ProduitVectoriel(Point2D v1,Point2D v2){
        return v1.getX()*v2.getY() - v1.getY()*v2.getX();
    }

    public static int IndexDuMinX(ArrayList<Point2D> contour){
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

    public static int IndexDuMaxX(ArrayList<Point2D> contour){
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

}
