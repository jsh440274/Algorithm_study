import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<int[]> chickenHouse = new ArrayList<>();
    static ArrayList<int[]> house = new ArrayList<>();
    static boolean[] visited;
    static int[] dept_arr;
    static int[][] map;
    static int n, m, answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                int[] temp = {i, j};
                if (map[i][j] == 1) {
                    house.add(temp);
                } else if (map[i][j] == 2) {
                    chickenHouse.add(temp);
                }
            }
        }

        visited = new boolean[chickenHouse.size()];
        dept_arr = new int[chickenHouse.size()];

        for (int i = 0; i < chickenHouse.size(); i++) {
            visited[i] = true;
            check(i, 0);
            visited[i] = false;
        }
        System.out.println(answer);
    }

    //dfs로 하나씩 치킨거리를 확인.
    public static void check(int start, int depth) {
        dept_arr[depth] = start + 1;
        for (int k = start; k < chickenHouse.size(); k++) {
            if (visited[k]) continue;
            visited[k] = true;
            check(k, depth + 1);
            visited[k] = false;
        }

        if (depth == m - 1) {
            int temp = 0;
            for (int i = 0; i < house.size(); i++) {
                int temp2 = 101;
                int[] h = house.get(i);
                for (int l = 0; l < m; l++) {
                    int dist = Math.abs(chickenHouse.get(dept_arr[l] - 1)[0] - h[0]) + Math.abs(chickenHouse.get(dept_arr[l] - 1)[1] - h[1]);
                    temp2 = Math.min(temp2, dist);
                }
                temp += temp2;
            }
            answer = Math.min(temp, answer);
        }
    }
}
