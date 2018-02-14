package multithreadandstreamandweb;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static multithreadandstreamandweb.websitedownloader.readFile;

public class websitedownloaderFXwindow extends Application{
    private static final int WIDTH_WINDOW   = 900;
    private static final int HEIGHT_WINDOW  = 600;
    ArrayList<String> links = new ArrayList<>();
    ExecutorService service;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setWidth(WIDTH_WINDOW);
        primaryStage.setHeight(HEIGHT_WINDOW);
        Pane root = new Pane();
        links = readFile("Files/multithreadandstreamandweb/links.txt");
        drawUI(root);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void drawUI(Pane root){
        ImageView imageView = new ImageView();
        imageView.setTranslateX(250);
        imageView.setTranslateY(50);
        imageView.setFitHeight(400);
        imageView.setFitWidth(400);

        root.getChildren().addAll(imageView);

        for(int i = 0; i < links.size(); i++){
            final int ii = i;
            ProgressBar progressBar = new ProgressBar();
            progressBar.setTranslateX(115);
            progressBar.setTranslateY(15 + 30*ii);

            Button showButton = new Button("Show");
            showButton.setTranslateX(15);
            showButton.setTranslateY(15 + 30*i);
            showButton.setOnAction((event) -> {

                int index = links.get(ii).lastIndexOf('/');
                String nameFile = links.get(ii).substring(index+1, links.get(ii).length());
                index = nameFile.lastIndexOf('.');
                String formatFile = nameFile.substring(index+1, nameFile.length());
                File f = new File("Files/cache/" + nameFile);
                if (f.exists()){
                    selectShowObject(formatFile, imageView, f);
                }else {
                    service = Executors.newFixedThreadPool(1);
                    service.submit(()-> {
                        URL url = null;
                        URLConnection connection = null;
                        try {
                            url = new URL(links.get(ii));
                            connection = url.openConnection();
                            connection.connect();
                            int fileLength = connection.getContentLength();
                            InputStream input = new BufferedInputStream(url.openStream(),8192);
                            OutputStream output = new FileOutputStream("Files/cache/" + nameFile);
                            byte data[] = new byte[1024];
                            long total = 0;
                            int count;
                            while ((count = input.read(data)) != -1) {
                                total += count;
                                long currentValue = (total * 100 / fileLength);
                                output.write(data, 0, count);
                                Platform.runLater(()->{
                                    progressBar.setProgress(currentValue/100.0);
                                    progressBar.setAccessibleText( String.valueOf(currentValue/100.0));
                                });
                            }
                            selectShowObject(formatFile, imageView, f);
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                    service.shutdown();
                }
                f.delete();
            });

            Button hideButton = new Button("Hide");
            hideButton.setTranslateX(65);
            hideButton.setTranslateY(15 + 30*i);
            hideButton.setOnAction((event) -> {

            });

            Button clearCacheButton = new Button("Clear Cache");
            clearCacheButton.setTranslateX(WIDTH_WINDOW - 115);
            clearCacheButton.setTranslateY(15);
            clearCacheButton.setOnAction((event) -> {
                imageView.setImage(null);
                purgeDirectory(new File("Files/cache/"));
            });

            root.getChildren().addAll(showButton, hideButton, progressBar, clearCacheButton);
        }
    }

    private static void selectShowObject(String formatFile, ImageView imageView, File f){
        if (formatFile.equals("jpg")){
            imageView.setImage(new Image(f.toURI().toString()));
        }
    }

    private static void purgeDirectory(File dir) {
        for (File file: dir.listFiles()) {
            if (file.isDirectory()) purgeDirectory(file);
            file.delete();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop(){
       //service.shutdown();
    }
}
