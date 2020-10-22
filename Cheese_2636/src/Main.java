import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int count = 1;
    public static int max = 0;
    public static int prev = 0;
    public static int n, m;
    public static int[][] map;
    public static boolean[][] erasing;
    public static int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public static Queue<int[]> q;
    public static boolean keepgoing = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        map = new int[n + 2][m + 2];
        erasing = new boolean[n + 2][m + 2];

        for (int i = 0; i < n; i++) {
            line = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                int input = Integer.parseInt(line[j]);
                if (input == 1) {
                    max++;
                }
                map[i + 1][j + 1] = input;
            }
        }
        while (keepgoing) {
            erasing = new boolean[n + 2][m + 2];
            q = new LinkedList<>();
            int[] temp = {0, 0};
            q.offer(temp);
            keepgoing = true;
            spread();
            erase();
        }
        System.out.println(count);
        System.out.println(prev);
    }

    public static void spread() {
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (map[i][j] == 0) {
//                    for (int k = 0; k < 4; k++) {
//                        int dx = d[k][0];
//                        int dy = d[k][1];
//                        if (i + dx >= 0 && i + dx < n && j + dy >= 0 && j + dy < m) {
//                            erasing[i + dx][j + dy] = true;
//                        }
//                    }
//                }
//            }
//        }
        while (!q.isEmpty()) {
            int[] polled = q.poll();
            int i = polled[0];
            int j = polled[1];
            erasing[i][j] = true;
            for (int k = 0; k < 4; k++) {
                int dx = d[k][0];
                int dy = d[k][1];
                if (i + dx >= 0 && i + dx < n && j + dy >= 0 && j + dy < m && erasing[i + dx][j + dy] == false) {
                    erasing[i + dx][j + dy] = true;
                    int[] offering = {i + dx, j + dy};
                    if (map[i + dx][j + dy] == 0) {
                        q.offer(offering);
                    }
                }
            }
        }
    }

    public static void erase() {
        prev = max;
        keepgoing = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (erasing[i][j]) {
                    if (map[i][j] == 1) {
                        keepgoing = true;
                        max--;
                        map[i][j] = 0;
                    }
                }
            }
        }
        count++;
    }

    public static boolean check() {
        boolean checked = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0) {
                    if (checked) {
                        return false;
                    } else {
                        checked = true;
                    }
                }
            }
        }
        return checked;
    }
}
