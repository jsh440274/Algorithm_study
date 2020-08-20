import java.util.HashMap;
import java.util.Set;

class Solution {

    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        int answer = 1;
        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        Set<String> keys = map.keySet();
        for (String key : keys) {
            answer *= map.get(key) + 1;
        }

        return answer - 1;
    }


//    public static int ansarr[];
//    public static boolean visited[];
//    public static int answer = 0;
//
//    public int solution(String[][] clothes) {
//        HashMap<String, Integer> map = new HashMap<>();
//
//        for (int i = 0; i < clothes.length; i++) {
//            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
//        }
//
//        Set<String> keys = map.keySet();
//        ansarr = new int[keys.size()];
//        visited = new boolean[keys.size()];
//        int x = 0;
//        for (String key : keys) {
//            ansarr[x] = map.get(key);
//            x++;
//        }
//        if (ansarr.length == 1) return ansarr[0];
//        for (int i = 1; i <= ansarr.length; i++) {
//            permutation_sum(0, i, 1);
//        }
//
//        return answer;
//    }
//
//    public void permutation_sum(int index, int depth, int tempans) {
//        if (depth == 0) {
//            answer += tempans;
//            return;
//        }
//        for (int i = index; i < ansarr.length; i++) {
//            if (visited[i]) continue;
//            visited[i] = true;
//            int temp = tempans * ansarr[i];
//            permutation_sum(i, depth - 1, temp);
//            visited[i] = false;
//        }
//    }
}