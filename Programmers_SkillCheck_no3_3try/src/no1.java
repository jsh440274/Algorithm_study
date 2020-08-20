import java.util.ArrayList;
import java.util.Arrays;

public class no1 {
    static int n;
    static int s;
    static long finalmul;
    static int[] answer;
    static ArrayList<Integer> pickedNum = new ArrayList<>();

    public int[] solution(int n, int s) {
        if (s < n) {
            int[] temp = {-1};
            answer = temp;
        } else {
            answer = new int[n];
            int dividedS = s / n;
            int rest = s % n;
            Arrays.fill(answer, dividedS);

            for (int i = 0; i < rest; i++) {
                answer[n - 1 - i]++;
            }
        }
        return answer;
    }
}
