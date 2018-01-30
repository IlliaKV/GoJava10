package windowAppJavaFX.snowman.star;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Scanner;

public class Main extends Application{
    private static final int WIDTH_WINDOW   = 900;
    private static final int HEIGHT_WINDOW  = 600;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(WIDTH_WINDOW);
        primaryStage.setHeight(HEIGHT_WINDOW);

        Pane root   = new Pane();
        Scanner in  = new Scanner(System.in);

        System.out.println("input X:");
        double X = in.nextDouble();
        System.out.println("input Y:");
        double Y = in.nextDouble();
        System.out.println("input Radius:");
        double radius = in.nextDouble();

        StarGenerator starGenerator = new StarGenerator(X, Y, radius);
        starGenerator.draw(root);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
