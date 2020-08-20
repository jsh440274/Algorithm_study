import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class no3_2 {
    public int solution(int[] grade, int max_diff) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        Arrays.sort(grade);
        for (int i : grade) {
            if (q.isEmpty() || i - q.peek() <= max_diff) {
                q.add(i);
            }
            else {
                answer = Math.max(answer, q.size());
                while(!q.isEmpty() && i- q.peek() > max_diff){
                    q.poll();
                }
                q.add(i);
            }
        }
        return answer;
    }
}
