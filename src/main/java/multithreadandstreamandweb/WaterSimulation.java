package multithreadandstreamandweb;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class WaterSimulation extends Application{
    private static final int WIDTH_WINDOW   = 800;
    private static final int HEIGHT_WINDOW  = 800;
    private int heightArray;
    private int widthArray;
    int[][] arraySquares;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(WIDTH_WINDOW);
        primaryStage.setHeight(HEIGHT_WINDOW);
        Pane root = new Pane();
        drawUI(root);
        Scene scene = new Scene(root);
        scene.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                for(int i = 0; i < heightArray; i++) {
                    if (1 + (i*getSizeSquare()) < mouseEvent.getY() && 1 + (i*getSizeSquare()) + getSizeSquare() > mouseEvent.getY()) {
                        System.out.println("mouse click detected! " + mouseEvent.getSource() + " i = " + i);
//                        for (int j = 0; j < widthArray; j++) {
//
//                        }
                    }
                }
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void drawUI(Pane root){
        TextField textInputHeight = new TextField();
        textInputHeight.setTranslateX(15);
        textInputHeight.setTranslateY(15);

        TextField textInputWidth = new TextField();
        textInputWidth.setTranslateX(215);
        textInputWidth.setTranslateY(15);

        Button buttonStart = new Button("Start");
        buttonStart.setTranslateX(15);
        buttonStart.setTranslateY(45);
        buttonStart.setOnAction(event -> {

            heightArray = Integer.parseInt(textInputHeight.getText());
            widthArray = Integer.parseInt(textInputWidth.getText());

            arraySquares = new int[heightArray][widthArray];
            fillingArrayBlueNumbers();
            drawSquares(root);
        });

        root.getChildren().addAll(buttonStart, textInputHeight, textInputWidth);
    }

    private int getSizeSquare(){
        int val = heightArray > widthArray? heightArray : widthArray;
        return (WIDTH_WINDOW-100) / val;
    }

    private void fillingArrayBlueNumbers(){
        for(int i = 0; i < heightArray; i++){
            for(int j = 0; j < widthArray; j++){
                arraySquares[i][j] = 0;
            }
        }
    }

    private void drawSquares(Pane root){
        for(int i = 0; i < heightArray; i++){
            for(int j = 0; j < widthArray; j++){
                Rectangle square = new Rectangle(1 + (i*getSizeSquare()), 1 + (j*getSizeSquare()), getSizeSquare(), getSizeSquare());
                square.setFill(Color.rgb(0, arraySquares[i][j], 255, .99));
                square.setStroke(Color.BLACK);
                square.setStrokeWidth(1);
                root.getChildren().addAll(square);
            }
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
