import java.util.Scanner;

public class Main {
    public static int[][] map;
    public static int[][] dp;

    public static int route(int i, int j) {
        int n = map.length;
        int m = map[0].length;

        if (i == n - 1 && j == m - 1) {
            return 1;
        }

        if (dp[i][j] == -1) {
            dp[i][j] = 0;
            if (i > 0 && map[i][j] > map[i - 1][j]) {
                dp[i][j] += route(i - 1, j);
            }
            if (i < n - 1 && map[i][j] > map[i + 1][j]) {
                dp[i][j] += route(i + 1, j);
            }
            if (j > 0 && map[i][j] > map[i][j - 1]) {
                dp[i][j] += route(i, j - 1);
            }
            if (j < m - 1 && map[i][j] > map[i][j + 1]) {
                dp[i][j] += route(i, j + 1);
            }
        }

        return dp[i][j];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        map = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        }

        System.out.println(route(0, 0));
    }
}
