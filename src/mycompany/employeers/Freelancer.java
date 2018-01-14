package mycompany.employeers;

public class Freelancer extends Employee {

    public final int numberOfHours;
    public final double hourlyRate;

    public Freelancer(String name, String surname, int numberOfHours, double hourlyRate){
        super(name, surname);
        this.numberOfHours  = numberOfHours;
        this.hourlyRate     = hourlyRate;
    }

    @Override
    public double getMonthSalary(){
        return numberOfHours * hourlyRate;
    }

    @Override
    public String toString() {
        return "Freelancer{" +
                "numberOfHours=" + numberOfHours +
                ", hourlyRate=" + hourlyRate +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", MonthSalary=" + getMonthSalary() +
                "}\n";
    }
}
