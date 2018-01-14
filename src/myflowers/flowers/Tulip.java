package myflowers.flowers;

public class Tulip extends Flower {

    private double price;

    public Tulip() {
        super("тюльпан");
        price = 45;
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
