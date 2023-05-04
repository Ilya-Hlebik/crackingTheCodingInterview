package Ch_07_Object_Oriented_Design.Q7_03_Jukebox;

import java.util.List;

/*service*/
public class JukeBox {
    private final List<CD> cds;
    private User currentUser;
    private final CDPlayer cdPlayer;
    private final SongSelector songSelector;

    public JukeBox(CDPlayer cdPlayer, User user, List<CD> cds, SongSelector songSelector) {
        this.currentUser = user;
        this.cdPlayer = cdPlayer;
        this.cds = cds;
        this.songSelector = songSelector;
    }

    public Song getCurrentSong() {
        return songSelector.getSong();
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
    }

}
