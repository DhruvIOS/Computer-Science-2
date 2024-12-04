import java.util.NoSuchElementException;

public class DoubleLinkedList<T extends Comparable<T>> implements DoubleLinkedListADT<T> {
    protected class DoubleLinkedListNode<T> {
        T info;
        DoubleLinkedListNode<T> next;
        DoubleLinkedListNode<T> back;

        public DoubleLinkedListNode() {
            info = null;
            next = null;
            back = null;
        }

        public String toString() {
            return info.toString();
        }
    }

    protected int count;  
    protected DoubleLinkedListNode<T> first; 
    protected DoubleLinkedListNode<T> last; 

    public DoubleLinkedList() {
        initializeList();
    }

     
    public void initializeList() {
        first = null;
        last = null;
        count = 0;
    }

     
    public boolean isEmptyList() {
        return count == 0;
    }

     
    public T front() {
        if (isEmptyList()) {
            throw new NoSuchElementException("List is empty");
        }
        return first.info;
    }

     
    public T back() {
        if (isEmptyList()) {
            throw new NoSuchElementException("List is empty");
        }
        return last.info;
    }

     
    public int length() {
        return count;
    }

     
    public void print() {
        if (isEmptyList()) {
            System.out.println("List is empty.");
            return;
        }
        DoubleLinkedListNode<T> current = first;
        while (current != null) {
            System.out.print(current.info + " ");
            current = current.next;
        }
        System.out.println();
    }

     
    public void reversePrint() {
        if (isEmptyList()) {
            System.out.println("List is empty.");
            return;
        }
        DoubleLinkedListNode<T> current = last;
        while (current != null) {
            System.out.print(current.info + " ");
            current = current.back;
        }
        System.out.println();
    }

     
    public boolean search(T searchItem) {
        DoubleLinkedListNode<T> current = first;
        while (current != null) {
            if (current.info.equals(searchItem)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

     
    public void insertNode(T insertItem) {
        DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<>();
        newNode.info = insertItem;

        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            DoubleLinkedListNode<T> current = first;
            DoubleLinkedListNode<T> trailCurrent = null;

           
            while (current != null && current.info.compareTo(insertItem) < 0) {
                trailCurrent = current;
                current = current.next;
            }


            if (trailCurrent == null) {
                newNode.next = first;
                first.back = newNode;
                first = newNode;
            } else if (current == null) { 
                trailCurrent.next = newNode;
                newNode .back = trailCurrent;
                last = newNode;
            } else {
                trailCurrent.next = newNode;
                newNode.back = trailCurrent;
                newNode.next = current;
                current.back = newNode;
            }
        }
        count++;
    }

     
    public void deleteNode(T deleteItem) {
        if (first == null) {
            System.err.println("Cannot delete from an empty list.");
            return;
        }

        if (first.info.equals(deleteItem)) { 
            DoubleLinkedListNode<T> current = first;
            first = first.next;
            if (first != null) {
                first.back = null;
            } else {
                last = null; 
            }
            count--;
            return;
        }

        DoubleLinkedListNode<T> current = first;
        while (current != null && !current.info.equals(deleteItem)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Item not found in the list.");
            return;
        }

       
        if (current.next != null) {
            current.next.back = current.back;
        } else {
            last = current.back; 
        }
        if (current.back != null) {
            current.back.next = current.next;
        }
        count--;
    }

     
    public String toString() {
        StringBuilder result = new StringBuilder("[head] - ");
        DoubleLinkedListNode<T> current = first;
        while (current != null) {
            result.append(current.info).append(" - ");
            current = current.next;
        }
        result.append("[tail]");
        return result.toString();
    }

     
    public String recursiveToString() {
        return recursiveToStringHelper(first);
    }

    private String recursiveToStringHelper(DoubleLinkedListNode<T> node) {
        if (node == null) {
            return "";
        }
        return node.info + (node.next != null ? " - " + recursiveToStringHelper(node.next) : "");
    }

     
    public String backwardsString() {
        StringBuilder result = new StringBuilder("[tail] - ");
        DoubleLinkedListNode<T> current = last;
        while (current != null) {
            result.append(current.info).append(" - ");
            current = current.back;
        }
        result.append("[head]");
        return result.toString();
    }

     
    public String recursiveBackwardsString() {
        return recursiveBackwardsStringHelper(last);
    }

    private String recursiveBackwardsStringHelper(DoubleLinkedListNode<T> node) {
        if (node == null) {
            return "";
        }
        return node.info + (node.back != null ? " - " + recursiveBackwardsStringHelper(node.back) : "");
    }

     
    public boolean equals(Object o) {
        if (!(o instanceof DoubleLinkedList<?>)) {
            return false; 
        }
        DoubleLinkedList<?> otherList = (DoubleLinkedList<?>) o; 
        if (this.length() != otherList.length()) {
            return false; 
        }
    
        DoubleLinkedListNode<T> current1 = this.first; 
        DoubleLinkedListNode<Object> current2 = (DoubleLinkedListNode<Object>) otherList.first; 
    
        while (current1 != null) {
          
            if (!current1.info.equals(current2.info)) { 
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return true;
    }

     
    public void copy(DoubleLinkedList<T> otherList) {
        if (otherList.isEmptyList()) {
            initializeList();
            return;
        }

        this.initializeList();
        DoubleLinkedListNode<T> current = otherList.first;
        while (current != null) {
            this.insertNode(current.info);
            current = current.next;
        }
    }

     
    public void reversedCopy(DoubleLinkedList<T> otherList) {
        if (otherList.isEmptyList()) {
            initializeList();
            return;
        }

        this.initializeList();
        DoubleLinkedListNode<T> current = otherList.last;
        while (current != null) {
            this.insertNode(current.info);
            current = current.back;
        }
    }

   
}