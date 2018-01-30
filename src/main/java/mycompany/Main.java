package mycompany;

import mycompany.employeers.Employee;
import mycompany.employeers.FixedEmployee;
import mycompany.employeers.Freelancer;
import mycompany.employeers.TimeEmployee;

public class Main {
    public static void main2(String[] args) {
        Company javaBig = new Company();
        javaBig.setEmployeers(
                new Employee[]{
                        new TimeEmployee("Vasya", "Vasich", 20.8, 8, 40),
                        new TimeEmployee("Kolya", "Kolich", 20.8, 8, 36),
                        new FixedEmployee("Illia", "Illich", 6000),
                        new Freelancer("Pasha", "Pashov", 100, 40)
                }
        );

        System.out.println(javaBig);

        javaBig.writeToFile("JavaBig");
    }

    public static void main(String[] args) {
        Company javaBig = Company.readFromFile("JavaBig");

        System.out.println(javaBig.getSalary());

        javaBig.sortBySalary(false);

        System.out.println(javaBig);

    }
}
