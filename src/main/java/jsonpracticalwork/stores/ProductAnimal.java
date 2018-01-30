package jsonpracticalwork.stores;

public class ProductAnimal extends Product {
    public int age;

    public ProductAnimal(String name, double price, int age) {
        super(name, price);
        this.age = age;
    }

    @Override
    public String toString() {
        return "ProductAnimal{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
