import java.util.NoSuchElementException;

public class UnorderedLinkedListInt extends LinkedListIntClass {

    @Override
    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.info);
            if (current.next != null) {
                System.out.print(" ");
            }
            current = current.next;
        }
        System.out.println();
    }

    public int findSum() {
        int sum = 0;
        Node current = head;
        while (current != null) {
            sum += current.info;
            current = current.next;
        }
        return sum;
    }

    public int findMin() {
        if (isEmptyList()) {
            throw new NoSuchElementException("List is empty");
        }
        int min = head.info;
        Node current = head.next;
        while (current != null) {
            if (current.info < min) {
                min = current.info;
            }
            current = current.next;
        }
        return min;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            result.append(current.info);
            if (current.next != null) {
                result.append(", ");
            }
            current = current.next;
        }
        result.append("]");
        return result.toString();
    }
}