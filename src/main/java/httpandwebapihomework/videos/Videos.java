package httpandwebapihomework.videos;

public class Videos {
    public Item[] items;

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < items.length; i++){
            str += items[i];
        }
        return str;
    }
}
