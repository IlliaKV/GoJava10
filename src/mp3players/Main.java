package mp3players;

public class Main {
    public static void main(String[] args) {
        Mp3Player1 mp3Player1 = new Mp3Player1("One More", 500);
        mp3Player1.playSong();

        Mp3Player2 mp3Player2 = new Mp3Player2("Song L", 250);
        mp3Player2.playSong("Find Me");

        Mp3Player3 mp3Player3 = new Mp3Player3("Together", 1000);
        mp3Player3.playAllSongs();

        Mp3Player4 mp3Player4 = new Mp3Player4("Company", 800);
        mp3Player4.playLasSong();

        Mp3Player5 mp3Player5 = new Mp3Player5("Beginning", 1200);
        mp3Player5.addNewSong("Clock");
        mp3Player5.playAllSongs();

        Mp3Player6 mp3Player6 = new Mp3Player6("Beginning", 1200);
        mp3Player6.addNewSong("Clock");
        mp3Player6.addNewSong("Shuffle");
        mp3Player6.playAllSongs();
        mp3Player6.shuffle();
        mp3Player6.playAllSongs();
    }
}
