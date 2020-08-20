import java.util.Scanner;

public class Main {
    public static int[][] map;
    public static long[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        map = new int[n][n];
        dp = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == n - 1 && j == n - 1 || map[i][j] == 0) {
                    continue;
                }else{
                    if (j + map[i][j] < n) {
                        dp[i][j + map[i][j]] += dp[i][j];
                    }
                    if (i + map[i][j] < n) {
                        dp[i + map[i][j]][j] += dp[i][j];
                    }
                }
            }
        }

        System.out.println(dp[n - 1][n - 1]);

    }
}
