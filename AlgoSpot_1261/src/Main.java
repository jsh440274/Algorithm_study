import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arrline = br.readLine().split(" ");
        int n = Integer.parseInt(arrline[1]);
        int m = Integer.parseInt(arrline[0]);

        int[][] map = new int[n][m];
        int[][] dp = new int[n][m];
        map[0][0] = 0;

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            for (int i = 0; i < m; i++) {
                map[j][i] = line.charAt(i) - '0';
            }
        }

        if (n > 1) {
            for (int i = 1; i < n; i++) {
                dp[i][0] = dp[i - 1][0];
                if (map[i][0] == 1) {
                    dp[i][0]++;
                }
            }
        }
        if (m > 1) {
            for (int i = 1; i < m; i++) {
                dp[0][i] = dp[0][i - 1];
                if (map[0][i] == 1) {
                    dp[0][i]++;
                }
            }
        }

        if (n > 1 && m > 1) {
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    if (map[i][j] == 1) {
                        dp[i][j]++;
                    }
                }
            }
        }

        System.out.println(dp[n - 1][m - 1]);
    }
}
