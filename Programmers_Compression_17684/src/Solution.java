import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] solution(String msg) {
        if (msg.length() == 1) {
            int[] temp = {msg.charAt(0) - 64};
            return temp;
        }
        ArrayList<Integer> al = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= 26; i++) {
            map.put(String.valueOf((char) (64 + i)), i);
        }

        String prev = String.valueOf(msg.charAt(0));
        int index = 27;
        for (int i = 1; i < msg.length(); i++) {
            String key = prev + msg.charAt(i);
            if (map.containsKey(key)) {
                prev = key;
                continue;
            } else {
                map.put(key, index);
                index++;
                al.add(map.get(prev));
                prev = String.valueOf(msg.charAt(i));
            }
        }
        al.add(map.get(prev));

        int[] answer = new int[al.size()];
        for (int i = 0; i < al.size(); i++) {
            answer[i] = al.get(i);
        }
        return answer;
    }
}