package onlinestore.product;

public class Product {
    protected int       id = 0;
    protected String    name;
    protected int       count;
    protected String    description;
    protected double    price;

    public Product() {
        this(1, "default", 1, "default", 1);
    }

    public Product(int id, String name, int count, String description, double price) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.description = description;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    public void show(){
        System.out.println(toString());
    }
}
