package mycompany.employeers;

public class FixedEmployee extends Employee {

    public final double  fixedMonthlyPayment;

    public FixedEmployee(String name, String surname, double fixedMonthlyPayment){
        super(name, surname);
        this.fixedMonthlyPayment = fixedMonthlyPayment;
    }

    @Override
    public double getMonthSalary(){
        return fixedMonthlyPayment;
    }

    @Override
    public String toString() {
        return "FixedEmployee{" +
                "fixedMonthlyPayment=" + fixedMonthlyPayment +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", MonthSalary=" + getMonthSalary() +
                "}\n";
    }
}
