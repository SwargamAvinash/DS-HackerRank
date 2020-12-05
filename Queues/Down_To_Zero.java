import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    static int[] memorization = new int[1000001];

    public static int getDivisor(int N) {
        int divisor = 1;
        for (int i=2;i*i <= N ; i++) {
            if (N % i == 0) {
                divisor = i;
            } 
        }
        return Math.max(divisor, N/divisor);
    }

    public static boolean isPrime(int N) {
        for (int i=2; i*i <= N ; i++) {
            if (N % i == 0) return false;
        }
        return true;
    }

    public static int noOfMinMoves(int n) {
        if(n == 1) return 1;
        if (n == 2) return 2;
        if (isPrime(n)) return (1 + Math.min(memorization[n-1], n));

        for (int i=2;i*i <= N ; i++) {
            if (N % i == 0) {
                
            } 
        }

        return (1 + Math.min(memorization[n-1], memorization[getDivisor(n)]));
    }

    /*
     * Complete the downToZero function below.
     */
    static int downToZero(int n) {
        if (memorization[n] != 0) return memorization[n];
        // Recursive function 
        for (int i = 1 ; i <= n ; i++) {
            memorization[i] = noOfMinMoves(i);
            // System.out.println("for :- " + i + " minSteps :- " + memorization[i]);
        }
        return memorization[n];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(scanner.nextLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            int n = Integer.parseInt(scanner.nextLine().trim());

            int result = downToZero(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
