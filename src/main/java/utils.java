import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Random;

class utils {

    static Point2D[] CreerNuage(int nbPoints, int largeurCanevas, int hauteurCanevas){
        Point2D[] nuage = new Point2D[nbPoints];
        Random rand = new Random();
        for(int i=0;i<nbPoints;i++){
            nuage[i] = new Point2D(rand.nextInt(largeurCanevas-20)+10,rand.nextInt(hauteurCanevas-20)+10);
        }
        return nuage;
    }

    private static void AfficheNuage(GraphicsContext graphicsContext, Point2D[] nuage) {
        for (Point2D aNuage : nuage) {
            graphicsContext.setFill(Color.AQUAMARINE);
            graphicsContext.fillOval(aNuage.getX() - 3, aNuage.getY() - 3, 6, 6);
        }
    }

    private static void AfficheEnveloppe(GraphicsContext graphicsContext, Enveloppe env) {
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
        graphicsContext.fillOval(env.contour.get(0).getX()-3, env.contour.get(0).getY()-3, 6, 6);
    }

    private static void AfficheTriangulation(GraphicsContext graphicsContext, Enveloppe env){
        graphicsContext.setFill(Color.PAPAYAWHIP);
        for(int i=0;i<env.triang.aretes.size();i+=2){
            graphicsContext.strokeLine(env.contour.get(env.triang.aretes.get(i)).getX(),env.contour.get(env.triang.aretes.get(i)).getY(),env.nuage[env.triang.aretes.get(i)].getX(),env.nuage[env.triang.aretes.get(i)].getY());
        }
    }

    static void Affichage(GraphicsContext graphicsContext, Enveloppe env) {
        graphicsContext.clearRect(0, 0, 400, 300);
        utils.AfficheNuage(graphicsContext,env.nuage);
        utils.AfficheEnveloppe(graphicsContext,env);
        utils.AfficheTriangulation(graphicsContext,env);
    }
}
