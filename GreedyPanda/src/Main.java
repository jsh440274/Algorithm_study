import java.util.Scanner;

public class Main {
    public static int[][] map;
    public static int[][] dp;

    public static int dead_count(int i, int j) {
        int n = map.length;
        if (dp[i][j] == -1) {
            int temp = 0;
            if (i > 0 && map[i][j] < map[i - 1][j]) {
                temp = Math.max(temp, dead_count(i - 1, j));
            }
            if (j > 0 && map[i][j] < map[i][j - 1]) {
                temp = Math.max(temp, dead_count(i, j - 1));
            }
            if (i < n - 1 && map[i][j] < map[i + 1][j]) {
                temp = Math.max(temp, dead_count(i + 1, j));
            }
            if (j < n - 1 && map[i][j] < map[i][j + 1]) {
                temp = Math.max(temp, dead_count(i, j + 1));
            }
            dp[i][j] = 1;
            dp[i][j] += temp;
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        map = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dead_count(i, j));
            }
        }

        System.out.println(max);
    }
}
