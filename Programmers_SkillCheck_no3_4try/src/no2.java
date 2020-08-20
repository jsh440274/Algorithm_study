import java.util.Collections;
import java.util.PriorityQueue;

public class no2 {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minpq = new PriorityQueue<>();
        PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());

        for (String x : operations) {
            String[] oper = x.split(" ");
            String operator = oper[0];
            int num = Integer.parseInt(oper[1]);

            if (operator.equals("I")) {
                maxpq.add(num);
                minpq.add(num);
            } else if (maxpq.isEmpty()) {
                continue;
            } else {
                if (num == 1) {
                    int max = maxpq.remove();
                    minpq.remove(max);
                } else {
                    int min = minpq.remove();
                    maxpq.remove(min);
                }
            }
        }
        if (maxpq.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = maxpq.remove();
            answer[1] = minpq.remove();
        }
        return answer;
    }
}
