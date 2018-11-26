package utils;

import javafx.geometry.Point2D;

import java.awt.*;
import java.util.Arrays;

public class Enveloppe {

    Point2D[] nuage;
    boolean aretes[][];


    public Enveloppe(int nbPoints,Point2D[] nuage) {
        aretes = new boolean[nbPoints][nbPoints];
        for(int i=0;i<nbPoints;i++) {
            for (int j = 0; j < nbPoints; j++) {
                aretes[i][j] = false;
            }
        }
        this.nuage = nuage;
    }

    public static void Fusion(Enveloppe env1,Enveloppe env2,Enveloppe envFinale){


        Point2D pointdegauche = env1.nuage[env1.nuage.length-1];
        Point2D pointdedroite = env2.nuage[0];



        for(int i=0;i<env1.nuage.length;i++) {
            for (int j = i; j < env1.nuage.length; j++) {
                envFinale.aretes[i][j] = env1.aretes[i][j];
            }
        }
        for(int i=env1.nuage.length;i<envFinale.nuage.length;i++){
            for(int j=i;j<envFinale.nuage.length;j++) {
                envFinale.aretes[i][j] = env2.aretes[i-env1.nuage.length][j-env1.nuage.length];
            }
        }

        //TODO En fait, il faut faire en sorte que envFinale soit rangée de sorte à ce que l'on puisse effectuer les "rotations"

    }


    public static void ConstruitEnveloppe(Enveloppe enveloppe){

        enveloppe.nuage = utils.TriParXCroissant(enveloppe.nuage);

        int nbPoints = enveloppe.nuage.length;
        int milieu = enveloppe.nuage.length/2;

        Enveloppe sousEnveloppe1 = new Enveloppe(nbPoints,new Point2D[milieu]);;
        Enveloppe sousEnveloppe2 = new Enveloppe(nbPoints,new Point2D[nbPoints-milieu]);

        if(nbPoints > 3){

            for(int i=0;i<milieu;i++)
                sousEnveloppe1.nuage[i] = enveloppe.nuage[i];

            for(int i=0;i<nbPoints-milieu;i++)
                sousEnveloppe2.nuage[i] = enveloppe.nuage[i+milieu];

            ConstruitEnveloppe(sousEnveloppe1);
            ConstruitEnveloppe(sousEnveloppe2);
        }

        if(nbPoints == 2){
            enveloppe.aretes[0][1] = true;
            return;
        }

        if(nbPoints == 3){
            enveloppe.aretes[0][1] = true;
            enveloppe.aretes[1][2] = true;
            enveloppe.aretes[0][2] = true;
            return;
        }

         Fusion(sousEnveloppe1,sousEnveloppe2,enveloppe);
    }
}
