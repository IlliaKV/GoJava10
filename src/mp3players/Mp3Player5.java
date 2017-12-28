package mp3players;

public class Mp3Player5 extends Playlist {
    final double price;

    public Mp3Player5(String firstSongName, double price) {
        super(firstSongName);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void playSong(){
        super.playSong();
    }

    public void playAllSongs(){
        System.out.println("Play all songs from the end of the playlist to the beginning:");
        for(int i=countOfSongs-1; i>=0; i--){
            System.out.println("Playing: " + playlist[i]);
        }
    }
}
