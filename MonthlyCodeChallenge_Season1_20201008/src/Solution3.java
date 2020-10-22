import java.util.Collections;
import java.util.PriorityQueue;

class Solution3 {
    public int[][] map;
    public int[] value;
    public boolean[] visited;
    public int root;
    public int n;

    public int solution(int n, int[][] edges) {
        map = new int[n + 1][n + 1];
        value = new int[n + 1];
        visited = new boolean[n + 1];
        int[] rooting = new int[n + 1];
        this.n = n;

        for (int i = 0; i < edges.length; i++) {
            rooting[edges[i][0]]++;
            rooting[edges[i][1]]++;

            map[edges[i][0]][edges[i][1]] = 1;
            map[edges[i][1]][edges[i][0]] = 1;
        }

        int max = 0;
        for (int i = 1; i < rooting.length; i++) {
            if (max < rooting[i]) {
                root = i;
                max = rooting[i];
            }
        }
        visited[root] = true;
        makingValue(root, 0);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < value.length; i++) {
            pq.add(value[i]);
        }
        int max1 = pq.poll();
        pq.poll();
        int max3 = pq.poll();

        return max1 + max3;
    }

    public void makingValue(int root, int val) {
        for (int i = 1; i < n + 1; i++) {
            if(map[root][i] == 1 && !visited[i]){
                visited[i] = true;
                makingValue(i, val + 1);
                visited[i] = false;
            }
        }
        value[root] = val;
    }
}