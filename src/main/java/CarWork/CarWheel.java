package CarWork;

public class CarWheel {
    private double wheelStatus;

    public CarWheel(){
        this(1.0);
    }
    public CarWheel(double wheelStatus){
        this.wheelStatus = wheelStatus;
    }

    public void newWheel(){
        wheelStatus = 1.0;
    }

    public void eraseWheel(double X){
        if (wheelStatus - (X/100) < 0) {
            wheelStatus = 0.0;
        }else wheelStatus = wheelStatus - (X/100);
    }

    public double getWheelStatus(){
        return wheelStatus*100;
    }

    public void showCarWheelStatus(){
        System.out.println("Данные об объекте CarWheel:" +
                            "\n- целостность шины равно " + wheelStatus * 100 + "%");
    }
}
