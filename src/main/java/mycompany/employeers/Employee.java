package mycompany.employeers;

public abstract class Employee{

    public String name;
    public String surname;

    public Employee(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public abstract double getMonthSalary();
}
