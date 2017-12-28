package onlinestore.product;

import onlinestore.other.Brand;

public class Clothes extends Product {
    private Brand brand;

    public Clothes() {
        this(1, "default", 1, "default", 1);
    }

    public Clothes(int id, String name, int count, String description, double price) {
        this(id, name, count, description, price, new Brand());
    }

    public Clothes(int id, String name, int count, String description, double price, Brand brand) {
        super(id, name, count, description, price);
        this.brand = brand;
    }

    @Override
    public String toString() {
        return super.toString() + brand;
    }

}
