package jsonpracticalwork.stores;

public class ProductTech extends Product {
    public String description;
    public int guaranteeDuration;

    public ProductTech(String name, double price, String description, int guaranteeDuration) {
        super(name, price);
        this.description = description;
        this.guaranteeDuration = guaranteeDuration;
    }

    @Override
    public String toString() {
        return "ProductTech{" +
                "description='" + description + '\'' +
                ", guaranteeDuration=" + guaranteeDuration +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
