import java.util.ArrayList;
import java.util.Collections;

class Solution {//크루스칼로 하면 편함.
    public int solution(int n, int[][] costs) {
        int answer = 0;
        ArrayList<node> nodes = new ArrayList<>();
        boolean[] visited = new boolean[n];

        for (int i = 0; i < costs.length; i++) {
            nodes.add(new node(costs[i][0], costs[i][1], costs[i][2]));
        }

        Collections.sort(nodes);

        visited[nodes.get(0).start] = true;
        while (!check(visited)) {
            for (int i = 0; i < nodes.size(); i++) {
                node temp = nodes.get(i);
                if (visited[temp.start] && !visited[temp.end]) {
                    visited[temp.end] = true;
                    answer += temp.value;
                    break;
                } else if (!visited[temp.start] && visited[temp.end]) {
                    visited[temp.start] = true;
                    answer += temp.value;
                    break;
                }
            }
        }
        return answer;
    }

    public static boolean check(boolean[] visited) {
        boolean ret = true;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return ret;
    }

    public class node implements Comparable<node> {
        int value;
        int start;
        int end;

        public node(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(node target) {
            if (target.value < this.value) {
                return 1;
                
            } else if (target.value > this.value) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}


//
//class Solution {//다직스트라는 외않되?
//다직스트라가 안되는게 아니라 내가 못짠거임 ㅇㅇ
//    public static int[][] map;
//    public static int[][] visited;
//
//    public int solution(int n, int[][] costs) {//가장 처음 나온 노드를 루트노드로 하고 거기서부터 퍼져나가는 역병
//        int answer = Integer.MAX_VALUE;
//        map = new int[n][n];
//        visited = new int[n][n];
//
//        for (int i = 0; i < costs.length; i++) {
//            map[costs[i][0]][costs[i][1]] = costs[i][2];
//            map[costs[i][1]][costs[i][0]] = costs[i][2];
//        }
//
//        boolean flag = false;
//        while (!flag) {
//            flag = true;
//            for (int i = 0; i < n; i++) {//0번노드부터 쥰내 돌아.
//                //맵에 있는 값들보다 작은 값들이 나오면 더 작은 값으로 바꾸고 플래그 false;
//                //플래그 안바뀔때까지 무한반복.
//                for (int j = 0; j < n; j++) {
//                    if (i == j) continue;
//                    int original_cost = map[i][j];
//                    int new_cost = find_shortest(i, j);
//                    if (original_cost != new_cost) {
//                        flag = false;
//                        map[i][j] = new_cost;
//                        map[j][i] = new_cost;
//                    }
//                }
//            }
//        }
//
//        for (int i = 0; i < n; i++) {
//            int ret = 0;
//            for (int j = 0; j < n; j++) {
//                if (visited[0][j] != 0) {
//                    ret += map[visited[0][j]][j];
//                } else {
//                    ret += map[0][j];
//                }
//            }
//            answer = Math.min(answer, ret);
//        }
//
//        return answer;
//    }
//
//    public static int find_shortest(int start, int end) {
//        int cost = map[start][end];
//        if (cost == 0) {
//            cost = Integer.MAX_VALUE;
//        }
//        for (int j = 0; j < map.length; j++) {
//            if (j == end) continue;
//            if (map[start][j] != 0 && map[j][end] != 0) {
//                if (cost > map[start][j] + map[j][end]) {
//                    cost = map[start][j] + map[j][end];
//                    visited[start][end] = j;
//                }
//            }
//        }
//        return cost;
//    }
//}