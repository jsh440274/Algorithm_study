import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

class no3 {
    public static HashMap<Integer, ArrayList<node>> map = new HashMap<>();//노드들이 어떤식으로 이어져있는지 저장
    public static HashMap<Integer, Integer> total_map = new HashMap<>();//노드들하고 밸류값들 저장. -> 생각해보니까 어차피 노드 쓸꺼면 그냥 노드 저장하는 set으로 하면 됐을듯 비효율1

    public int[] solution(int total_sp, int[][] skills) {
        int[] answer = new int[skills.length + 1];

        for (int i = 0; i < skills.length; i++) {
            int a = skills[i][0];
            node b = new node(skills[i][1]);
            ArrayList<node> temp = map.getOrDefault(a, new ArrayList<>());
            temp.add(b);
            map.put(a, temp);//여기서 total_map에 넣을수 있었다면 어땠을까.
        }

        int node_count = 0;
        Set<Integer> keys = map.keySet();
        for (int key : keys) {
            ArrayList<node> temp = map.get(key);
            int values = calc_values(temp);
            total_map.put(key, values);
        }

        keys = total_map.keySet();
        for (int k : keys) {
            node_count += total_map.get(k);
        }

        total_sp /= node_count;
        for (int i = 1; i <= answer.length; i++) {
            answer[i - 1] = total_map.get(i) * total_sp;
        }

        return answer;
    }

    public static int calc_values(ArrayList<node> temp) {
        int values = 0;
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).value == -1) {
                if (map.containsKey(temp.get(i).num)) {
                    values += calc_values(map.get(temp.get(i).num));
                } else {
                    total_map.put(temp.get(i).num, 1);
                    values += 1;
                }
            } else {
                values += temp.get(i).value;
            }
        }
        return values;
    }

    public class node {
        int num;
        int value;

        public node(int num) {
            this.num = num;
            this.value = -1;
        }
    }
}

//import java.util.ArrayList;
//        import java.util.HashMap;
//        import java.util.Set;
//
//class no3 {
//    public static HashMap<Integer, ArrayList<node>> map = new HashMap<>();//노드들이 어떤식으로 이어져있는지 저장
//    public static HashMap<Integer, Integer> total_map = new HashMap<>();//노드들하고 밸류값들 저장. -> 생각해보니까 어차피 노드 쓸꺼면 그냥 노드 저장하는 set으로 하면 됐을듯
//
//    public int[] solution(int total_sp, int[][] skills) {
//        int[] answer = new int[skills.length + 1];
//
//        for (int i = 0; i < skills.length; i++) {
//            int a = skills[i][0];
//            node b = new node(skills[i][1]);
//            ArrayList<node> temp = map.getOrDefault(a, new ArrayList<>());
//            temp.add(b);
//            map.put(a, temp);
//        }
//
//        int node_count = 0;
//        Set<Integer> keys = map.keySet();
//        for (int key : keys) {
//            ArrayList<node> temp = map.get(key);
//            int values = calc_values(temp);
//            total_map.put(key, values);
//        }
//
//        keys = total_map.keySet();
//        for (int k : keys) {
//            node_count += total_map.get(k);
//        }
//
//        total_sp /= node_count;
//        for (int i = 1; i <= answer.length; i++) {
//            answer[i - 1] = total_map.get(i) * total_sp;
//        }
//
//        return answer;
//    }
//
//    public static int calc_values(ArrayList<node> temp) {
//        int values = 0;
//        for (int i = 0; i < temp.size(); i++) {
//            if (temp.get(i).value == -1) {
//                if (map.containsKey(temp.get(i).num)) {
//                    values += calc_values(map.get(temp.get(i).num));
//                } else {
//                    total_map.put(temp.get(i).num, 1);
//                    values += 1;
//                }
//            } else {
//                values += temp.get(i).value;
//            }
//        }
//        return values;
//    }
//
//    public class node {
//        int num;
//        int value;
//
//        public node(int num) {
//            this.num = num;
//            this.value = -1;
//        }
//    }
//}