package fruitstorejsonhomework;

public enum TypeFruit {
    Strawberry("Strawberry"),
    Apple("Apple"),
    Pear("Pear"),
    Banana("Banana"),
    Orange("Orange"),
    Mandarin("Mandarin"),
    Plum("Plum"),
    Raspberries("Raspberries"),
    Blackberry("Blackberry"),
    Cherry("Cherry")
    ;

    private final String text;

    private TypeFruit(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
