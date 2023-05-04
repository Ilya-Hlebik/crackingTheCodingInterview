package Ch_07_Object_Oriented_Design.Q7_03_Jukebox;

/*service*/
public class SongSelector {
    private Song song;

    public SongSelector(Song song) {
        this.song = song;
    }

    public Song getSong() {
        return song;
    }

    public void setSong(Song song) {
        this.song = song;
    }
}
