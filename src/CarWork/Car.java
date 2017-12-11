package CarWork;

import practicalwork5.Circle;

import java.util.Date;

public class Car {
    String      dateProduction;             //дата производства (неизменна после создания объекта)
    String      engineType;
    double      maxSpeed;                   //максимальная скорость машины (если она новая)
    double      accelerationTime;           // время разгона до 100км/ч
    int         passengerCapacity;
    int         numberPassengersAtMoment;
    double      currentSpeed;
    CarWheel[]  carWheels;
    CarDoor[]   carDoors;

    int         countWheels;

    public Car(String dateProduction){
        this(dateProduction, "Бензиновый", 180, 30, 5, 3, 90);
    }

    public Car(String dateProduction, String engineType, double maxSpeed, double accelerationTime,
               int passengerCapacity, int numberPassengersAtMoment, double currentSpeed){
        this.dateProduction             = dateProduction;
        this.engineType                 = engineType;
        this.maxSpeed                   = maxSpeed;
        this.accelerationTime           = accelerationTime;
        this.passengerCapacity          = passengerCapacity;
        this.numberPassengersAtMoment   = numberPassengersAtMoment;
        this.currentSpeed               = currentSpeed;

        this.countWheels                = 4;

        carWheels   = new CarWheel[countWheels];
        carDoors    = new CarDoor[countWheels];
        for(int i=0; i<countWheels; i++) {
            carDoors[i] = new CarDoor();
            carWheels[i] = new CarWheel();
        }
    }

    public void changeCurrentSpeed(double currentSpeed){
        this.currentSpeed   = currentSpeed;
    }

    public void addPassenger(){
        this.numberPassengersAtMoment++;
    }

    public void removePassenger(){
        this.numberPassengersAtMoment--;
    }

    public void removeAllPassenger(){
        this.numberPassengersAtMoment   = 0;
    }

    public String getDoorByIndex(int index){
        return carDoors[index].doorStatus;
    }

    public double getWheelByIndex(int index){
        return carWheels[index].wheelStatus;
    }

    public void removeAllWheels(){
        for(int i=0; i<countWheels; i++) {
            carWheels[i] = null;
        }
    }

    public void addWhells(int X){
        this.countWheels += X;
        carWheels   = new CarWheel[countWheels];
        carDoors    = new CarDoor[countWheels];

        for(int i=0; i<countWheels; i++) {
            carDoors[i] = new CarDoor();
            carWheels[i] = new CarWheel();
        }
    }

    public double curPossibleMaxSpeed(){
        double curPossibleMaxSpeed = 1;
        double maxEraseWheel       = 1.0;

        for(int i=0; i<countWheels; i++) {
            if(carWheels[i].wheelStatus < maxEraseWheel){
                maxEraseWheel = carWheels[i].wheelStatus;
            }
        }

        maxSpeed = numberPassengersAtMoment==0? 0: maxSpeed;

        curPossibleMaxSpeed = maxSpeed * maxEraseWheel;

        return curPossibleMaxSpeed;
    }

    public void showCarStatus(){
        System.out.println("\nДанные об объекте Car:\n" +
                "Дата производства " + dateProduction + "\n" +
                "Тип двигателя " + engineType + "\n" +
                "Максимальная скорость машины (если она новая) " + maxSpeed + "\n" +
                "Время разгона до 100км/ч " + accelerationTime + "\n" +
                "Пассажировместимость " + passengerCapacity + "\n" +
                "Кол-во пассажиров внутри в данный момент " + numberPassengersAtMoment + "\n" +
                "Текущая скорость " + currentSpeed + "\n" +
                "Текущая возможная максимальная скорость " + curPossibleMaxSpeed());
    }
}
