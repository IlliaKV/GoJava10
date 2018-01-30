package myflowers.flowers;

public class Chamomile extends Flower {

    private double price;

    public Chamomile() {
        super("ромашка");
        price = 70;
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
