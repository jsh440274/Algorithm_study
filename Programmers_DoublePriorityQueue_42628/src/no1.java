import java.util.Collections;
import java.util.PriorityQueue;

public class no1 {
    static class Solution {
        public int[] solution(String[] operations) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            PriorityQueue<Integer> reverse_pq = new PriorityQueue<>(Collections.reverseOrder());
            int[] answer = {0, 0};

            for (String oper : operations) {
                String[] line = oper.split(" ");
                int num = Integer.parseInt(line[1]);
                if (line[0].equals("I")) {
                    pq.offer(num);
                    reverse_pq.offer(num);
                } else {
                    if (pq.isEmpty()) continue;
                    if (num == 1) {
                        num = reverse_pq.poll();
                        pq.remove(num);
                    } else if (num == -1) {
                        num = pq.poll();
                        reverse_pq.remove(num);
                    }
                }
            }

            if (!pq.isEmpty()) {
                answer[1] = pq.poll();
                answer[0] = reverse_pq.poll();
            }

            return answer;
        }
    }
}
