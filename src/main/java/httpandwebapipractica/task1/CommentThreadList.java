package httpandwebapipractica.task1;

import java.util.ArrayList;

public class CommentThreadList {
    public ArrayList<Item> items = new ArrayList<>();

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < items.size(); i++){
            str += items.get(i);
        }
        return str;
    }
}
