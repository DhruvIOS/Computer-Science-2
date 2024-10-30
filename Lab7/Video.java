public class Video extends MediaItem {
    private String director;
    private String genre;
    private int yearReleased;

    public Video(String id, String title, int numberOfCopies, int runtime, String director, String genre, int yearReleased) {
        super(id, title, numberOfCopies, runtime);
        this.director = director;
        this.genre = genre;
        this.yearReleased = yearReleased;
    }


    public String toString() {
        return super.toString() + "\nDIRECTOR: " + director + "\nGENRE: " + genre + "\nYEAR RELEASED: " + yearReleased;
    }
}

class CD extends MediaItem {
    private String artist;
    private String genre;

    public CD(String id, String title, int numberOfCopies, int runtime, String artist, String genre) {
        super(id, title, numberOfCopies, runtime);
        this.artist = artist;
        this.genre = genre;
    }

    public String toString() {
        return super.toString() + "\nARTIST: " + artist + "\nGENRE: " + genre;
    }
}