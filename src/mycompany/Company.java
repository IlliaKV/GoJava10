package mycompany;

import mycompany.employeers.Employee;
import mycompany.employeers.FixedEmployee;
import mycompany.employeers.Freelancer;
import mycompany.employeers.TimeEmployee;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Company {
    private static final String COMPANY_FOLDER = "Files/Companyes/";

    private Employee[] employeers;

    public void setEmployeers(Employee[] employeers) {
        this.employeers = employeers;
    }

    public double getSalary(){
        double salary = 0;

        for(int i = 0; i< employeers.length; i++){
            salary += employeers[i].getMonthSalary();
        }

        return salary;
    }

    @Override
    public String toString() {
        return "Company{" +
                "employeers=" + Arrays.toString(employeers) +
                '}';
    }

    public boolean writeToFile(String companyName){

        String text = "" + employeers.length + "\n";

        for(int i = 0; i< employeers.length; i++){
            text += employeers[i].getClass().getSimpleName() + "\n";
            text += employeers[i].name + "\n";
            text += employeers[i].surname + "\n";
            if(employeers[i] instanceof TimeEmployee){
                //TimeEmployee timeEmployee = (TimeEmployee)employeers[i]; или так для понимания
                text += ((TimeEmployee) employeers[i]).numberWorkingDaysInMonth + "\n";
                text += ((TimeEmployee) employeers[i]).numberWorkingHoursPerDay + "\n";
                text += ((TimeEmployee) employeers[i]).hourlyRate + "\n";
            }else if(employeers[i] instanceof FixedEmployee){
                text += ((FixedEmployee) employeers[i]).fixedMonthlyPayment + "\n";
            }else if(employeers[i] instanceof Freelancer){
                text += ((Freelancer) employeers[i]).numberOfHours + "\n";
                text += ((Freelancer) employeers[i]).hourlyRate + "\n";
            }
        }

        try {
            FileWriter fileWriter = new FileWriter(COMPANY_FOLDER + companyName);
            fileWriter.write(text);
            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static Company readFromFile(String companyName){
        Company company = new Company();

        try {
            File file   = new File(COMPANY_FOLDER + companyName);
            Scanner sc  = new Scanner(file);
            sc.useLocale(Locale.US);
            int employeersLength = sc.nextInt();
            sc.nextLine();

            company.employeers = new Employee[employeersLength];

            for(int i = 0; i< employeersLength; i++){
                String nameClass = sc.nextLine();
                if(TimeEmployee.class.getSimpleName().equals(nameClass)){
                    String name = sc.nextLine();
                    String surname = sc.nextLine();
                    double numberWorkingDaysInMonth = sc.nextDouble();
                    sc.nextLine();
                    int numberWorkingHoursPerDay = sc.nextInt();
                    sc.nextLine();
                    double hourlyRate = sc.nextDouble();
                    sc.nextLine();
                    company.employeers[i] = new TimeEmployee(name, surname, numberWorkingDaysInMonth, numberWorkingHoursPerDay, hourlyRate);
                }else if(FixedEmployee.class.getSimpleName().equals(nameClass)){
                    String name = sc.nextLine();
                    String surname = sc.nextLine();
                    double fixedMonthlyPayment = sc.nextDouble();
                    sc.nextLine();
                    company.employeers[i] = new FixedEmployee(name, surname, fixedMonthlyPayment);
                }else if(Freelancer.class.getSimpleName().equals(nameClass)){
                    String name = sc.nextLine();
                    String surname = sc.nextLine();
                    int numberOfHours = sc.nextInt();
                    sc.nextLine();
                    double hourlyRate = sc.nextDouble();
                    sc.nextLine();
                    company.employeers[i] = new Freelancer(name, surname, numberOfHours, hourlyRate);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return company;
    }

    void sortBySalary(boolean rise){
        Employee temp = null;
        for(int i=0; i < employeers.length; i++){
            for(int j=1; j < (employeers.length-i); j++){
                if(employeers[j-1].getMonthSalary() > employeers[j].getMonthSalary() && rise){
                    temp = employeers[j-1];
                    employeers[j-1] = employeers[j];
                    employeers[j] = temp;
                }else if(employeers[j-1].getMonthSalary() < employeers[j].getMonthSalary() && !rise){
                    temp = employeers[j-1];
                    employeers[j-1] = employeers[j];
                    employeers[j] = temp;
                }

            }
        }
    }
}
