import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        while (n != 0) {
            if (n % 2 != 0) {
                answer++;
                n--;
            }
            n /= 2;
        }
        return answer;
    }
}
/* dp 거꾸로 해보기.
public class Solution {
    public static int[] dp;

    public int solution(int n) {
        int answer = 0;
        dp = new int[n + 1];
        answer = dping(n);
        return answer;
    }

    public static int dping(int n) {
        if (n == 0) {
            return 0;
        } else {
            int temp = 0;
            if (dp[n - 1] != 0) {
                temp = dp[n - 1] + 1;
            } else {
                temp = dping(n - 1) + 1;
            }
            if (n % 2 == 0) {
                if (dp[n / 2] != 0) {
                    temp = Math.min(temp, dp[n / 2]);
                } else {
                    temp = Math.min(temp, dping(n / 2));
                }
            }
            dp[n] = temp;
            return temp;
        }
    }
}
*/

/* 쌩으로 dp만들어서 차례대로 비교하면서 앞으로 나가기
public class Solution {
    public int solution(int n) {
        int ans = 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int temp = dp[i - 1] + 1;
            if (i % 2 == 0) {
                temp = Math.min(temp, dp[i / 2]);
            }
            dp[i] = temp;
        }

        return dp[n];
    }
}
 */