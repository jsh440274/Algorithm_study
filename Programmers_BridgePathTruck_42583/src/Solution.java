import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0, i = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int j = 0; j < bridge_length; j++) {
            q.offer(0);
        }
        while (!q.isEmpty()) {
            int popped = q.poll();
            sum -= popped;
            answer++;
            if (i < truck_weights.length) {
                if (sum + truck_weights[i] <= weight) {
                    q.offer(truck_weights[i]);
                    sum += truck_weights[i];
                    i++;
                } else {
                    q.offer(0);
                }
            }
        }
        return answer;
    }
}