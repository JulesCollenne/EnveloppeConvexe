package utils;

import javafx.geometry.Point2D;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Enveloppe {

    Point2D[] nuage;
    ArrayList<Point2D> contour;


    public Enveloppe(Point2D[] nuage) {
        contour = new ArrayList<Point2D>();

        this.nuage = nuage;
    }

    public static void Fusion(Enveloppe env1,Enveloppe env2,Enveloppe envFinale){

        double angleActuel,anglePrecedent;
        int indexEnv1 = Calculs.IndexDuMaxX(env1.contour),indexEnv2 = Calculs.IndexDuMinX(env2.contour);

        Point2D pointGauche = env1.contour.get(indexEnv1);
        Point2D pointDroite = env2.contour.get(indexEnv2);

        envFinale.contour.addAll(env1.contour);
        envFinale.contour.addAll(env2.contour);

        //TODO En fait, il faut faire en sorte que envFinale soit rangée de sorte à ce que l'on puisse effectuer les "rotations"


        anglePrecedent = Calculs.CalculAngleDansPlan(pointGauche,pointDroite);
/*
        do{
            indexEnv1 = (indexEnv1 - 1) % env1.contour.length;
            pointGauche = env1.contour.get(indexEnv1]
            angleActuel =
            anglePrecedent = angleActuel;
        } while(angleActuel >= anglePrecedent);*/


    }


    public static void ConstruitEnveloppe(Enveloppe enveloppe){

        enveloppe.nuage = Calculs.TriParXCroissant(enveloppe.nuage);

        int nbPoints = enveloppe.nuage.length;
        int milieu = enveloppe.nuage.length/2;

        Enveloppe sousEnveloppe1 = new Enveloppe(new Point2D[milieu]);
        Enveloppe sousEnveloppe2 = new Enveloppe(new Point2D[nbPoints-milieu]);

        if(nbPoints > 3){

            for(int i=0;i<milieu;i++)
                sousEnveloppe1.nuage[i] = enveloppe.nuage[i];

            for(int i=0;i<nbPoints-milieu;i++)
                sousEnveloppe2.nuage[i] = enveloppe.nuage[i+milieu];

            ConstruitEnveloppe(sousEnveloppe1);
            ConstruitEnveloppe(sousEnveloppe2);
        }

        if(nbPoints == 2){
            enveloppe.contour.add(enveloppe.nuage[0]);
            enveloppe.contour.add(enveloppe.nuage[1]);
            return;
        }

        if(nbPoints == 3){
            enveloppe.contour.add(enveloppe.nuage[0]);
            enveloppe.contour.add(enveloppe.nuage[1]);
            enveloppe.contour.add(enveloppe.nuage[2]);
            return;
        }
         Fusion(sousEnveloppe1,sousEnveloppe2,enveloppe);
    }
}
