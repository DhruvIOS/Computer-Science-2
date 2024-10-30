public class WrittenItem extends Item {
    private String author;

    public WrittenItem(String id, String title, int numberOfCopies, String author) {
        super(id, title, numberOfCopies);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }


    public String toString() {
        return super.toString() + "\nAUTHOR: " + author;
    }
}