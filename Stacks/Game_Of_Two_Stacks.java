// This Solution I though the problem was a DP Problem but it was much simpler actually.
// static int twoStacks(int x, int[] a, int[] b) {
// 	/*
// 		* Write your code here.
// 		*/
// 		int maxScore = Integer.MIN_VALUE;
// 		int count[][] = new int[a.length][b.length]; //Memorization Array
// 		count[0][0] = 0;
// 		for (int i = 0 ; i < a.length ; i++) {
// 			for (int j = 0; j < b.length ; j++) {
// 				if (i > j) {
// 					count[i][j] = count[i-1][j] + a[i-1];
// 				} else if (i < j) {
// 					count[i][j] = count[i][j-1] + b[j-1];
// 				} else if(i>0 && j>0){
// 					count[i][j] = count[i-1][j] + count[i][j-1] - count[i-1][j-1];
// 				}

// 				if ((count[i][j] <= x)) {
// 					if(maxScore < (i+j)) maxScore = (i+j);
// 				}
// 			}
// 		}

// 		for(int i=0;i<a.length;i++) {
// 			for (int j=0;j<b.length;j++) {
// 				System.out.print(count[i][j] + "\t");
// 			}
// 			System.out.println("");
// 		}

// 		return maxScore;
// }

/* //TODO But this problem is just number of Top Elements removed from the First Stack and Second
*/

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the twoStacks function below.
     */
    static int twoStacks(int x, int[] a, int[] b) {
        /*
         * Write your code here.
         */
         int maxScore = 0;
         int sum = 0;
         int i = 0;
         int j = 0;

         while ((i<a.length) && (sum + a[i] <= x)) {
             sum += a[i];
             i++;
         }
         maxScore = i;

         while(j < b.length && i >= 0) {
             sum = sum + b[j];
             j++;
             while(sum > x && i > 0){
                 i--;
                 sum -= a[i];
             }

             if(sum <= x && maxScore < (i+j)) {
                 maxScore = (i+j);
             }
         }

         return maxScore;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(scanner.nextLine().trim());

        for (int gItr = 0; gItr < g; gItr++) {
            String[] nmx = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nmx[0].trim());

            int m = Integer.parseInt(nmx[1].trim());

            int x = Integer.parseInt(nmx[2].trim());

            int[] a = new int[n];

            String[] aItems = scanner.nextLine().split(" ");

            for (int aItr = 0; aItr < n; aItr++) {
                int aItem = Integer.parseInt(aItems[aItr].trim());
                a[aItr] = aItem;
            }

            int[] b = new int[m];

            String[] bItems = scanner.nextLine().split(" ");

            for (int bItr = 0; bItr < m; bItr++) {
                int bItem = Integer.parseInt(bItems[bItr].trim());
                b[bItr] = bItem;
            }

            int result = twoStacks(x, a, b);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
