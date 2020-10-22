import java.util.Arrays;

public class Solution2 {
    int[][] map;
    int[] value;
    boolean[] visited;
    int n;

    public int[] Solution(int n, int[][] edges) {
        this.n = n;
        map = new int[n][n];
        value = new int[n];
        visited = new boolean[n];
        int[] answer = new int[2];
        for (int i = 0; i < edges.length; i++) {
            map[edges[i][0]][edges[i][1]] = 1;
            map[edges[i][1]][edges[i][0]] = 1;
        }

        visited[0] = true;
        counting(0);

        int first = n / 3;
        int second = first * 2;

        int anscount = 0;
        for (int i = 0; i < n; i++) {
            if (value[i] == first || value[i] == second) {
                int max = value[i];
                int num = 0;
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1) {
                        if (max < value[j]) {
                            max = value[j];
                            num = j;
                        }
                    }
                }
                for (int j = 0; j < edges.length; j++) {
                    if ((edges[j][0] == i && edges[j][1] == num) || (edges[j][1] == i && edges[j][0] == num)) {
                        answer[anscount] = j;
                        anscount++;
                    }
                }
            }
        }
        Arrays.sort(answer);

        return answer;
    }

    public int counting(int num) {
        int tempVal = 1;
        for (int i = 0; i < n; i++) {
            if (map[num][i] != 0 && !visited[i]) {
                visited[i] = true;
                tempVal += value[i] + counting(i);
            }
        }
        value[num] = tempVal;
        return tempVal;
    }
}
