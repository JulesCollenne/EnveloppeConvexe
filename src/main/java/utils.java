import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

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
        for(int i=0;i<env.contour.size()-1;i++){
            graphicsContext.strokeLine(env.contour.get(i).getX(),env.contour.get(i).getY(),env.contour.get(i+1).getX(),env.contour.get(i+1).getY());
            graphicsContext.setFill(Color.BURLYWOOD);
            graphicsContext.fillOval(env.contour.get(i).getX()-3, env.contour.get(i).getY()-3, 6, 6);
        }
        int i = env.contour.size()-1;
        graphicsContext.strokeLine(env.contour.get(i).getX(),env.contour.get(i).getY(),env.contour.get(0).getX(),env.contour.get(0).getY());
        graphicsContext.setFill(Color.BURLYWOOD);
        graphicsContext.fillOval(env.contour.get(i).getX()-3, env.contour.get(i).getY()-3, 6, 6);
        graphicsContext.fillOval(env.contour.get(env.contour.size()-1).getX()-3, env.contour.get(env.contour.size()-1).getY()-3, 6, 6);
    }

    public static void Affichage(GraphicsContext graphicsContext, Enveloppe env) {
        graphicsContext.clearRect(0, 0, 400, 300);
        utils.AfficheNuage(graphicsContext,env.nuage);
        utils.AfficheEnveloppe(graphicsContext,env);
    }
}
