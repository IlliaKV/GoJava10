package mp3players;

public class Mp3Player4 extends Playlist {
    final double price;

    public Mp3Player4(String firstSongName, double price) {
        super(firstSongName);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void playLasSong(){
        super.playLastSong();
    }

    public void playAllSongs(){
        super.playAllSongs();
    }
}
