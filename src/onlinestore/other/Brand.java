package onlinestore.other;

public class Brand {
    private String yearOfFoundation;
    private String name;
    private int    numberOfEmployees;
    private int    numberOfCountries;

    public Brand() {
        this("2018", "Lui Viton", 3, 30);
    }

    public Brand(String yearOfFoundation, String name, int numberOfEmployees, int numberOfCountries) {
        this.yearOfFoundation = yearOfFoundation;
        this.name = name;
        this.numberOfEmployees = numberOfEmployees;
        this.numberOfCountries = numberOfCountries;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "yearOfFoundation='" + yearOfFoundation + '\'' +
                ", name='" + name + '\'' +
                ", numberOfEmployees=" + numberOfEmployees +
                ", numberOfCountries=" + numberOfCountries +
                '}';
    }

    public void show(){
        toString();
    }
}
