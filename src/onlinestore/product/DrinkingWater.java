package onlinestore.product;

public class DrinkingWater extends Product {
    public DrinkingWater() {
        super(10, "Vodka", 20, "alcohol", 75.50);
    }

    public DrinkingWater(int id, String name, int count, String description, double price) {
        super(id, name, count, description, price);
    }
}
