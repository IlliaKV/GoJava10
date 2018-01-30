package practicalwork5;

public class CircleGenerator {
    Circle[] circles;

    int countOfCircles;

    String[][] drawCirclesMatr = new String[50][50];

    void generate(int countOfCircles){

        this.countOfCircles = countOfCircles;
        circles = new Circle[countOfCircles];

        for (int i=0; i<countOfCircles; i++){
            circles[i] = new Circle(Math.round(Math.random()*4 + 1), new Point(Math.round(Math.random()*20 + 10), Math.round(Math.random()*8 + 10)));
            //circles[i] = new Circle(Math.random()*4 + 1, new Point(Math.random()*20 + 10, Math.random()*8 + 10));
            System.out.println("circles["+i+"]:\t radius="+ circles[i].radius + ";\t x=" + circles[i].centre.x+", y="+circles[i].centre.y);
        }
    }

    public int calcCountOfCollisions(){

        int countOfCollisions = 0;
        for (int i=0; i<countOfCircles-1; i++){
            for (int j=i+1; j<countOfCircles; j++){
                System.out.println("circles["+i+"] и circles["+j+"] столкнулись: " + circles[i].collisionCheck(circles[j]));
                if (circles[i].collisionCheck(circles[j])) countOfCollisions++;
            }
        }
        return countOfCollisions;
    }

    public void drawCircles() {
            for (int i = 0; i < 50; i++) {

                for (int j = 0; j < 50; j++) {
                    int countCircles = 0;
                    for(int k = 0; k < countOfCircles; k++) {
                        Point point = new Point(i, j);
                        if (circles[k].radius >= circles[k].centre.calcLength(point)) {
                            countCircles++;
                            System.out.print(k);
                            break;
                        }
                    }
                    if (countCircles == 0) System.out.print(" ");
                }
                System.out.println();
            }

//        for (int i = 0; i < 50; i++) {
//            for (int j = 0; j < 50; j++) {
//                if (drawCirclesMatr[i][j] == null) drawCirclesMatr[i][j] = " ";
//                    System.out.print(drawCirclesMatr[i][j]);
//            }
//            System.out.println();
//        }
    }
}
