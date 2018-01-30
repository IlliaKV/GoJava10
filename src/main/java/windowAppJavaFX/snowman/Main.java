package windowAppJavaFX.snowman;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import windowAppJavaFX.snowman.Circle;
import windowAppJavaFX.snowman.CircleGenerator;

public class Main extends Application {
    private static final int WIDTH_WINDOW   = 900;
    private static final int HEIGHT_WINDOW  = 600;

    private static final int START_POINT_UI_ELEMENT_X   = 10;
    private static final int START_POINT_UI_ELEMENT_Y   = 20;
    private static final int SHIFT_UI_ELEMENT_Y         = 50;

    private CircleGenerator circleGenerator;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(WIDTH_WINDOW);
        primaryStage.setHeight(HEIGHT_WINDOW);

        //Pane root = new Pane();

        Pane root = new Pane();
        Pane circlesRoot = new Pane();

        root.getChildren().addAll(circlesRoot);
        drawUI(root, circlesRoot);



        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    private void drawUI(Pane root, Pane circlesRoot) {
        Text text = new Text("Input min radius:");
        text.setTranslateX(START_POINT_UI_ELEMENT_X);
        text.setTranslateY(START_POINT_UI_ELEMENT_Y);
        Font font = new Font(24);
        text.setFont(font);

        TextField textField = new TextField("20");
        textField.setTranslateX(START_POINT_UI_ELEMENT_X);
        textField.setTranslateY(text.getTranslateY() + SHIFT_UI_ELEMENT_Y);

        Text text2 = new Text("Input max radius:");
        text2.setTranslateX(START_POINT_UI_ELEMENT_X);
        text2.setTranslateY(textField.getTranslateY() + SHIFT_UI_ELEMENT_Y);
        text2.setFont(font);

        TextField textField2 = new TextField("100");
        textField2.setTranslateX(START_POINT_UI_ELEMENT_X);
        textField2.setTranslateY(text2.getTranslateY() + SHIFT_UI_ELEMENT_Y);

        Text text3 = new Text("Input count circles:");
        text3.setTranslateX(START_POINT_UI_ELEMENT_X);
        text3.setTranslateY(textField2.getTranslateY() + SHIFT_UI_ELEMENT_Y);
        text3.setFont(font);

        TextField textField3 = new TextField("8");
        textField3.setTranslateX(START_POINT_UI_ELEMENT_X);
        textField3.setTranslateY(text3.getTranslateY() + SHIFT_UI_ELEMENT_Y);



        Button button = new Button("Regenerate");
        button.setTranslateX(START_POINT_UI_ELEMENT_X);
        button.setTranslateY(textField3.getTranslateY() + SHIFT_UI_ELEMENT_Y);
        button.setOnAction((event) -> {
            circlesRoot.getChildren().clear();
            inicialClass(textField, textField2, textField3);
            circleGenerator.draw(circlesRoot);
        });

        Button button2 = new Button("Fill Red");
        button2.setTranslateX(START_POINT_UI_ELEMENT_X);
        button2.setTranslateY(button.getTranslateY() + SHIFT_UI_ELEMENT_Y);
        button2.setOnAction((event) -> {
            circlesRoot.getChildren().clear();
            circleGenerator.draw(circlesRoot, "FF0000");
        });

        Button button3 = new Button("Gradient");
        button3.setTranslateX(START_POINT_UI_ELEMENT_X);
        button3.setTranslateY(button2.getTranslateY() + SHIFT_UI_ELEMENT_Y);
        button3.setOnAction((event) -> {
            circlesRoot.getChildren().clear();
            circleGenerator.drawGradiently(circlesRoot);
        });

        root.getChildren().addAll(button, button2, button3, text, text2, text3, textField, textField2, textField3);
    }

    private void inicialClass(TextField textField, TextField textField2, TextField textField3){
        circleGenerator = new CircleGenerator(Double.parseDouble(textField.getText()), Double.parseDouble(textField2.getText()), Integer.parseInt(textField3.getText()));

    }
    public static void main(String[] args) {
        launch(args);
    }
}
