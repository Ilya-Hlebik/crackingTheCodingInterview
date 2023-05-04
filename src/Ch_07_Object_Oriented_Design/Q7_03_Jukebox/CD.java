package Ch_07_Object_Oriented_Design.Q7_03_Jukebox;

import java.util.List;

public class CD {
    private final List<Song> songList;

    public CD(List<Song> songList) {
        this.songList = songList;
    }
}
