import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListOperations {


    public static ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> mergedList = new ArrayList<>(list1);
        mergedList.addAll(list2);
        return mergedList;
    }


    public static void split(ArrayList<Integer> list, int key, ArrayList<Integer> firstHalf, ArrayList<Integer> secondHalf) {
        for (Integer item : list) {
            if (item <= key) {
                firstHalf.add(item);
            } else {
                secondHalf.add(item);
            }
        }
    }


    public static void bubbleSort(ArrayList<Integer> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {

                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }


    public static ArrayList<Integer> readFile(String filename) {
        ArrayList<Integer> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    list.add(scanner.nextInt());
                } else {
                    scanner.next(); 
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Please input the name of the file to be opened for first list: ");
        String file1 = scanner.nextLine();
        ArrayList<Integer> list1 = readFile(file1);

        
        if (list1.isEmpty()) {
            System.out.println("The first list is empty or not found. Exiting the program.");
            scanner.close();
            return; 
        }


        System.out.print("Please input the name of the file to be opened for second list: ");
        String file2 = scanner.nextLine();
        ArrayList<Integer> list2 = readFile(file2);

      
        System.out.println("The first list is: " + list1);
        System.out.println("The second list is: " + list2);


        ArrayList<Integer> mergedList = merge(list1, list2);
        System.out.println("The merged list is: " + mergedList);


        bubbleSort(mergedList);
        System.out.println("The merged list sorted is: " + mergedList);


        System.out.print("Enter key for split: ");
        int key = scanner.nextInt();
        ArrayList<Integer> firstHalf = new ArrayList<>();
        ArrayList<Integer> secondHalf = new ArrayList<>();
        split(mergedList, key, firstHalf, secondHalf);


        System.out.println("The first list after split is: " + firstHalf);
        System.out.println("The second list after split is: " + secondHalf);

        scanner.close();
    }
}