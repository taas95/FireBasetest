package tg.taastest.firebasetest;

public class Artist {
    String artistid;
    String name;
    String genre;

    public Artist(String artistid, String name, String genre) {
        this.artistid = artistid;
        this.name = name;
        this.genre = genre;
    }

    public String getArtistid() {
        return artistid;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }
}
