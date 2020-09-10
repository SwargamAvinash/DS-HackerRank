import java.util.*;
import java.lang.StringBuilder;



// Weirdly  when i add all the prints into a string and printed at last then 
// there was no time out 
// does that mean every sysout is taking so much time...!!
class Solution {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int Q = in.nextInt();
		in.nextLine();
		Stack<String> st = new Stack<>();
		StringBuilder sb = new StringBuilder();
		StringBuilder prints = new StringBuilder();

		while (Q > 0) {
			int op = in.nextInt();
			switch (op) {
				case 1:
					String s = in.nextLine();
					st.push(sb.toString());
					sb.append(s.trim());
					break;
				case 2:
					int k = in.nextInt();
					int n = sb.toString().length();
					st.push(sb.toString());
					sb.delete(n - k, n);
					break;
				case 3:
					int c2 = in.nextInt();
					prints.append(sb.toString().charAt(c2-1) + "\n");
					break;
				case 4:
					sb = new StringBuilder(st.pop());
					break;
			}
			Q--;
		}
		System.out.println(prints.toString());
	}
}
