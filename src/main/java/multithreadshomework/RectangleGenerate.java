package multithreadshomework;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class RectangleGenerate {
    public final static int MAX_VAL_OF_RANDOM_FOR_XY = 400;
    public final static int MIN_VAL_OF_RANDOM_FOR_XY = 1;
    public final static int MAX_VAL_OF_RANDOM_FOR_WIDTH_HEIGHT = 100;
    public final static int MIN_VAL_OF_RANDOM_FOR_WIDTH_HEIGHT = 30;
    private int numberOfRectangles;
    public Rectangle[] rectangles;
    public Thread[] threads;
    public AnimationTimer gameLoop;
    public int[] switches;

    public RectangleGenerate(int numberOfRectangles) {
        this.numberOfRectangles = numberOfRectangles;
        rectangles              = new Rectangle[numberOfRectangles];
        threads                 = new Thread[numberOfRectangles];
        switches                 = new int[numberOfRectangles];
    }

    private void generating() {
        for (int i = 0; i < numberOfRectangles; i++){
            Random rn   = new Random();
            int x         = rn.nextInt(MAX_VAL_OF_RANDOM_FOR_XY - MIN_VAL_OF_RANDOM_FOR_XY + 1) + MIN_VAL_OF_RANDOM_FOR_XY;
            int y         = rn.nextInt(MAX_VAL_OF_RANDOM_FOR_XY - MIN_VAL_OF_RANDOM_FOR_XY + 1) + MIN_VAL_OF_RANDOM_FOR_XY;
            int width     = rn.nextInt(MAX_VAL_OF_RANDOM_FOR_WIDTH_HEIGHT - MIN_VAL_OF_RANDOM_FOR_WIDTH_HEIGHT + 1) + MIN_VAL_OF_RANDOM_FOR_WIDTH_HEIGHT;
            int height    = rn.nextInt(MAX_VAL_OF_RANDOM_FOR_WIDTH_HEIGHT - MIN_VAL_OF_RANDOM_FOR_WIDTH_HEIGHT + 1) + MIN_VAL_OF_RANDOM_FOR_WIDTH_HEIGHT;
            rectangles[i] = new Rectangle(x, y, width, height);
            int red       = rn.nextInt(255 - 1 + 1) + 1;
            int green     = rn.nextInt(255 - 1 + 1) + 1;
            int blue      = rn.nextInt(255 - 1 + 1) + 1;
            rectangles[i].setFill(Color.rgb(red, green, blue));

            switches[i]   = rn.nextInt(4 - 1 + 1) + 1;
        }
    }

    public void draw(Pane root) throws InterruptedException {
        generating();
        root.getChildren().addAll(rectangles);
    }

    public void clear(Pane root){
        root.getChildren().clear();
    }

    public void move(){
        gameLoop = new AnimationTimer() {

            @Override
            public void handle(long now) {
                for (int i = 0; i < numberOfRectangles; i++) {
                    setSwitcha(i);
                    final int ii      = i;
                    final int switcha = switches[i];
                    Runnable runnable = new Runnable() {
                        @Override
                        public void run() {
                            if (switcha == 1){
                                rectangles[ii].setX(rectangles[ii].getX() - 1);
                                rectangles[ii].setY(rectangles[ii].getY() - 1);
                            }else if (switcha == 2){
                                rectangles[ii].setX(rectangles[ii].getX() + 1);
                                rectangles[ii].setY(rectangles[ii].getY() - 1);
                            }else if (switcha == 3){
                                rectangles[ii].setX(rectangles[ii].getX() - 1);
                                rectangles[ii].setY(rectangles[ii].getY() + 1);
                            }else if (switcha == 4){
                                rectangles[ii].setX(rectangles[ii].getX() + 1);
                                rectangles[ii].setY(rectangles[ii].getY() + 1);
                            }
                        }
                    };
                    threads[i] = new Thread(runnable);
                    threads[i].start();
                    try {
                        threads[i].join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };

        gameLoop.start();
    }

    public void moveInOneThread(){
        gameLoop = new AnimationTimer() {

            @Override
            public void handle(long now) {
                for (int i = 0; i < numberOfRectangles; i++) {
                    setSwitcha(i);
                    final int switcha = switches[i];
                            if (switcha == 1){
                                rectangles[i].setX(rectangles[i].getX() - 1);
                                rectangles[i].setY(rectangles[i].getY() - 1);
                            }else if (switcha == 2){
                                rectangles[i].setX(rectangles[i].getX() + 1);
                                rectangles[i].setY(rectangles[i].getY() - 1);
                            }else if (switcha == 3){
                                rectangles[i].setX(rectangles[i].getX() - 1);
                                rectangles[i].setY(rectangles[i].getY() + 1);
                            }else if (switcha == 4){
                                rectangles[i].setX(rectangles[i].getX() + 1);
                                rectangles[i].setY(rectangles[i].getY() + 1);
                            }
                }

            }

        };

        gameLoop.start();
    }

    private void setSwitcha(int ii){
        if(rectangles[ii].getX()+rectangles[ii].getWidth() > 900-8 && switches[ii] == 4){
            switches[ii] = 3;
        }else if(rectangles[ii].getX()+rectangles[ii].getWidth() > 900-8 && switches[ii] == 2){
            switches[ii] = 1;
        }else if(rectangles[ii].getY()+rectangles[ii].getHeight() > 600-30 && switches[ii] == 4){
            switches[ii] = 2;
        }else if(rectangles[ii].getY()+rectangles[ii].getHeight() > 600-30 && switches[ii] == 3){
            switches[ii] = 1;
        }else if(rectangles[ii].getX() < 1 && switches[ii] == 3){
            switches[ii] = 4;
        }else if(rectangles[ii].getX() < 1 && switches[ii] == 1){
            switches[ii] = 2;
        }else if(rectangles[ii].getY() < 1 && switches[ii] == 2){
            switches[ii] = 4;
        }else if(rectangles[ii].getY() < 1 && switches[ii] == 1){
            switches[ii] = 3;
        }
    }
}
