import java.util.ArrayList;

public class MusicLibrary {
    private ArrayList<String> tracks = new ArrayList<>();
    private ArrayList <PlayList> playLists = new ArrayList<>();
    private String name;
    private String artist;



    public MusicLibrary(String name, String artist) {
        this.name = name;
        this.artist = artist;
        tracks = new ArrayList<>();
        playLists = new ArrayList<>();
    }


    public  void createPlaylist (String name) {
        PlayList existingPlaylist = findPlayList(name);
        if (existingPlaylist == null) {
            playLists.add(new PlayList(name));
        } else {
            System.out.println("Playlist already exists");
        }

    }

    public PlayList findPlayList ( String name ) {
        for ( PlayList playlist: this.playLists) {
            if(playlist.getName().equalsIgnoreCase(name)) {
                System.out.println("Found playlist: " + name);
                return playlist;
            }
        }
        return null;
    }

    public void addTrackToPlaylist ( String name, String track) {
        PlayList existingPlaylist = findPlayList(name);
        if (existingPlaylist == null) {
            System.out.println("Playlist doesn't  exist in library");
        } else {
            if (existingPlaylist.contains(track)) {
                System.out.println("Track  exists in playlist");
            } else {
                existingPlaylist.addTrack(track);
            }
        }
    }
        public void displayPlaylist( String name) {
            PlayList playlist = findPlayList(name);
            if (playlist != null) {
                playlist.displayTracks();
            }
        }
        public void displayAllPlaylists() {
            System.out.println("All playlists:");
            for (PlayList playlist : playLists) {
                System.out.println(" - " + playlist.getName());
            }
        }

    public void searchTracks (String phrase) {
        for (String track : this.tracks) {
            if(track.toLowerCase().contains(phrase.toLowerCase())) {
                System.out.println("-"+track);
            }
            else {
                System.out.println("Track does not exist in playlists");
            }
        }
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
    public void removeTrack(String track) {
        boolean isRemoved = this.tracks.remove(track);
        if (!isRemoved) {
            System.out.println("Track does not exist in playlist" + this.name);
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
    public int getTrackCount() {
        return tracks.size();
    }

    public int getPlaylistCount() {
        return playLists.size();
    }


    }




