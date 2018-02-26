package httpandwebapihomework;


import com.alibaba.fastjson.JSON;
import httpandwebapihomework.videos.Videos;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.util.concurrent.*;

public class Main extends Application {
    private static final int WIDTH_WINDOW   = 900;
    private static final int HEIGHT_WINDOW  = 600;
    private static String videoID;
    private ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(WIDTH_WINDOW);
        primaryStage.setHeight(HEIGHT_WINDOW);

        Pane root = new Pane();
        Pane rootText = new Pane();
        Pane videoPlay = new Pane();
        root.getChildren().addAll(rootText, videoPlay);

        drawUI(root, rootText, videoPlay);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }


    private void drawUI(Pane root, Pane rootText, Pane videoPlay){
        TextField textField = new TextField("kTHNpusq654");
        textField.setTranslateX(10);
        textField.setTranslateY(10);
        textField.setPrefWidth(WIDTH_WINDOW - 100);

        WebView webview = new WebView();
        webview.setTranslateX(10);
        webview.setTranslateY(110);
        webview.setPrefSize(640, 390);

        Button buttonView = new Button("View");
        buttonView.setTranslateX(WIDTH_WINDOW - 100 + textField.getTranslateX());
        buttonView.setTranslateY(50);
        buttonView.setVisible(false);
        buttonView.setOnAction(event -> {
            videoPlay.getChildren().clear();

            webview.getEngine().setJavaScriptEnabled(true);
            webview.getEngine().load("https://www.youtube.com/watch?v=" + videoID);

            videoPlay.getChildren().addAll(webview);

        });

        Button buttonSearch = new Button("Search");
        buttonSearch.setTranslateX(WIDTH_WINDOW - 100 + textField.getTranslateX());
        buttonSearch.setTranslateY(10);
        buttonSearch.setOnAction(event -> {
            videoID = textField.getText();
            try {
                rootText.getChildren().clear();
                webview.getEngine().setJavaScriptEnabled(false);

                Callable<String> callable = () -> YouTubeAPI.Search(textField.getText());
                Future<String> futureCallable = service.submit(callable);
                String response = futureCallable.get();
                Videos videos = JSON.parseObject(response, Videos.class);

                System.out.println(videos);

                Text channelTitleText = new Text("Channel title:\t" + videos.items[0].snippet.channelTitle);
                channelTitleText.setTranslateX(10);
                channelTitleText.setTranslateY(50);

                Text titleText = new Text("Title:\t\t\t" + videos.items[0].snippet.title);
                titleText.setTranslateX(10);
                titleText.setTranslateY(70);

                Text publishedAtText = new Text("Published at:\t" + videos.items[0].snippet.publishedAt);
                publishedAtText.setTranslateX(10);
                publishedAtText.setTranslateY(90);

                buttonView.setVisible(true);

                rootText.getChildren().addAll(channelTitleText, titleText, publishedAtText);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

        });

        root.getChildren().addAll(textField, buttonSearch, buttonView);
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception {
        service.shutdown();
    }
}
