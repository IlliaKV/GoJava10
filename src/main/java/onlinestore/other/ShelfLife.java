package onlinestore.other;

public class ShelfLife {
    private String dateOfManufacture;
    private double storageTemperature;
    private int    shelfLife;

    public ShelfLife() {
        this("01.01.2018", 20, 10);
    }

    public ShelfLife(String dateOfManufacture, double storageTemperature, int shelfLife) {
        this.dateOfManufacture = dateOfManufacture;
        this.storageTemperature = storageTemperature;
        this.shelfLife = shelfLife;
    }

    @Override
    public String toString() {
        return "ShelfLife{" +
                "dateOfManufacture='" + dateOfManufacture + '\'' +
                ", storageTemperature=" + storageTemperature +
                ", shelfLife=" + shelfLife +
                '}';
    }

    public void show(){
        System.out.println(toString());
    }
}
