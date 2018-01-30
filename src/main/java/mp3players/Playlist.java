package mp3players;

public class Playlist extends Song {
    static final int DEFAULT_COUNT_OF_SONGS = 1;

    protected String[]    playlist;
    protected int         countOfSongs;

    public Playlist() {
        this("The Best Song");
    }

    public Playlist(String firstSongName) {
        super(firstSongName);
        countOfSongs    = DEFAULT_COUNT_OF_SONGS;
        playlist        = new String[countOfSongs];
        playlist[0]     = song1;
    }

    protected void playSong(){
        System.out.println("Playing: " + song1);
    }

    protected void playSong(String playThisNameSong){
        for(int i=0; i<countOfSongs; i++){
            if(playlist[i] == playThisNameSong){
                System.out.println("Playing: " + playlist[i]);
            }
            else System.out.println("error");
        }

    }

    protected void playAllSongs(){
        System.out.println("Play all songs:");
        for(int i=0; i<countOfSongs; i++){
            System.out.println("Playing: " + playlist[i]);
        }
    }

    protected void playLastSong(){
        System.out.println("Playing last song: " + playlist[countOfSongs-1]);
    }

    protected void addNewSong(String newSongName){
        String[] tmpPlaylist = new String[countOfSongs];

        for(int i=0; i<countOfSongs; i++){
            tmpPlaylist[i] = playlist[i];
        }

        countOfSongs++;
        playlist = new String[countOfSongs];

        for(int i=0; i<countOfSongs; i++){
            if(i+1 == countOfSongs){
                playlist[i] = newSongName;
            }
            else playlist[i] = tmpPlaylist[i];
        }
    }
}
