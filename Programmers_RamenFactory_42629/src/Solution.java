import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0, index = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < k; i++) {
            if (index < dates.length && i == dates[index]) {
                pq.add(supplies[index++]);
            }
            if (stock == 0) {
                stock += pq.poll();
                answer++;
            }
            stock--;
        }
        return answer;
    }
}