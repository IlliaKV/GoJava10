package jsonpracticalwork.stores;

public class ProductFruit extends Product {
    public double weight;

    public ProductFruit(String name, double price, double weight) {
        super(name, price);
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "ProductFruit{" +
                "weight=" + weight +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
