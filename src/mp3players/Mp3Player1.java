package mp3players;

public class Mp3Player1 extends Playlist{
    final double price;

    public Mp3Player1(String firstSongName, double price) {
        super(firstSongName);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void playSong(){
        super.playSong();
    }
}
