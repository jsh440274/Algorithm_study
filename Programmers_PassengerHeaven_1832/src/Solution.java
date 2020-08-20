//class Solution {
//    int MOD = 20170805;
//
//    public int solution(int m, int n, int[][] cityMap) {
//        int[][] road = new int[m][n];
//
//        for (int i = 0; i < m; i++) {
//            if (cityMap[i][0] == 1) break;
//            else if (cityMap[i][0] == 2) {
//                road[i][0] = 0;
//            } else {
//                road[i][0] = 1;
//            }
//        }
//        for (int i = 0; i < n; i++) {
//            if (cityMap[0][i] == 1) break;
//            else if (cityMap[0][i] == 2) {
//                road[0][i] = 0;
//            } else {
//                road[0][i] = 1;
//            }
//        }
//
//        for (int i = 1; i < m; i++) {
//            int temp = 0;
//            for (int j = 1; j < n; j++) {
//                if (cityMap[i][j] == 1) {
//                    road[i][j] = 0;
//                } else if (cityMap[i][j] == 2) {
//                    if (temp == 0) {
//                        temp = road[i][j - 1];
//                    }
//                    road[i][j] = road[i - 1][j];
//                } else {
//                    if (cityMap[i][j - 1] == 2) {
//                        road[i][j] = (temp + road[i - 1][j]) % MOD;
//                        temp = 0;
//                    } else {
//                        road[i][j] = (road[i][j - 1] + road[i - 1][j]) % MOD;
//                    }
//                }
////                road[i][j] %= 20170805;
//            }
//        }
//        return road[m - 1][n - 1];
//    }
//}

class Solution {
    int MOD = 20170805;

    public int solution(int m, int n, int[][] cityMap) {
        int[][] rightmap = new int[m + 1][n + 1];
        int[][] downmap = new int[m + 1][n + 1];
        rightmap[1][1] = 1;
        downmap[1][1] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (cityMap[i - 1][j - 1] == 1) {
                    rightmap[i - 1][j] = 0;
                    downmap[i][j - 1] = 0;
                } else if (cityMap[i - 1][j - 1] == 2) {
                    rightmap[i][j] = rightmap[i - 1][j];
                    downmap[i][j] = downmap[i][j - 1];
                } else {
                    rightmap[i][j] += (downmap[i][j - 1] + rightmap[i - 1][j]) % MOD;
                    downmap[i][j] += (downmap[i][j - 1] + rightmap[i - 1][j]) % MOD;
                }
            }
        }

        return rightmap[m][n] % MOD;
    }
}