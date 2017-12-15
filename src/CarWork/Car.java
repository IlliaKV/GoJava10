package CarWork;

import practicalwork5.Circle;

import java.util.Date;

public class Car {
    final static String dateProduction = "12.12.2017";             //дата производства (неизменна после создания объекта)
    String      engineType;
    double      maxSpeed;                   //максимальная скорость машины (если она новая)
    double      accelerationTime;           // время разгона до 100км/ч
    int         passengerCapacity;
    int         numberPassengersAtMoment;
    double      currentSpeed;
    CarWheel[]  carWheels;
    CarDoor[]   carDoors;

    int         countWheels;

    public Car(){
        this("Бензиновый", 180, 30, 5, 3, 90);
    }

    public Car(String engineType, double maxSpeed, double accelerationTime,
               int passengerCapacity, int numberPassengersAtMoment, double currentSpeed){
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
        numberPassengersAtMoment++;
    }

    public void removePassenger(){
        numberPassengersAtMoment--;
    }

    public void removeAllPassenger(){
        numberPassengersAtMoment   = 0;
    }

    public boolean getDoorByIndex(int index){
        return carDoors[index].isDoorStatus();
    }

    public double getWheelByIndex(int index){
        return carWheels[index].getWheelStatus();
    }

    public void removeAllWheels(){
        for(int i=0; i<countWheels; i++) {
            carWheels[i] = null;
        }
    }

    public void addWhells(int X){
        countWheels += X;
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
            if(carWheels[i].getWheelStatus() < maxEraseWheel){
                maxEraseWheel = carWheels[i].getWheelStatus();
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
