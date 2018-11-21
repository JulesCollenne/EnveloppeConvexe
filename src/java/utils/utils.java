package utils;

import javafx.geometry.Point2D;

import java.util.Random;

public class utils {

    public static Point2D[] CreerNuage(int nbPoints,int largeurCanevas,int hauteurCanevas){
        Point2D[] nuage = new Point2D[nbPoints];
        Random rand = new Random();
        for(int i=0;i<nbPoints;i++){
            nuage[i] = new Point2D(rand.nextInt(largeurCanevas),rand.nextInt(hauteurCanevas));
        }
        return nuage;
    }
}
