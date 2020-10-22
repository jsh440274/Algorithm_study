import java.util.ArrayList;

class Solution1 {
    public static final int div = 1000000007;
    public int[][] dp;
    public boolean[] visited;
    public int answer = 0;

    public int solution(int n, int[] money) {
        dp = new int[money.length][n];
        visited = new boolean[money.length];
        for (int i = 0; i < dp.length; i++) {
            int input = money[i];
            int j = 0;
            while (input <= n) {
                dp[i][j] = input;
                input += money[i];
                j++;
            }
        }

        matching(dp.length - 1, n);

        return answer % div;
    }

    public void matching(int index, int num) {
        if (num == 0) {
            answer++;
            return;
        } else if (num < 0) {
            return;
        } else {
            for (int i = index; i >= 0; i--) {
                if (!visited[i]) {
                    for (int j = dp[i].length - 1; j >= 0; j--) {
                        if (dp[i][j] != 0) {
                            visited[i] = true;
                            matching(i, num - dp[i][j]);
                            visited[i] = false;
                        }
                    }
                }
            }
        }
    }
}
