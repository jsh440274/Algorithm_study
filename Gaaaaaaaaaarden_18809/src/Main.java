import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static int[][] original_map;
    public static ArrayList<int[]> rg_spot;
    public static int[] visited_rg;
    public static int answer;
    public static int[][] around = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int g = sc.nextInt();
        int r = sc.nextInt();
        answer = 0;
        original_map = new int[n][m];
        rg_spot = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                original_map[i][j] = sc.nextInt();
                if (original_map[i][j] == 2) {
                    int[] temp = {i, j};
                    rg_spot.add(temp);
                }
            }
        }

        visited_rg = new int[rg_spot.size()];
        mapping(g, r);

        System.out.println(answer);
    }

    public static void mapping(int g, int r) {
        if (g == 0) {//초록 배양액 전부 자리 정함.
            if (r == 0) {//배양액 전부 자리 정함.
                int temp = spread_rg();
                answer = Math.max(answer, temp);
                return;
            } else {//초록 배양액 자리 다 정한 다음에 빨간 배양액 자리 정함.
                for (int i = 0; i < visited_rg.length; i++) {
                    if (visited_rg[i] == 0) {
                        visited_rg[i] = 4;
                        mapping(g, r - 1);
                        visited_rg[i] = 0;
                    }
                }
            }
        } else {//초록 배양액부터 자리 정함.
            for (int i = 0; i < visited_rg.length; i++) {
                if (visited_rg[i] == 0) {
                    visited_rg[i] = 3;
                    mapping(g - 1, r);
                    visited_rg[i] = 0;
                }
            }
        }
    }

    public static int spread_rg() {
        int ret = 0;
        int[][] map = copyMap();
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < visited_rg.length; i++) {//초록 먼저 큐에 넣기
            if (visited_rg[i] == 3) {
                int[] temp = rg_spot.get(i);
                q.add(temp);
                map[temp[0]][temp[1]] = 3;
            }
        }
        for (int i = 0; i < visited_rg.length; i++) {//그다음 빨강 넣기
            if (visited_rg[i] == 4) {
                int[] temp = rg_spot.get(i);
                q.add(temp);
                map[temp[0]][temp[1]] = 4;
            }
        }

        int count = q.size();
        while (!q.isEmpty()) {//초록 먼저 퍼뜨리고 그다음에 빨강 퍼뜨리기
            if (count == 0) {
                count = q.size();
            }
            int[] temp = q.poll();
            int color = map[temp[0]][temp[1]];
            for (int i = 0; i < around.length; i++) {
                int a = temp[0] + around[i][0];
                int b = temp[1] + around[i][1];
                if (a >= 0 && a < map.length && b >= 0 && b < map[0].length) {
                    map[temp[0]][temp[1]] = -1;
                    if (map[a][b] == 2 || map[a][b] == 1) {
                        map[a][b] = color;
                        int[] offering = {a, b};
                        q.offer(offering);
                    } else if (color == 4 && map[a][b] == 3 && original_map[a][b] != 3) {
                        ret++;
                        map[a][b] = 7;
                    }
                }
            }
        }

        return ret;
    }

    public static int[][] copyMap() {
        int[][] ret_map = new int[original_map.length][original_map[0].length];
        for (int i = 0; i < original_map.length; i++) {
            System.arraycopy(original_map[i], 0, ret_map[i], 0, original_map[0].length);
        }
        return ret_map;
    }
}
