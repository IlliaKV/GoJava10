package CarWork;

public class CarDoor {
    String doorStatus;
    String windowStatus;

    public CarDoor(){
        this("закрыто", "закрыто");
    }

    public CarDoor(String doorStatus, String windowStatus){
        this.doorStatus     = doorStatus;
        this.windowStatus   = windowStatus;
    }

    public void openDoor(){
        this.doorStatus     = "открыто";
    }

    public void closeDoor(){
        this.doorStatus    = "закрыто";
    }

    public void openCloseDoor(){
        if (this.doorStatus == "открыто") this.doorStatus     = "закрыто";
        else this.doorStatus = "открыто";
    }

    public void openWindow(){
        this.windowStatus   = "открыто";
    }

    public void closeWindow(){
        this.windowStatus  = "закрыто";
    }

    public void openCloseWindow(){
        if (this.windowStatus == "открыто") this.windowStatus   = "закрыто";
        else this.windowStatus = "открыто";
    }

    public void showCarDoorStatus(){
        System.out.println("Данные об объекте CarDoor:" +
                "\n- дверь " + doorStatus +
                "\n- окно " + windowStatus);
    }
}
