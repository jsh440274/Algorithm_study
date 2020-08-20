import java.util.Collections;
import java.util.PriorityQueue;

class no5 {
    public static int[] stones;

    public int solution(int[] stones, int k) {
        this.stones = stones;
        int answer = 200000000, len = stones.length;
//        int index = 0;
        for (int i = -1; i < len - k; ) {
            int max = 0;
            int index = 0;
            for (int j = i + 1; j <= i + k; j++) {
                if (max < stones[j]) {
                    index = j;
                    max = stones[j];
                }
            }
            if (answer > max) {
                answer = max;
            }
            i = index;
        }
        return answer;
    }

    public int binarySearch(int start, int end) {
        int max = 0;
        int mid = (start + end) / 2;
        while (start <= end) {
            max = Math.max(max, stones[binarySearch(start, mid)]);
            max = Math.max(max, stones[binarySearch(mid, end)]);
        }
        return mid;
    }

//    public int solution(int[] stones, int k) {
//        int answer = 200000000;
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//
//        for (int i = 0; i < k; i++) {
//            pq.offer(stones[i]);
//        }
//
//        for (int i = k; i < stones.length; i++) {
//            answer = Math.min(answer, pq.peek());
//            pq.remove(stones[i - k]);
//            pq.offer(stones[i]);
//        }
//
//        answer = Math.min(answer, pq.peek());
//        return answer;
//    }

//    public int solution(int[] stones, int k) {
//        Queue<Integer> q = new LinkedList<>();
//        int max = 0, min = Integer.MAX_VALUE;
//
//        for (int i = 0; i < stones.length; i++) {
//            if (max <= stones[i]) {
//                q.clear();
//                max = stones[i];
//            } else if (q.size() > k) {
//                q.poll();
//                Iterator<Integer> it = q.iterator();
//                max = 0;
//                while (it.hasNext()) {
//                    max = Math.max(it.next(), max);
//                }
//                min = Math.min(max, min);
//            }
//            q.offer(stones[i]);
//        }
//        return min;
//    }
}