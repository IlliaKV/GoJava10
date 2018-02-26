package httpandwebapihomework.videos;

public class Thumbnails {
    public Medium medium;
    public High high;
    public Standard standard;
    public Maxres maxres;

    @Override
    public String toString() {
        return "\n\nmedium = " + medium +
                "\n\nhigh = " + high +
                "\n\nstandard = " + standard +
                "\n\nmaxres = " + maxres;
    }
}
