import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n;
    static int m;
//    static int[][] dp;
    static boolean[][] dp;
    static int[] hj;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        hj = new int[n + 1];
        dp = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            hj[i] = sc.nextInt();
//            Arrays.fill(dp[i], -1);
            dp[i][i] = true;
            if (hj[i] == hj[i - 1]) {
                dp[i - 1][i] = true;
            }
//            else {
//                dp[i - 1][i] = 0;
//            }
        }
//        Arrays.fill(dp[0], -1);
        m = sc.nextInt();
        isPalindrom();
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
//            int result = isPalindrom(s, e) ? 1 : 0;
            int result = dp[s][e] ? 1 : 0;
//            int result = dp[s][e];
            System.out.println(result);
        }
    }

//    public static boolean isPalindrom(int i, int j) {
//        if (j > n || i > n) return false;
//        if (dp[i][j] == 0) return false;
//        if (dp[i][j] == 1) return true;
//        if (hj[i] != hj[j]) {
//            dp[i][j] = 0;
//            return false;
//        } else {
//            if (isPalindrom(i + 1, j - 1)) {
//                dp[i][j] = 1;
//                return true;
//            } else {
//                dp[i][j] = 0;
//                return false;
//            }
//        }
//    }
//

    public static void isPalindrom() {
        for (int i = 2; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                if (hj[j] == hj[j + i] && dp[j + 1][j + i - 1]) {
                    dp[j][j + i] = dp[j + i][j] = true;
                }
//                else {
//                    dp[j][j + i] = dp[j + i][j] = 0;
//                }
            }
        }
    }
}
