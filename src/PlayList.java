import java.util.ArrayList;

public class PlayList {
    private String name;
    private ArrayList<String> tracks;


    public PlayList(String name) {
        this.name = name;
        tracks =  new ArrayList<>();
    }
    public String getName () {
        return name;
    }

    public void displayTracks() {
        System.out.println("Tracks: " + this.tracks);
        if (this.tracks.isEmpty()) {
            System.out.println("No tracks in playlist" + this.name);
        }
        else {
            for (String track : this.tracks) {
                System.out.println("-"+track);
            }
        }
    }
    public void addTrack(String track) {
        if(!tracks.contains(track)) {
            this.tracks.add(track);
        }
        else {
            System.out.println("Track already exists in playlist" + this.name);
        }
    }

    public boolean contains(String track) {
        return tracks.contains(track);
    }

}
