import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Algo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        int largeurCanevas = 400, hauteurCanevas = 300;
        int nbPoints = 20;

        Group root = new Group();
        Canvas canvas = new Canvas(largeurCanevas, hauteurCanevas);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.AQUAMARINE);

        Enveloppe env = new Enveloppe(utils.CreerNuage(nbPoints,largeurCanevas,hauteurCanevas));

        Enveloppe.ConstruitEnveloppe(env);
        env.triang.Triangule(env);

        utils.Affichage(graphicsContext,env);

        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}