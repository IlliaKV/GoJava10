package multithreadshomework;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Random;

public class GeometryInMotion extends Application{
    private static final int WIDTH_WINDOW   = 900;
    private static final int HEIGHT_WINDOW  = 600;
    private RectangleGenerate rectangleGenerate;
    private Random rn = new Random();
    private int numberOfRectangles = rn.nextInt(10 - 3 + 1) + 3;;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(WIDTH_WINDOW);
        primaryStage.setHeight(HEIGHT_WINDOW);
        Pane root = new Pane();

        Pane rectanglesRoot = new Pane();
        root.getChildren().addAll(rectanglesRoot);

        rectangleGenerate = new RectangleGenerate(numberOfRectangles);

        drawUI(root, rectanglesRoot);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public void drawUI(Pane root, Pane rectanglesRoot){
        Button button = new Button("«Multy Threads»");
        button.setTranslateX(15);
        button.setTranslateY(15);
        button.setOnAction((event) -> {
            numberOfRectangles = rn.nextInt(10 - 3 + 1) + 3;
            rectangleGenerate.clear(rectanglesRoot);
            try {
                rectangleGenerate.draw(rectanglesRoot);
                rectangleGenerate.move();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Button button2 = new Button("«Single Thread»"); // не работает
        button2.setTranslateX(135);
        button2.setTranslateY(15);
        button2.setOnAction((event) -> {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    numberOfRectangles = rn.nextInt(10 - 3 + 1) + 3;
                    rectangleGenerate.clear(rectanglesRoot);
                    try {
                        rectangleGenerate.draw(rectanglesRoot);
                        rectangleGenerate.moveInOneThread();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            Thread thread = new Thread(runnable);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        root.getChildren().addAll(button, button2);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
