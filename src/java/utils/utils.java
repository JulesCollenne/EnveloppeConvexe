package utils;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.Random;

public class utils {

    public static Point2D[] CreerNuage(int nbPoints,int largeurCanevas,int hauteurCanevas){
        Point2D[] nuage = new Point2D[nbPoints];
        Random rand = new Random();
        for(int i=0;i<nbPoints;i++){
            nuage[i] = new Point2D(rand.nextInt(largeurCanevas-20)+10,rand.nextInt(hauteurCanevas-20)+10);
        }
        return nuage;
    }

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

    public static void AfficheMatrice(boolean M[][]){
        for(int i=0;i<M.length;i++){
            for(int j=i;j<M[i].length;j++){
                System.out.print(M[i][j]);
            }
            System.out.println();
        }
    }

    public static void AfficheNuage(GraphicsContext graphicsContext, Point2D[] nuage) {
        for(int i=0;i<nuage.length;i++){
            graphicsContext.setFill(Color.AQUAMARINE);
            graphicsContext.fillOval(nuage[i].getX()-3, nuage[i].getY()-3, 6, 6);
        }
    }

    public static void AfficheEnveloppe(GraphicsContext graphicsContext, Enveloppe env) {
        graphicsContext.setLineWidth(1);
        for(int i=0;i<env.aretes.length;i++){
            for(int j=i;j<env.aretes[i].length;j++) {
                if (env.aretes[i][j]) {
                    graphicsContext.strokeLine(env.nuage[i].getX(),env.nuage[i].getY(),env.nuage[j].getX(),env.nuage[j].getY());
                    graphicsContext.setFill(Color.BURLYWOOD);
                    graphicsContext.fillOval(env.nuage[i].getX()-3, env.nuage[i].getY()-3, 6, 6);
                    graphicsContext.fillOval(env.nuage[j].getX()-3, env.nuage[j].getY()-3, 6, 6);
                }
            }
        }
    }

    public static void Affichage(GraphicsContext graphicsContext, Enveloppe env) {
        utils.AfficheNuage(graphicsContext,env.nuage);
        utils.AfficheEnveloppe(graphicsContext,env);
    }
}
