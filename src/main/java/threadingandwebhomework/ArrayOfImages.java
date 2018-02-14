package threadingandwebhomework;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;

import static multithreadandstreamandweb.websitedownloader.readFile;

public class ArrayOfImages extends Application{
    private static final int WIDTH_WINDOW   = 900;
    private static final int HEIGHT_WINDOW  = 700;
    ExecutorService service;
    ArrayList<String> links = new ArrayList<>();
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(WIDTH_WINDOW);
        primaryStage.setHeight(HEIGHT_WINDOW);
        Pane root = new Pane();
        links = readFile("Files/multithreadandstreamandweb/links_imgs.txt");
        drawUI(root);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void drawUI(Pane root){

        Button resetButton = new Button("Reset");
        resetButton.setTranslateX(15);
        resetButton.setTranslateY(15);
        resetButton.setOnAction((event) -> {
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++) {
                    Random random = new Random();
                    int imgNumber = random.nextInt(50 - 1 + 1) + 1;
                    ImageView imageView = new ImageView(new Image(links.get(imgNumber)));
                    imageView.setTranslateX(100 * (i + 1));
                    imageView.setTranslateY(100 * (j + 1));
                    imageView.setFitHeight(100);
                    imageView.setFitWidth(100);
                    root.getChildren().addAll(imageView);
                }
            }
        });
        root.getChildren().addAll(resetButton);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
