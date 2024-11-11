public class UnorderedArrayList extends ArrayListClass {

    public UnorderedArrayList() {
        super();
    }

    public UnorderedArrayList(int size) {
        super(size);
    }

    // Linear search for unordered list
    public int search(int searchItem) {
        for (int i = 0; i < length; i++) {
            if (list[i] == searchItem) {
                return i;
            }
        }
        return -1;
    }

    public void insertAt(int location, int insertItem) {
        if (location < 0 || location > length || length == maxSize) {
            System.err.println("Cannot insert, position out of range or list is full.");
        } else {
            for (int i = length; i > location; i--) {
                list[i] = list[i - 1];
            }
            list[location] = insertItem;
            length++;
        }
    }

    public void replaceAt(int location, int repItem) {
        if (location < 0 || location >= length) {
            System.err.println("Cannot replace, position out of range.");
        } else {
            list[location] = repItem;
        }
    }

    public void remove(int removeItem) {
        int index = search(removeItem);
        if (index != -1) {
            removeAt(index);
        } else {
            System.out.println("Item not found in the list.");
        }
    }

    // Insert at the end of the list for unordered list
    public void insertEnd(int insertItem) {
        if (length >= maxSize) {
            System.err.println("Cannot insert, list is full.");
        } else {
            list[length] = insertItem;
            length++;
        }
    }
}
