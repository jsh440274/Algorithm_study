import java.util.HashMap;
import java.util.Set;

class Solution1 {
    public int solution(int[][] boxes) {
        int answer = 0;
        HashMap<Integer, Integer> a = new HashMap<>();
        HashMap<Integer, Integer> b = new HashMap<>();

        for (int i = 0; i < boxes.length; i++) {
            int counta = a.getOrDefault(boxes[i][0], 0);
            counta++;
            a.put(boxes[i][0], counta);
            int countb = b.getOrDefault(boxes[i][1], 0);
            countb++;
            b.put(boxes[i][1], countb);
        }

        Set<Integer> akeyset = a.keySet();
        Set<Integer> bkeyset = b.keySet();
        if (akeyset.size() > bkeyset.size()) {
            for (int key : akeyset) {
                int acount = a.get(key);
                int bcount = b.getOrDefault(key, 0);
                int num = Math.abs(acount - bcount);
                answer += num;
            }
        } else {
            for (int key : bkeyset) {
                int bcount = b.get(key);
                int acount = a.getOrDefault(key, 0);
                int num = Math.abs(acount - bcount);
                answer += num;
            }
        }

        return answer;
    }
}