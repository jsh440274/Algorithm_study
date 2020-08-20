public class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n][m];

        for (int i = 0; i < puddles.length; i++) {
            dp[puddles[i][1] - 1][puddles[i][0] - 1] = -1;
        }
        for (int i = 0; i < n; i++) {
            if (dp[i][0] == -1) break;
            dp[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            if (dp[0][i] == -1) break;
            dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (dp[i][j] == -1) continue;
                if (dp[i - 1][j] == -1) {
                    dp[i][j] = dp[i][j - 1];
                } else if (dp[i][j - 1] == -1) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1000000007;
                }
            }
        }

        return dp[n - 1][m - 1] % 1000000007;
    }
}
/* 모범답안
일일히 비교하는 대신에 미리 puddles에서 -1로 되어있는 녀석들인지를 확인해서 -1로 되어있는 애들을 전부 0으로 만들어주어서 처리 -> if문이 확 줄어듦 ㄷㄷ
    public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<puddles.length;i++){
            dp[puddles[i][0]][puddles[i][1]]=-1;
        }
        dp[1][1]=1;
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(dp[i][j]==-1){
                    dp[i][j]=0;
                    continue;
                }
                if(i!=1)    dp[i][j]+=dp[i-1][j]%1000000007;
                if(j!=1)    dp[i][j]+=dp[i][j-1]%1000000007;
            }
        }
        return dp[m][n]%1000000007;
    }
*/



