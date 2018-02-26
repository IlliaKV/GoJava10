package httpandwebapihomework.videos;

public class Standard {
    public String url;
    public int width;
    public int height;

    @Override
    public String toString() {
        return "\nurl = " + url +
                "\nwidth = " + width +
                "\nheight = " + height;
    }
}
