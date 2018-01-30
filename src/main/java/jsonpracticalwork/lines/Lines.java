package jsonpracticalwork.lines;

import java.util.ArrayList;

public class Lines {
    public ArrayList<String> lines;

    public Lines(ArrayList<String> lines) {
        this.lines = lines;
    }

    @Override
    public String toString() {
        return "Lines{" +
                "lines=" + lines +
                '}';
    }
}
