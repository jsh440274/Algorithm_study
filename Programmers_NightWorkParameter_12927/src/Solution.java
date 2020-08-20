import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public long solution(int n, int[] works) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long answer = 0;
        long total = 0 - n;

        for (int i = 0; i < works.length; i++) {
            int temp = map.getOrDefault(works[i], 0) + 1;
            map.put(works[i], temp);
            if (!pq.contains(works[i])) {
                pq.offer(works[i]);
            }
            total += works[i];
        }
        if (total <= 0) return 0;

        while (n > 0) {
            int now = pq.poll();
            int count = map.get(now);
            int minus = map.getOrDefault(now - 1, 0);
            while (count > 0 && n > 0) {
                minus++;
                count--;
                n--;
            }
            if (!pq.contains(now - 1)) {
                pq.add(now - 1);
            }
            if (count != 0) {
                pq.add(now);
                map.put(now, count);
            } else {
                map.remove(now);
            }
            map.put(now - 1, minus);
        }

        while (!pq.isEmpty()) {
            int polled = pq.poll();
            int count = map.get(polled);
            while (count > 0) {
                answer += Math.pow(polled, 2);
                count--;
            }
        }
        return answer;
    }
}