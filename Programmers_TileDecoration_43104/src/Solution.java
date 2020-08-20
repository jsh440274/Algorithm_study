class Solution {
    public long solution(int N) {
        long answer = 0;
        long[] dp = new long[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        answer = dp[N-1] * 4 + dp[N - 2] * 2;

        return answer;
    }
}