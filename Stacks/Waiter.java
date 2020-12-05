import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;


// I actually didn't have to use any memorization or any thing also..
// Didn't have to use the 

public class Solution {

    static boolean isPrime(int n) 
    { 
        // Corner cases 
        if (n <= 1) 
            return false; 
        if (n <= 3) 
            return true; 
  
        // This is checked so that we can skip 
        // middle five numbers in below loop 
        if (n % 2 == 0 || n % 3 == 0) 
            return false; 
  
        for (int i = 5; i * i <= n; i = i + 6) 
            if (n % i == 0 || n % (i + 2) == 0) 
                return false; 
  
        return true; 
    } 

    static int getNthPrime(int N) {
        int count = 0;
        int prime = 2;
        for (int i=2;;i++) {
            if(isPrime(i)) {
                prime = i;
                count++;
            }

            if (count == N) break;
        }
        return prime;
    }

    /*
     * Complete the waiter function below.
     */
    static int[] waiter(int[] number, int q) {
        /*
         * Write your code here.
        */
        int ans_i = 0;
        Stack<Integer> A_0 = new Stack<Integer>();
        Stack<Integer> A_temp = new Stack<Integer>();
        Stack<Integer> B_0 = new Stack<Integer>();
        for (int i=0;i<number.length;i++) {
            A_0.push(number[i]);
        }

        for (int i=1 ; i <= q ; i++) {
            int itrPrime = getNthPrime(i);
            while(!A_0.empty()) {
                int top = A_0.pop();
                if (top % itrPrime == 0) {
                    B_0.push(top);
                } else {
                    A_temp.push(top);
                }
            }

            System.out.println("The q : " + i + "prime : " + itrPrime);
            System.out.println("The A stack" + A_temp);
            System.out.println("The b stack" + B_0);

            while(!B_0.empty()) {
                number[ans_i++] = B_0.pop(); 
            }

            i = i + 1;
            if (i > q) break;

            itrPrime = getNthPrime(i);
            while(!A_temp.empty()) {
                int top = A_temp.pop();
                if (top % itrPrime == 0) {
                    B_0.push(top);
                } else {
                    A_0.push(top);
                }
            }

            System.out.println("The q : " + i + "prime : " + itrPrime);
            System.out.println("The A stack" + A_0);
            System.out.println("The b stack" + B_0);

            while(!B_0.empty()) {
                number[ans_i++] = B_0.pop(); 
            }
        }

        while(!A_temp.empty()) {
            number[ans_i++] = A_temp.pop();
        }

        while(!A_0.empty()) {
            number[ans_i++] = A_0.pop();
        }

        return number;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nq = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nq[0].trim());

        int q = Integer.parseInt(nq[1].trim());

        int[] number = new int[n];

        String[] numberItems = scanner.nextLine().split(" ");

        for (int numberItr = 0; numberItr < n; numberItr++) {
            int numberItem = Integer.parseInt(numberItems[numberItr].trim());
            number[numberItr] = numberItem;
        }

        int[] result = waiter(number, q);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
