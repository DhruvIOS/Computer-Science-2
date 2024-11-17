public interface LinkedListIntADT {
    boolean isEmptyList();
    void initializeList();
    void print();
    int length();
    int front();
    int back();
    boolean search(int searchItem);
    void insertFirst(int newItem);
    void insertLast(int newItem);
    void deleteNode(int deleteItem);
}