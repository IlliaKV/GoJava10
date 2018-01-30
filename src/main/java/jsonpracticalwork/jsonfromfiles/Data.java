package jsonpracticalwork.jsonfromfiles;

import java.util.HashMap;

public class Data<K, V> {
    public String title;
    public HashMap<K, V> data;

    public Data(String title, HashMap<K, V> data) {
        this.title = title;
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "title='" + title + '\'' +
                ", data=" + data +
                '}';
    }
}
