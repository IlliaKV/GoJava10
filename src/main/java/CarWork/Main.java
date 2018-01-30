package CarWork;

public class Main {
    public static void main(String[] args) {
        CarDoor carDoor = new CarDoor();
        carDoor.openDoor();
        carDoor.openWindow();
        carDoor.openCloseDoor();
        carDoor.showCarDoorStatus();

        CarWheel carWheel = new CarWheel();
        System.out.println("\nЦелостность шины равно " + carWheel.getWheelStatus() + "%");
        carWheel.eraseWheel(40.5);
        carWheel.showCarWheelStatus();

        Car car = new Car();
        car.addWhells(3);
        System.out.println("Получить дверь по индексу 3: " + car.getDoorByIndex(3));
        System.out.println("Получить колесо по индексу 5: " + car.getWheelByIndex(5));
        car.showCarStatus();
    }
}
