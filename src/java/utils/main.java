package utils;

import utils.utils;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;


import java.util.ArrayList;
import java.util.List;

public class main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        int largeurCanevas = 400, hauteurCanevas = 300;

        Group root = new Group();
        Canvas canvas = new Canvas(largeurCanevas, hauteurCanevas);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.AQUAMARINE);


        int nbPoints = 50;


        Point2D[] nuage = utils.CreerNuage(nbPoints,largeurCanevas,hauteurCanevas);
        Enveloppe env = new Enveloppe(nbPoints);

        graphicsContext.setLineWidth(1);

        for(int i=0;i<nbPoints;i++){
            graphicsContext.setFill(Color.AQUAMARINE);
            graphicsContext.fillOval(nuage[i].getX()-5, nuage[i].getY()-5, 10, 10);
            for(int j=0;j<nbPoints;j++) {
                if (env.aretes[i][j]) {
                    graphicsContext.setFill(Color.BURLYWOOD);
                    graphicsContext.fillOval(nuage[i].getX()-5, nuage[i].getY()-5, 10, 10);
                    graphicsContext.fillOval(nuage[j].getX()-5, nuage[j].getY()-5, 10, 10);
                    graphicsContext.strokeLine(nuage[i].getX(),nuage[i].getY(),nuage[j].getX(),nuage[j].getY());
                }
            }
        }

        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}