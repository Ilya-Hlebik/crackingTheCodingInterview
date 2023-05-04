package Ch_07_Object_Oriented_Design.Q7_03_Jukebox;

import java.util.Queue;

/*service*/
public class PlayList {
    private Song song;
    private final Queue<Song> songs;

    public PlayList(Song song, Queue<Song> songs) {
        this.song = song;
        this.songs = songs;
    }

    public Song getNextSongToPlay() {
        return songs.peek();
    }

    public void queueUpSong(Song s) {
        songs.add(s);
    }
}
