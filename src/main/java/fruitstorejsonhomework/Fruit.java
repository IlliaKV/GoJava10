package fruitstorejsonhomework;

public class Fruit {
    public TypeFruit    type;
    public int          shelfLife;
    public String       date;
    public double       price;

    public Fruit(TypeFruit type, int shelfLife, String date, double price) {
        this.type = type;
        this.shelfLife = shelfLife;
        this.date = date;
        this.price = price;
    }


    @Override
    public String toString() {
        return "{" +
                "type=" + type +
                ", shelfLife=" + shelfLife +
                ", data='" + date + '\'' +
                ", price=" + price +
                '}';
    }
}
