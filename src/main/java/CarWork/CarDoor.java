package CarWork;

public class CarDoor {
    private boolean doorStatus;
    private boolean windowStatus;

    public CarDoor(){
        this(false, false);
    }

    public CarDoor(boolean doorStatus, boolean windowStatus){
        this.doorStatus     = doorStatus;
        this.windowStatus   = windowStatus;
    }

    public void openDoor(){
        doorStatus     = true;
    }

    public void closeDoor(){
        doorStatus    = false;
    }

    public void openCloseDoor(){
        if (isDoorStatus()) doorStatus     = false;
        else doorStatus = true;
    }

    public void openWindow(){
        windowStatus   = true;
    }

    public void closeWindow(){
        windowStatus  = false;
    }

    public void openCloseWindow(){
        if (isWindowStatus()) windowStatus   = false;
        else windowStatus = true;
    }

    public void showCarDoorStatus(){
        System.out.println("Данные об объекте CarDoor:" +
                "\n- дверь " + isDoorStatus() +
                "\n- окно " + isWindowStatus());
    }

    public boolean isDoorStatus() {
        return doorStatus;
    }

    public boolean isWindowStatus() {
        return windowStatus;
    }
}
