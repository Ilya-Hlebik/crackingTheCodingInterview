package Ch_07_Object_Oriented_Design.Q7_03_Jukebox;

/*service*/
public class CDPlayer {
    private PlayList playList;
    private CD cd;

    public CDPlayer(PlayList playList) {
        this.playList = playList;
    }

    public CDPlayer(CD cd) {
        this.cd = cd;
    }

    public CDPlayer(PlayList playList, CD cd) {
        this.playList = playList;
        this.cd = cd;
    }

    public void playSong(Song song) {

    }

    public PlayList getPlayList() {
        return playList;
    }

    public void setPlayList(PlayList playList) {
        this.playList = playList;
    }

    public CD getCd() {
        return cd;
    }

    public void setCd(CD cd) {
        this.cd = cd;
    }
}
