
import java.util.*;

class QueueObject {
    int row;
    int col;
    int steps;

    public QueueObject(int row, int col, int steps) {
        this.row = row;
        this.col = col;
        this.steps = steps;
    }
}

class Solution {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        String[] grid = new String[n];
        in.nextLine();

        for (int i = 0; i<n ;i++) {
            grid[i] = in.nextLine();
        }

        int s_x = in.nextInt();
        int s_y = in.nextInt();
        int e_x = in.nextInt();
        int e_y = in.nextInt();

        int[][] visited = new int[n][n];
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                visited[i][j] = 0;
            }
        }
        visited[s_x][s_y] = 1;
        Queue<QueueObject> queue = new LinkedList<>();

        queue.add(new QueueObject(s_x, s_y, 0));
        while (!queue.isEmpty()) {
            QueueObject object = queue.remove();

            // System.out.println("row :- " + object.row + "col :- " + object.col);
            if (object.row == e_x && object.col == e_y) {
                System.out.println(object.steps);
                break;
            }

            for (int i = object.row - 1 ; i >= 0 ; i--) {
                if (grid[i].charAt(object.col) == 'X') break;

                if (visited[i][object.col] != 1) {
                    int count  = object.steps + 1;
                    visited[i][object.col] = 1;
                    queue.add(new QueueObject(i, object.col, count));
                }
            }

            for (int i = object.row + 1 ; i < n ; i++) {
                if (grid[i].charAt(object.col) == 'X') break;

                if (visited[i][object.col] != 1) {
                    int count  = object.steps + 1;
                    visited[i][object.col] = 1;
                    queue.add(new QueueObject(i, object.col, count));
                }
            }

            for (int i = object.col - 1 ; i >= 0 ; i--) {
                if (grid[object.row].charAt(i) == 'X') break;

                if (visited[object.row][i] != 1) {
                    int count  = object.steps + 1;
                    visited[object.row][i] = 1;
                    queue.add(new QueueObject(object.row, i, count));
                }

            }

            for (int i = object.col + 1 ; i < n ; i++) {
                if (grid[object.row].charAt(i) == 'X') break;

                if (visited[object.row][i] != 1) {
                    int count  = object.steps + 1;
                    visited[object.row][i] = 1;
                    queue.add(new QueueObject(object.row, i, count));
                }
            }

            // for (int i=0;i<n;i++) {
            //     for (int j=0;j<n;j++) {
            //         System.out.print(visited[i][j]);
            //     }
            //     System.out.println("");
            // }
        }
    }
}
