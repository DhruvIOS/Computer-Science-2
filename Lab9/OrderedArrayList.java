public class OrderedArrayList extends ArrayListClass {
    
    public OrderedArrayList() {
        super();
    }

    public OrderedArrayList(int size) {
        super(size);
    }

    // Binary search for ordered list
    public int search(int item) {
        int first = 0;
        int last = length - 1;
        int middle;

        while (first <= last) {
            middle = (first + last) / 2;
            if (list[middle] == item)
                return middle;
            else if (list[middle] > item)
                last = middle - 1;
            else
                first = middle + 1;
        }
        return -1;
    }

    // Insert item in sorted order
    public void insert(int item) {
        if (length == maxSize) {
            System.err.println("Cannot insert in a full list.");
            return;
        }
        
        int loc = 0;
        while (loc < length && list[loc] < item) {
            loc++;
        }

        for (int i = length; i > loc; i--) {
            list[i] = list[i - 1];
        }
        list[loc] = item;
        length++;
    }

    // Override insertAt to maintain sorted order
    public void insertAt(int location, int item) {
        System.out.println("Cannot use insertAt on a sorted list. Inserting in sorted order instead.");
        insert(item);
    }

    // Override replaceAt to maintain sorted order
    public void replaceAt(int location, int item) {
        if (location < 0 || location >= length) {
            System.err.println("The location is out of range.");
            return;
        }
        removeAt(location);
        insert(item);
    }

    // Remove an item in the list
    public void remove(int item) {
        int loc = search(item);
        if (loc != -1) {
            removeAt(loc);
        } else {
            System.out.println("Item not found.");
        }
    }

    // Insert at the end by maintaining sorted order
    public void insertEnd(int item) {
        System.out.println("Cannot insert at the end in a sorted list. Inserting in sorted order instead.");
        insert(item);
    }
}
