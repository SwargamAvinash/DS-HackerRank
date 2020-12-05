import java.util.*;

class Solution {

    private static Scanner in = new Scanner(System.in);

    public static void changeToAnotherStack(Stack<Integer> s1, Stack<Integer> s2) {
        while(!s1.empty())    {
            s2.push(s1.pop());
        }
    }

    public static void main(String[] args) {
        int q = in.nextInt();

        Stack<Integer> enqueue = new Stack<Integer>();
        Stack<Integer> dequeue = new Stack<Integer>();

        while(q > 0) {
            int step = in.nextInt();

            switch (step) {
                case 1:
                    int num = in.nextInt();
                    enqueue.push(num);
                    // System.out.println(step + "->enqueue :: " + enqueue);
                    // System.out.println(step + "->dequeue :: " + dequeue);
                    break;
                case 2:
                    if (dequeue.empty()) {
                        changeToAnotherStack(enqueue,dequeue);
                    }
                    // System.out.println(step + "->enqueue :: " + enqueue);
                    // System.out.println(step + "->dequeue :: " + dequeue);
                    dequeue.pop();
                    break;
                case 3:
                    // System.out.println(step + "->enqueue :: " + enqueue);
                    // System.out.println(step + "->dequeue :: " + dequeue);
                    if (dequeue.empty()) {
                        changeToAnotherStack(enqueue,dequeue);
                    }
                    System.out.println(dequeue.peek());
                    break;
            }
            q--;
        }
    }
}
