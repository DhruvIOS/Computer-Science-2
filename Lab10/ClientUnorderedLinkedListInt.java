import java.util.Scanner;


public class ClientUnorderedLinkedListInt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        UnorderedLinkedListInt intList = new UnorderedLinkedListInt();
        int num;

        System.out.println("Enter integers (999 to stop)");
        num = input.nextInt();

        while (num != 999) {
            intList.insertLast(num);
            num = input.nextInt();
        }

        System.out.print("\nTesting .insertLast and .print. The original list is: ");
        intList.print();
        System.out.println("\nTesting .length. The length is: " + intList.length());

        if (!intList.isEmptyList()) {
            System.out.println("Testing .front. First element/list: " + intList.front());
            System.out.println("Testing .back. Last element/list: " + intList.back());
        }

        System.out.println("Testing .sum. The sum of data in all nodes is: " + intList.findSum());
        System.out.println("Testing .min. The smallest data in all nodes is: " + intList.findMin());

        System.out.print("Testing .search. Enter the number to search for/list: ");
        num = input.nextInt();
        if (intList.search(num)) {
            System.out.println(num + " found in this list.");
        } else {
            System.out.println(num + " is not in this list.");
        }

        System.out.print("Testing .remove. Enter the number to be deleted from list: ");
        num = input.nextInt();
        intList.deleteNode(num);
        System.out.print("Testing .toString. After deleting " + num + ", the list is: " + intList);
        System.out.println("\nThe length of the list after delete is: " + intList.length());

     
    }
}




// import java.util.Scanner;

// public class ClientUnorderedLinkedListInt {
//     public static void main(String[] args) {
//         Scanner input = new Scanner(System.in);
//         UnorderedLinkedListInt intList = new UnorderedLinkedListInt();
//         int num;

//         System.out.println("Enter integers (999 to stop)");
//         num = input.nextInt();

//         while (num != 999) {
//             intList.insertLast(num);
//             num = input.nextInt();
//         }

//         System.out.print("\nTesting .insertLast and .print. The original list is: ");
//         intList.print();
//         System.out.println("\nTesting .length. The length is: " + intList.length());

//         if (!intList.isEmptyList()) {
//             System.out.println("Testing .front. First element/list: " + intList.front());
//             System.out.println("Testing .back. Last element/list: " + intList.back());
//         }

//         System.out.println("Testing .sum. The sum of data in all nodes is: " + intList.findSum());
//         System.out.println("Testing .min. The smallest data in all nodes is: " + intList.findMin());

//         System.out.print("Testing .search. Enter the number to search for/list: ");
//         num = input.nextInt();
//         if (intList.search(num)) {
//             System.out.println(num + " found in this list.");
//         } else {
//             System.out.println(num + " is not in this list.");
//         }

//         System.out.print("Testing .remove. Enter the number to be deleted from list: ");
//         num = input.nextInt();
//         if (intList.deleteNode(num)) {
//             System.out.print("Testing .toString. After deleting " + num + ", the list is: " + intList);
//             System.out.println("\nThe length of the list after delete is: " + intList.length());
//         } else {
//             System.out.println(num + " is not in this list.");
//         }
//     }
// }
// ```