import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        if (citations[citations.length - 1] == 0) {
            return 0;
        }
        int answer = citations.length;

        for (int i = 0; i < citations.length - 1; i++) {
            for (int h = citations[i]; h < citations[i + 1]; h++) {
                int left = i + 1, right = citations.length - i - 1;
                if (h == citations[i]) right++;
                if (left > h || right < h) {
                    continue;
                } else {
                    answer = h;
                }
            }
        }
        return answer;
    }
}