import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int s : scoville) {
            pq.add(s);
        }

        while (pq.peek() < K) {
            if (pq.size() < 2) return -1;
            int min = pq.poll();
            int minmin = pq.poll();
            int mixed = min + (minmin * 2);
            pq.offer(mixed);
            answer++;
        }

        return answer;
    }
}