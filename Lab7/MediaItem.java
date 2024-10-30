public class MediaItem extends Item {
    private int runtime;

    public MediaItem(String id, String title, int numberOfCopies, int runtime) {
        super(id, title, numberOfCopies);
        this.runtime = runtime;
    }

    public int getRuntime() {
        return runtime;
    }


    public String toString() {
        return super.toString() + "\nRUNTIME: " + runtime + " minutes";
    }
}