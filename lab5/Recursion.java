// Abdalla Abdelmagid

public class Recursion {

    public Recursion() {
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return (1);
        } else {
            return (n * factorial(n-1));
        }
    }

    public static void towers(int numDisks,
        String startPeg, String destPeg, String sparePeg) {
        if (numDisks == 1) {
            numDisks = numDisks;
            //System.out.println("Move disk from " + startPeg + " to " + destPeg);
        } else {
            towers(numDisks-1, startPeg, sparePeg, destPeg);
            //System.out.println("Move disk from " + startPeg + " to " + destPeg);
            towers(numDisks-1, sparePeg, destPeg, startPeg);
        }
    }

}
