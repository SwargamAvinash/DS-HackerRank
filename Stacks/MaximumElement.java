import java.util.Scanner;
import java.util.Stack;
import java.util.PriorityQueue;
import java.util.Collections;



/*
	The Below Solution is log(n) ..
	Acutally you can create a objaect sturct that is going into the stack which always has 
	the max value along with it retained..**** (This will be o(1) solution will be much better..!!)
*/
class Solution{
	private static Scanner in = new Scanner(System.in);

	// I Need to keep Another Stack or Heap to keep Track of the Maximum Or else is there any 
	// better solution you can think of...?
	public static void main(String[] args){
		int n = in.nextInt();
		Stack<Integer> st = new Stack<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		while(n>0){
			int num = in.nextInt();
			switch(num){
				case 1:
					int value = in.nextInt();
					st.push(value);
					pq.add(value);
					break;
				case 2:
					if(st.empty()) break;
					pq.remove(st.pop());
					break;
				case 3:
					System.out.println(pq.peek());
					break;
			}
			n--;
		}
	}
}