class Solution {//dp로 풀어냄. 쥰내 같은 줄에 계속 큰수가 있고 나머지 줄에는 작은 수가 있으면 어떻게 풀어도 greedy로 풀수 없다는걸 깨달음.
    int solution(int[][] land) {
        int answer = 0;
        int[][] dp = new int[land.length][4];
        for (int i = 0; i < 4; i++) {
            dp[0][i] = land[0][i];
        }

        for (int i = 1; i < land.length; i++) {//행
            for (int j = 0; j < 4; j++) {//열

                for (int k = 0; k < 4; k++) {//이걸로 최댓값
                    if (j == k) continue;
                    if (dp[i][j] < dp[i - 1][k] + land[i][j]) {
                        dp[i][j] = dp[i - 1][k] + land[i][j];
                    }
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            answer = Math.max(answer, dp[land.length - 1][i]);
        }

        return answer;
    }
}

/*  greedy로 풀라다가 TC말고 싸그리 다 틀림
class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int prev = -1;
        for (int i = 0; i < land.length; i++) {
            int max = 0;
            int index = -1;
            for (int j = 0; j < 4; j++) {
                if (prev == j) continue;
                if (max < land[i][j]) {
                    max = land[i][j];
                    index = j;
                }
            }
            prev = index;
            answer += max;
        }
        return answer;
    }
}
 */