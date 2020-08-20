import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int m;
    static Stack<int[]> s = new Stack<>();
    static int[][] nearby = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static ArrayList<int[]> around = new ArrayList<>();
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visited = new boolean[n][m];
//        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
//                answer = Math.max(answer, tetroSum(i, j, 0));
                tetroSum(i, j, 0);
            }
        }
        System.out.println(answer);

    }

    public static int tetroSum(int i, int j, int sum) {
        int[] in = {i, j};
        s.push(in);
        sum += map[i][j];
        if (s.size() == 4) {
            answer = Math.max(sum, answer);
            return answer;
        }
        visited[i][j] = true;
//        int temp = sum;
        if (s.size() != 4) {
            for (int k = 0; k < s.size(); k++) {
                int newI = s.get(k)[0];
                int newJ = s.get(k)[1];
                for (int l = 0; l < 4; l++) {
                    newI += nearby[l][0];
                    newJ += nearby[l][1];
                    if (newI < 0 || newJ < 0 || newI >= n || newJ >= m) continue;
                    if (visited[newI][newJ] == false) {
//                        temp = Math.max(sum, tetroSum(newI, newJ, sum));
                        tetroSum(newI, newJ, sum);
                    }
                }
            }
        }
//        sum = temp;
        s.pop();
        visited[i][j] = false;
        return sum;
    }
}