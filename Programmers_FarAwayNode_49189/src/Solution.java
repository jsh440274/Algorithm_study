//class Solution {
//
//    public int solution(int n, int[][] edge) {
//        int answer = 0;
//        int[][] map = new int[n + 1][n + 1];
//        boolean[] visited = new boolean[n + 1];
//        for (int i = 0; i < edge.length; i++) {
//            int a = edge[i][0];
//            int b = edge[i][1];
//            map[a][b] = 1;
//            map[b][a] = 1;
//        }
//        for (int i = 1; i < n; i++) {
//
//        }
//        return answer;
//    }
//}

//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Set;
//
//class Solution {
//    public static int[] max;
//    public static boolean[] visited;
//    public static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
//    public static HashMap<Integer, Integer> count = new HashMap<>();
//
//    public int solution(int n, int[][] edge) {
//        int answer = 0;
//        max = new int[n + 1];
//        visited = new boolean[n + 1];
//        visited[1] = true;
//        for (int i = 0; i < edge.length; i++) {
//            ArrayList<Integer> temp = map.getOrDefault(edge[i][0], new ArrayList<>());
//            temp.add(edge[i][1]);
//            map.put(edge[i][0], temp);
//            temp = map.getOrDefault(edge[i][1], new ArrayList<>());
//            temp.add(edge[i][0]);
//            map.put(edge[i][1], temp);
//        }
//
//        find_depth(1, 0);
//        Set<Integer> keyset = count.keySet();
//        int k = 0;
//        for (int key : keyset) {
//            if (k < key && count.get(key) != 0) {
//                k = key;
//                answer = count.get(key);
//            }
//        }
//        return answer;
//    }
//
//    public static void find_depth(int i, int current_depth) {
//        if (max[i] != 0) {
//            if (max[i] == current_depth) return;
//            if (max[i] > current_depth) {
//                int original = count.get(max[i]) - 1;
//                count.put(max[i], original);
//                max[i] = current_depth;
//                int input = count.getOrDefault(current_depth, 0) + 1;
//                count.put(current_depth, input);
//            }
//        } else {
//            max[i] = current_depth;
//            int input = count.getOrDefault(max[i], 0) + 1;
//            count.put(max[i], input);
//        }
//        current_depth++;
//        ArrayList<Integer> temp = map.get(i);
//        for (int j = 0; j < temp.size(); j++) {
//            int node = temp.get(j);
//            if (!visited[node]) {
//                visited[node] = true;
//                find_depth(node, current_depth);
//                visited[node] = false;
//            }
//        }
//    }
//}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

    public int solution(int n, int[][] edge) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < edge.length; i++) {
            ArrayList<Integer> temp = map.getOrDefault(edge[i][0], new ArrayList<>());
            temp.add(edge[i][1]);
            map.put(edge[i][0], temp);
            temp = map.getOrDefault(edge[i][1], new ArrayList<>());
            temp.add(edge[i][0]);
            map.put(edge[i][1], temp);
        }

        
        return answer;
    }
}