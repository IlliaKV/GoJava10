package jsonpracticalwork.stores;

import java.util.ArrayList;

public class Store<T> {
    public String name;
    public String address;
    public ArrayList<T> products;

    public Store(String name, String address, ArrayList<T> products) {
        this.name = name;
        this.address = address;
        this.products = products;
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", products=" + products +
                '}';
    }
}
