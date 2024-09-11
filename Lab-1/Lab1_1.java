
//************************************************************
// COSC 237.xxx                               
// Dhruv Shah 
// DUE-DATE
// Lab1_2-Guessing game: 2-digit numbers + hint + input errors
// (give hints until correct guess is reached)
//************************************************************
import java.util.Scanner;
import java.util.Random;

public class Lab1_1 {
    public static void main(String[] args) {

        // create needed objects
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        // init
        int num_guesses = 1;

        // get random in (in range 1-99)
        int n = rand.nextInt(90) + 10;

        // for testing
        System.out.println("secret number = " + n);

        // init (set to 1 if failed to guess)
        int out = 0;

        // prompt for guess
        System.out.print("Try to guess my secret two-digit number, and I'll tell you how ");
        System.out.println("many digits from your guess appear in my number.");
        System.out.println("Be smart! You can try at most 10 times.");
        int guess = getIntInRange(input, "Your guess: ", 10, 99);

        // init number of guesse
        int num_Guesses = 1;

        // allow guessing until guessed or until more than 10 tries
        while (guess != n) {

            // determine how many digits match
            int num_Matches = matches(n, guess);

            // display number of matching digits
            System.out.println("Incorrect (hint: " + num_Matches + " digits match)");

            // System.out.println("You entered for testing " + guess);
            // get users next guess
            guess = getIntInRange(input, "Your guess: ", 10, 99);

            // incr number of guesses
            num_Guesses++;

            // check if more than ten guesses
            if (num_Guesses > 10) {
                System.out.println("You waste your time, no hope here!");
                out = 1;
                guess = n;
            }
        }
        if (out != 1)
            System.out.println("You guessed my number in " + num_Guesses + " tries.");
    }

    // Returns # of matching digits between two ints.
    public static int matches(int n, int guess) {
        int count = 0;
        // to complete
        int secertNumFirstDigit = n / 10;
        int secertNumSecondDigit = n % 10;

        int guesFirstDigit = guess / 10;
        int guessSecondDigit = guess % 10;

  
        if (guesFirstDigit == secertNumFirstDigit ) {
            count++;;
        }
        if (guessSecondDigit == secertNumSecondDigit) {
            count++;
        }
        if (guesFirstDigit == secertNumSecondDigit) {
            count++;
        }
        if (guessSecondDigit == secertNumFirstDigit) {
            count++;
        }

        if (count > 2) {
            count = 2;
        }

        return count;
    }

    public static int getIntInRange(Scanner input, String prompt, int min, int max) {
        // to complete

        int num = 0;

        int getnum = getInt(input, "Your guess: ");

        while(getnum < min || getnum > max){
            System.out.print("Number must be between " + min + " and " + max + ". ");
            getnum = getInt(input, "Your guess: ");
        }

        

        num = getnum;


        return num;
    }

    public static int getInt(Scanner input, String prompt) {
        // to complete
        int num = 0;
        boolean valid_input = false;

        while (!valid_input) {
            System.out.print(prompt);

            if (input.hasNextInt()) {
                num = input.nextInt();

                valid_input = true;
            } else {
                System.out.print("Invalid input. Try again: ");
                input.next();
            }
        }

        return num;
    }
}

/*
 * OUTPUT:
 * Try to guess my secret two-digit number, and I'll tell you how many digits
 * from your guess appear in my number.
 * Be smart! You can try at most 10 times.
 * Your guess: 33
 * Incorrect (hint: 0 digits match)
 * Your guess: gbhj
 * Not an integer! Try again: Your guess: 11
 * Incorrect (hint: 0 digits match)
 * Your guess: 9.6
 * Not an integer! Try again: Your guess: 34
 * Incorrect (hint: 0 digits match)
 * Your guess: 26
 * Incorrect (hint: 1 digits match)
 * Your guess: 68
 * Incorrect (hint: 0 digits match)
 * Your guess: 28
 * Incorrect (hint: 1 digits match)
 * Your guess: 12
 * Incorrect (hint: 1 digits match)
 * Your guess: f
 * Not an integer! Try again: Your guess: 27
 * Incorrect (hint: 1 digits match)
 * Your guess: 29
 * Incorrect (hint: 2 digits match)
 * Your guess: 92
 * You guessed my number in 10 tries.
 */