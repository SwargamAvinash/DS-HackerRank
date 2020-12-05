import java.io.*;
import java.util.*;
import java.lang.*;

class CountPairs {
	private static Scanner in = new Scanner(System.in);

	private static int countPairs(int arr[]) {
		if (arr.length < 2) return 0;
		Arrays.sort(arr);
		
		int pairs_count = 0;
		int i = 0, j = 1;

		while (i < arr.length && j < arr.length) {
			if (arr[i] == arr[j]) {
				j++;
			} else {
				int count = j - i;
				pairs_count += (count * (count - 1) / 2);
				i = j;
			}
		}

		int count = j - i;
		pairs_count += (count * (count - 1) / 2);

		return pairs_count;
	}

	public static void main(String[] args) {
		int n = in.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) arr[i] = in.nextInt();

		System.out.println(countPairs(arr));
	}
}