package myflowers.flowers;

public class Rose extends Flower {

    private double price;

    public Rose() {
        super("роза");
        price = 100;
    }

    @Override
    public String toString() {
        return name + " ";
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
