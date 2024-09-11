//********************************************************
// COSC 237.xxx                                
// Dhruv Shah 
// DUE-DATE
// Lab1_2-Java program to draw hollow boxes of chars(5-21)
//********************************************************
import java.util.Scanner; 

public class Lab1_2 { 
   
  // declare constants
  public static final int MIN = 5;
  public static final int MAX = 21;

  public static void main(String[] args) { 

    // create Scanner object
    Scanner input = new Scanner(System.in);

	// declare vars
    int how_many, i, n, r, c;
    char cont, what;

    // display program haeding
    System.out.println("Drawing hollow boxes program.");
    System.out.println("=============================");

    // prompt to begin        
    System.out.print("\nDo you want to start(Y/N): ");
    cont = input.next().charAt(0); //priming read

    while (cont == 'Y' || cont == 'y') {

      // prompt for size of box to display
      n = getRangeInt2(input, "How many chars/last row? ", MIN, MAX); 

      // prompt for char to use
      System.out.print("What character? ");
      what = input.next().charAt(0);

      // draw box

      // first row
      for(r = 1; r <= n; r++) 
        // to complete
        System.out.print(what); 
        System.out.println();

      // n - 2 rows (middle rows)
      for(c = 1; c <= n - 2; c++) {
        // to complete   
        System.out.print(what); // first char
        for(r = 2; r <= n - 1; r++) 
          System.out.print(' '); // spaces in between
        System.out.println(what); // last char 
      }

      // last row
      for(r = 1; r <= n; r++) 
        // to complete
        System.out.print(what); 
        System.out.println();

	  // go to new line
      System.out.println();

      // propmt if wish to continue
      System.out.print("\nDo you want to continue(Y/N): ");
      cont = input.next().charAt(0); //next read
    }
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
  
  public static int getRangeInt2(Scanner input, String prompt, int min, int max) {
    
    int num = 0;

    int getnum = getInt(input, "How many chars/last row?: ");

    while(getnum < min || getnum > max){
      System.out.print("Number must be between " + min + " and " + max + ". ");
      getnum = getInt(input, "How many chars/last row?: ");
  }


    num = getnum;


    return num;
  }   
}