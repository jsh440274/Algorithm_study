import java.util.Arrays;

class Solution {
    public int solution(int[] weight) {
        int answer = 1;
        Arrays.sort(weight);

        for (int i = 0; i < weight.length; i++) {
            int w = weight[i];
            if (answer < w) {
                break;
            } else {
                answer += w;
            }
        }
        return answer;
    }
}