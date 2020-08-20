import java.util.ArrayList;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        ArrayList[] dp = new ArrayList[triangle.length];

        dp[0] = new ArrayList<Integer>();
        dp[0].add(triangle[0]);

        dp[1] = new ArrayList<Integer>();
        dp[1].add(triangle[1][0] + triangle[0][0]);
        dp[1].add(triangle[1][1] + triangle[0][0]);

        for (int i = 2; i < triangle.length; i++) {
            dp[i] = new ArrayList<Integer>();
            dp[i].add(triangle[i][0] + (int) dp[i - 1].get(0));
            for (int j = 1; j < triangle[i].length - 1; j++) {
                int temp = Math.max(triangle[i][j] + (int) dp[i - 1].get(j), triangle[i][j] + (int) dp[i - 1].get(j - 1));
                dp[i].add(temp);
            }
            dp[i].add(triangle[i][triangle[i].length - 1] + (int) dp[i - 1].get(triangle[i].length - 2));
        }

        for (int i = 0; i < dp[triangle.length - 1].size(); i++) {
            answer = Math.max((int) dp[triangle.length - 1].get(i), answer);
        }

        return answer;
    }
}