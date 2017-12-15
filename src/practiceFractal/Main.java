package practiceFractal;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import practiceFractal.geometry.Fractal;
import practiceFractal.geometry.Line;
import practiceFractal.geometry.Point;
import practiceFractal.geometry.Triangle;

public class Main extends Application{
    private static final int WIDTH_WINDOW   = 900;
    private static final int HEIGHT_WINDOW  = 600;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(WIDTH_WINDOW);
        primaryStage.setHeight(HEIGHT_WINDOW);
        Pane root = new Pane();




//        DoubleProperty zoomProperty = new SimpleDoubleProperty(200);
//        ScrollPane scrollPane = new ScrollPane();
//
//        zoomProperty.addListener(new InvalidationListener() {
//
//            public void invalidated(Observable arg0) {
//                root.setPrefWidth(zoomProperty.get() * 4);
//                root.setPrefHeight(zoomProperty.get() * 3);
//            }
//        });
//
//        scrollPane.addEventFilter(ScrollEvent.ANY, new EventHandler<ScrollEvent>() {
//            @Override
//            public void handle(ScrollEvent event) {
//                if (event.getDeltaY() > 0) {
//                    zoomProperty.set(zoomProperty.get() * 1.1);
//                } else if (event.getDeltaY() < 0) {
//                    zoomProperty.set(zoomProperty.get() / 1.1);
//                }
//            }
//        });


//        root.getChildren().addAll(scrollPane);

        Fractal fractal = new Fractal(3, 0.5);
        fractal.draw(root);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
