public class Item {
    private String id;
    private String title;
    private int numberOfCopies;

    public Item(String id, String title, int numberOfCopies) {
        this.id = id;
        this.title = title;
        this.numberOfCopies = numberOfCopies;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void checkOut() {
        if (numberOfCopies > 0) {
            numberOfCopies--;
        }
    }

    public void checkIn() {
        numberOfCopies++;
    }

    public void addItem(int count) {
        numberOfCopies += count;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\nTITLE: " + title + "\nNUMBER OF COPIES: " + numberOfCopies;
    }
}