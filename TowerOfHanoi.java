/*
* This program gets number of disks as input,
* use recursion to solve the Tower of Hanoi and show the text of solution.
*
* @author  Donggeun Lim
* @version 1.0
* @since   2020-05-10
*/

import java.util.Scanner;

/**
* This is the towers of hanoi program.
*/
public final class TowerOfHanoi {

    /** Default value of start peg. */
    private static final int START_PEG = 1;
    /** Default value of end peg. */
    private static final int END_PEG = 3;
    /** Constant value of peg. */
    private static final int PEG_NUMBER = 6;

    /**
    * Prevent instantiation
    * Throw an exception IllegalStateException.
    * if this ever is called
    *
    * @throws IllegalStateException
    *
    */
    private TowerOfHanoi() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * This method uses recursion to solve the Tower of Hanoi.
    *
    * @param ndisks ndisks
    * @param startPeg startpeg
    * @param endPeg endpeg
    */
    public static void hanoi(final int ndisks, final int startPeg,
                             final int endPeg) {
        // This is the recursive Towers of Hanoi solution
        if (ndisks == 1) {
            System.out.println("Move disk 1 from peg " + startPeg
                               + " " + "to peg " + endPeg);
        }
        else {
            hanoi(ndisks - 1, startPeg, PEG_NUMBER - startPeg - endPeg);
            System.out.println("Move disk " + ndisks + " from peg "
                               + startPeg + " to peg " + endPeg);
            hanoi(ndisks - 1, PEG_NUMBER - startPeg - endPeg, endPeg);
        }
    }

    /**
    * This method gets number of disks,
    * passes to procedure called hanoi.
    *
    * @param args No args will be used.
    */
    public static void main(final String[] args) {
        final Scanner myObj = new Scanner(System.in);

        // Input
        System.out.println("Towers of Hanoi program\n");
        System.out.print("How many disks would you like in your tower (1->): ");

        try {
            final int numberOfDisks = Integer.parseInt(myObj.nextLine());
            hanoi(numberOfDisks, START_PEG, END_PEG);
        }
        catch (IOException | NumberFormatException exception) {
            System.err.println("Invalid input.");
        }

        System.out.println("\nDone.");
    }
}
