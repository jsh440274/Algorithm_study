import java.util.Stack;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] visited = new boolean[m][n];
        int[] da = {0, 0, 1, -1};
        int[] db = {1, -1, 0, 0};
        Stack<int[]> s = new Stack<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 1;
                int[] temp = {i, j};
                if (!visited[i][j] && picture[i][j] != 0) {
                    visited[i][j] = true;
                    numberOfArea++;
                    s.push(temp);
                    while (!s.isEmpty()) {
                        int[] popped = s.pop();
                        for (int x = 0; x < 4; x++) {
                            int a = popped[0] + da[x];
                            int b = popped[1] + db[x];
                            if (a >= 0 && a < m && b >= 0 && b < n && !visited[a][b] && picture[a][b] == picture[i][j]) {
                                int[] temptemp = {a, b};
                                visited[a][b] = true;
                                count++;
                                s.push(temptemp);
                            }
                        }
                    }
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

//    static int numberOfArea = 0;
//    static int maxSizeOfOneArea = 0;
//    static int m, n, tempmax;
//    static int[][] picture;
//    static boolean[][] visited;
//    static int[] da = {0, 0, 1, -1};
//    static int[] db = {1, -1, 0, 0};
//    static Stack<int[]> s = new Stack<>();
//
//    public int[] solution(int m, int n, int[][] picture) {
//        this.m = m;
//        this.n = n;
//        this.picture = picture;
//        this.visited = new boolean[m][n];
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (picture[i][j] != 0 && !visited[i][j]) {
//                    int[] temp = {i, j};
//                    s.clear();
//                    tempmax = 1;
//                    s.push(temp);
//                    numberOfArea++;
//                    maxVal(i, j);
////                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, maxVal(i, j));
//                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, tempmax);
//                }
//            }
//        }
//
//        int[] answer = new int[2];
//        answer[0] = numberOfArea;
//        answer[1] = maxSizeOfOneArea;
//        return answer;
//    }
//
//    public static void maxVal(int i, int j) {
//        visited[i][j] = true;
//        for (int x = 0; x < 4; x++) {
//            int a = i + da[x];
//            int b = j + db[x];
//            if (a >= 0 && a < m && b >= 0 && b < n && !visited[a][b]) {
//                if (picture[i][j] != picture[a][b]) {
//                    continue;
//                }
//                int[] temp = {a, b};
//                s.push(temp);
//                tempmax++;
//                maxVal(a, b);
//            }
//        }
//        s.pop();
//    }
}