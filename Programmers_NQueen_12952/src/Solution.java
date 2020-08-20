class Solution {
    public static int n;
    public static boolean[][] visited;
    public static int answer;

    public int solution(int n) {
        this.n = n;
        visited = new boolean[n][n];
        answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = true;
                insnare(i, j, n);
                visited[i][j] = false;
            }
        }

        return answer;
    }

    public static void insnare(int a, int b, int depth) {
        if (depth == 0) {
            answer++;
            return;
        } else {
            for (int i = a + 1; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        boolean flag = detecting(i, j);
                        if (!flag) {
                            visited[i][j] = true;
                            insnare(i, j, depth - 1);
                            visited[i][j] = false;
                        }
                    }
                }
            }
        }
    }

    public static boolean detecting(int a, int b) {
        int d = 0;
        boolean flag = false;
        for (int i = a; i < n; i++) {
            for (int j = b; j < n; j++) {
                if (i + d < n) {
                    flag = visited[i + d][j];
                    visited[i + d][j] = true;
                    if (j + d < n) {
                        flag = visited[i + d][j + d];
                        visited[i + d][j + d] = true;
                    }
                    if (j - d >= 0) {
                        flag = visited[i + d][j - d];
                        visited[i + d][j - d] = true;
                    }
                }
                if (i - d >= 0) {
                    flag = visited[i - d][j];
                    visited[i - d][j] = true;
                    if (j + d < n) {
                        flag = visited[i - d][j + d];
                        visited[i - d][j + d] = true;
                    }
                    if (j - d >= 0) {
                        flag = visited[i - d][j - d];
                        visited[i - d][j - d] = true;
                    }
                }
                if (j - d >= 0) {
                    flag = visited[i][j - d];
                    visited[i][j - d] = true;
                }
                if (j + d < n) {
                    flag = visited[i][j + d];
                    visited[i][j + d] = true;
                }
                if (flag) break;
            }
        }
        return flag;
    }
}