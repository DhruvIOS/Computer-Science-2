public class JournalPaper extends WrittenItem {
    private int yearPublished;

    public JournalPaper(String id, String title, int numberOfCopies, String author, int yearPublished) {
        super(id, title, numberOfCopies, author);
        this.yearPublished = yearPublished;
    }

    
    public String toString() {
        return super.toString() + "\nYEAR PUBLISHED: " + yearPublished;
    }
}