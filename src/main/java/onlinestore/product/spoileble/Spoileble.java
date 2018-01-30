package onlinestore.product.spoileble;

import onlinestore.product.Product;
import onlinestore.other.ShelfLife;

public class Spoileble extends Product {
    private ShelfLife shelfLife;

    public Spoileble() {
        super();
    }

    public Spoileble(ShelfLife shelfLife) {
        this.shelfLife = shelfLife;
    }

    public Spoileble(int id, String name, int count, String description, double price, ShelfLife shelfLife) {
        super(id, name, count, description, price);
        this.shelfLife = shelfLife;
    }
}
