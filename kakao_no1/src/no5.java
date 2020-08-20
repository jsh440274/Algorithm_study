import java.util.Arrays;

public class no5 {
    public int solution(int[] stones, int k) {
        int answer = 200000000;
        for (int i = 0; i < stones.length - k; i++) {
            int[] temp = new int[k];
            System.arraycopy(stones, i, temp, 0, k);
            Arrays.sort(temp);
            answer = Math.min(answer, temp[k - 1]);
        }
        return answer;
    }
}
