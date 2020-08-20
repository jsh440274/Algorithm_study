import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public static boolean[] visited;
    public static int[][] weightMap;
    public static HashMap<Integer, ArrayList<Integer>> map;
    public static int answer;
    public static int N, K;

    public int solution(int N, int[][] road, int K) {
        this.N = N;
        this.K = K;
        map = new HashMap<>();
        visited = new boolean[N + 1];
        visited[1] = true;
        weightMap = new int[N + 1][N + 1];
        answer = 1;

        if (N == 1) {
            return 1;
        }

        for (int i = 0; i < road.length; i++) {
            int start = road[i][0];
            int end = road[i][1];
            int weight = road[i][2];
            ArrayList<Integer> temp1 = map.getOrDefault(start, new ArrayList<>());
            if (!temp1.contains(end)) {
                temp1.add(end);
                map.put(start, temp1);
            }
            if (weightMap[start][end] == 0) {
                weightMap[start][end] = weight;
            } else {
                weightMap[start][end] = Math.min(weight, weightMap[start][end]);
            }
            ArrayList<Integer> temp2 = map.getOrDefault(end, new ArrayList<>());
            if (!temp2.contains(start)) {
                temp2.add(start);
                map.put(end, temp2);
            }
            if (weightMap[end][start] == 0) {
                weightMap[end][start] = weight;
            } else {
                weightMap[end][start] = Math.min(weight, weightMap[end][start]);
            }
        }

        makeroute(1, 0);

        for (int i = 2; i <= N; i++) {
            if (weightMap[1][i] != 0) {
                answer++;
            }
        }

        return answer;
    }

    public static void makeroute(int root, int value) {
        ArrayList<Integer> temp = map.get(root);
        for (int i = 0; i < temp.size(); i++) {
            int next = temp.get(i);
            if (!visited[next]) {
                visited[next] = true;
                value += weightMap[root][next];
                if (value <= K) {
                    if (weightMap[1][next] == 0) {
                        weightMap[1][next] = value;
                    } else {
                        weightMap[1][next] = Math.min(value, weightMap[1][next]);
                    }
                    makeroute(next, value);
                }
                value -= weightMap[root][next];
                visited[next] = false;
            }
        }
    }
}