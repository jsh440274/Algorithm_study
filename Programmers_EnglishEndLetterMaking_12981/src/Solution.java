import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> wordSet = new HashSet<>();
        int circlecount = 1;
        int index = 0;
        String prev = words[0];
        wordSet.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            index++;
            if (index >= n) {
                index %= n;
                circlecount++;
            }
            if (words[i].charAt(0) != prev.charAt(prev.length() - 1) || wordSet.contains(words[i])) {
                answer[0] = index + 1;
                answer[1] = circlecount;
                return answer;
            }
            prev = words[i];
            wordSet.add(words[i]);
        }
        return answer;
    }
}