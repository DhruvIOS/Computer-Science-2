
import java.util.ArrayList;

public class Lab9_2 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(-2);
        list.add(5);
        list.add(3);
        list.add(0);
        list.add(7);

        System.out.println("The original list is: ");
        print(list);
        System.out.println("The list after method call is: ");
        scaleByK(list);
        print(list);
    }

    public static void scaleByK(ArrayList<Integer> list) {
        ArrayList<Integer> scaledList = new ArrayList<>();
        for (Integer k : list) {
            if (k > 0) {
                for (int i = 0; i < k; i++) {
                    scaledList.add(k);
                }
            }
        }
        list.clear();
        list.addAll(scaledList);
    }

    public static void print(ArrayList<Integer> someList) {
        for (Integer i : someList)
            System.out.print(i + "  ");
        System.out.println();
    }
}
