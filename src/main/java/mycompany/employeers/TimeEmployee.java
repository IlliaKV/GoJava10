package mycompany.employeers;

public class TimeEmployee extends Employee {

    public final double  numberWorkingDaysInMonth;
    public final int     numberWorkingHoursPerDay;
    public final double  hourlyRate;

    public TimeEmployee(String name, String surname, double numberWorkingDaysInMonth, int numberWorkingHoursPerDay, double hourlyRate){
        super(name, surname);
        this.numberWorkingDaysInMonth = numberWorkingDaysInMonth;
        this.numberWorkingHoursPerDay = numberWorkingHoursPerDay;
        this.hourlyRate               = hourlyRate;
    }

    @Override
    public double getMonthSalary(){
        return numberWorkingDaysInMonth * numberWorkingHoursPerDay * hourlyRate;
    }

    @Override
    public String toString() {
        return "TimeEmployee{" +
                "numberWorkingDaysInMonth=" + numberWorkingDaysInMonth +
                ", numberWorkingHoursPerDay=" + numberWorkingHoursPerDay +
                ", hourlyRate=" + hourlyRate +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", MonthSalary=" + getMonthSalary() +
                "}\n";
    }

}
