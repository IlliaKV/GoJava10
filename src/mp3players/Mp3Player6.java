package mp3players;

import java.util.Random;

public class Mp3Player6 extends Playlist {
    final double price;

    public Mp3Player6(String firstSongName, double price) {
        super(firstSongName);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void playSong(){
        super.playSong();
    }

    public void shuffle(){
        System.out.println("shuffling..");
        Random rnd = new Random();
        for (int i = 1; i < playlist.length; i++) {
            int j = rnd.nextInt(i);
            String temp = playlist[i];
            playlist[i] = playlist[j];
            playlist[j] = temp;
        }
    }

    public void playAllSongs(){
        super.playAllSongs();
    }
}
