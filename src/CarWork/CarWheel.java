package CarWork;

public class CarWheel {
    double wheelStatus;

    public CarWheel(){
        this(1.0);
    }
    public CarWheel(double wheelStatus){
        this.wheelStatus = wheelStatus;
    }

    public void newWheel(){
        this.wheelStatus = 1.0;
    }

    public void eraseWheel(double X){
        if (this.wheelStatus - (X/100) < 0) {
            this.wheelStatus = 0.0;
        }else this.wheelStatus = this.wheelStatus - (X/100);
    }

    public double getWheelStatus(){
        return this.wheelStatus*100;
    }

    public void showCarWheelStatus(){
        System.out.println("Данные об объекте CarWheel:" +
                            "\n- целостность шины равно " + this.wheelStatus * 100 + "%");
    }
}
