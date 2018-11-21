package utils;

import javafx.geometry.Point2D;

import java.awt.*;

public class Enveloppe {

    boolean aretes[][];

    public Enveloppe(int nbPoints) {
        aretes = new boolean[nbPoints][nbPoints];
        for(int i=0;i<nbPoints;i++)
            for(int j=0;j<nbPoints;j++)
                aretes[i][j] = false;
            aretes[1][4] = true;
    }

    public void CreerEnveloppe(Point2D[] nuage){
        if(nuage.length > 3){
            int milieu = nuage.length/2;
            Point2D[] sousNuage1 = new Point2D[milieu];
            Point2D[] sousNuage2 = new Point2D[nuage.length-milieu];
            for(int i=0;i<milieu;i++)
                sousNuage1[i] = nuage[i];
            for(int i=milieu;i<nuage.length;i++)
                sousNuage2[i] = nuage[i];
            CreerEnveloppe(sousNuage1);
            CreerEnveloppe(sousNuage2);
        }



    }
}
