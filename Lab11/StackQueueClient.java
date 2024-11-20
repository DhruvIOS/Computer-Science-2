import java.util.Scanner;

// Main client class to test stack and queue functionalities
public class StackQueueClient {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedStackClass<Integer> stack = new LinkedStackClass<>();
        QueueClass<Integer> queue = new QueueClass<>();

        // Input for the stack
        System.out.print("Enter integers (999 to stop): ");
        int input;
        while ((input = scanner.nextInt()) != 999) {
            stack.push(input);
        }

        // Print original stack in direct order
        System.out.println("The original stack printed in direct order (bottom to top) is:");
        printStack(stack);

        // Print stack in reverse order
        System.out.println("The stack printed in reverse order (top to bottom) is:");
        printBackStack(stack);

        // Count items in stack
        int count = countItems(stack);
        System.out.println("The stack stores " + count + " items.");

        // Peek the top item
        Integer topItem = stack.peek();
        System.out.println("The top is: " + topItem);

        // Get the second item
        Integer secondItem = getSecond(stack);
        System.out.println("The second item (below top) is: " + secondItem);

        // Remove specified item from stack
        System.out.print("Enter value to be removed from stack: ");
        Integer valueToRemove = scanner.nextInt();
        removeItem(stack, valueToRemove);
        System.out.println("The stack after removing every occurrence of " + valueToRemove + " is:");
        printStack(stack);

        // Reverse the stack
        reverseStack(stack);
        System.out.println("Reversed the stack. The new stack printed in direct order is:");
        printStack(stack);

        // Input for the queue
        System.out.print("Enter integers for the queue (999 to stop): ");
        while ((input = scanner.nextInt()) != 999) {
            queue.enqueue(input);
        }

        // Print queue
        System.out.println("The queue is:");
        printQueue(queue);

        // Reverse the queue
        reverseQueue(queue);
        System.out.println("The reversed queue is:");
        printQueue(queue);

        scanner.close();
    }

    public static void printBackStack(LinkedStackClass<Integer> intStack) {
        LinkedStackClass<Integer> tempStack = new LinkedStackClass<>();
        while (!intStack.isEmptyStack()) {
            Integer value = intStack.peek();
            tempStack.push(value);
            intStack.pop();
        }
        while (!tempStack.isEmptyStack()) {
            Integer value = tempStack.peek();
            System.out.print(value + " ");
            intStack.push(value);
            tempStack.pop();
        }
        System.out.println();
    }

    public static void printStack(LinkedStackClass<Integer> intStack) {
        LinkedStackClass<Integer> tempStack = new LinkedStackClass<>();
        while (!intStack.isEmptyStack()) {
            Integer value = intStack.peek();
            System.out.print(value + " ");
            tempStack.push(value);
            intStack.pop();
        }
        System.out.println();

        while (!tempStack.isEmptyStack()) {
            intStack.push(tempStack.peek());
            tempStack.pop();
        }
    }

    public static Integer getSecond(LinkedStackClass<Integer> intStack) {
        if (intStack.isEmptyStack()) {
            System.err.println("Stack is empty!");
            return null;
        }
        Integer topItem = intStack.peek();
        intStack.pop();
        if (intStack.isEmptyStack()) {
            intStack.push(topItem);
            System.err.println("There is no second item, stack has only one item!");
            return null;
        }
        Integer secondItem = intStack.peek();
        intStack.push(topItem);
        return secondItem;
    }

    public static int countItems(LinkedStackClass<Integer> intStack) {
        int count = 0;
        LinkedStackClass<Integer> tempStack = new LinkedStackClass<>();
        while (!intStack.isEmptyStack()) {
            Integer value = intStack.peek();
            tempStack.push(value);
            intStack.pop();
            count++;
        }
        while (!tempStack.isEmptyStack()) {
            intStack.push(tempStack.peek());
            tempStack.pop();
        }
        return count;
    }


    public static void removeItem(LinkedStackClass<Integer> intStack, Integer n) {
        LinkedStackClass<Integer> tempStack = new LinkedStackClass<>();
        while (!intStack.isEmptyStack()) {
            Integer value = intStack.peek();
            if (!value.equals(n)) {
                tempStack.push(value);
            }
            intStack.pop();
        }
        while (!tempStack.isEmptyStack()) {
            intStack.push(tempStack.peek());
            tempStack.pop();
        }
    }

    public static void reverseStack(LinkedStackClass<Integer> s) {
        QueueClass<Integer> q = new QueueClass<>();
        while (!s.isEmptyStack()) {
            q.enqueue(s.peek());
            s.pop();
        }
        while (!q.isEmptyQueue()) {
            s.push(q.front());
            q.dequeue();
        }
    }

    public static void reverseQueue(QueueClass<Integer> q) {
        LinkedStackClass<Integer> s = new LinkedStackClass<>();
        while (!q.isEmptyQueue()) {
            s.push(q.front());
            q.dequeue();
        }
        while (!s.isEmptyStack()) {
            q.enqueue(s.peek());
            s.pop();
        }
    }

    public static void printQueue(QueueClass<Integer> q) {
        QueueClass<Integer> tempQueue = new QueueClass<>();
        while (!q.isEmptyQueue()) {
            Integer value = q.front();
            System.out.print(value + " ");
            tempQueue.enqueue(value);
            q.dequeue();
        }
        System.out.println();
        while (!tempQueue.isEmptyQueue()) {
            q.enqueue(tempQueue.front());
            tempQueue.dequeue();
        }
    }
}