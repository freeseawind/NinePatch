package javafx;


import freeseawind.ninepatch.javafx.FxNinePatch;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * 
 * @author wallace
 *
 */
public class JavaFxTest extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        primaryStage.setTitle("NinePatch Test");

        Group root = new Group();

        Scene sc = new Scene(root, 480, 360);

        primaryStage.setScene(sc);

        Canvas canvas = new Canvas();

        canvas.widthProperty().bind(sc.widthProperty());

        canvas.heightProperty().bind(sc.heightProperty());

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Image img = new Image(getClass().getResource("/icon_qipao.9.png").toExternalForm());

        FxNinePatch np = new FxNinePatch(img);
        
        np.drawNinePatch(img, gc, 28, 28, 400, 100);

        root.getChildren().add(canvas);

        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
