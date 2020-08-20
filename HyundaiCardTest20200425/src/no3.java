import java.util.ArrayList;
import java.util.HashMap;

public class no3 {
    public String solution(String[] registered_list, String new_id) {
        String answer = "";

        HashMap<String, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < registered_list.length; i++) {
            int index = -1;
            String S = registered_list[i];
            int N = 0;
            for (int j = 0; j < registered_list[i].length(); j++) {
                char a = registered_list[i].charAt(j);
                if (a <= '9' && a >= '0') {
                    index = j;
                    break;
                }
            }
            if (index != -1) {
                S = registered_list[i].substring(0, index);
                N = Integer.parseInt(registered_list[i].substring(index));
            }
            ArrayList<Integer> al = new ArrayList<>();
            if (map.containsKey(S)) {
                al = map.get(S);
            }
            al.add(N);
            map.put(S, al);
        }
        String newS = new_id;
        int newN = 0;
        int new_index = 0;
        for (int i = 0; i < new_id.length(); i++) {
            if (new_id.charAt(i) <= '9' && new_id.charAt(i) >= '0') {
                new_index = i;
                newS = new_id.substring(0, new_index);
                newN = Integer.parseInt(new_id.substring(new_index));
                break;
            }
        }
        if (map.containsKey(newS)) {
            ArrayList temp = map.get(newS);
            if (temp.size() != 0) {
                while (temp.contains(newN)) {
                    newN++;
                }
                if (newN != 0) {
                    new_id = newS + newN;
                }
            }
        }
        answer = new_id;
        return answer;
    }
}
