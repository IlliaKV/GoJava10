package mp3players;

public class Mp3Player2 extends Playlist {
    final double price;

    public Mp3Player2(String firstSongName, double price) {
        super(firstSongName);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void playSong(String playThisNameSong){
        super.playSong(playThisNameSong);
    }
}
