import java.util.PriorityQueue;

public class no4 {
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 1; i <= k; i++) {
            pq.offer(Long.valueOf(i));
        }

        for (int i = 0; i < room_number.length; i++) {
            long index = room_number[i];
            if (pq.contains(index)) {
                pq.remove(index);
                answer[i] = index;
            } else {
                PriorityQueue<Long> temp = new PriorityQueue<>();
                while (index > pq.peek()) {
                    temp.offer(pq.poll());
                }
                answer[i] = pq.poll();
                while (!temp.isEmpty()) {
                    pq.offer(temp.poll());
                }
            }
        }
        return answer;
    }

//    public long[] solution(long k, long[] room_number) {
//        long[] answer = new long[room_number.length];
//        PriorityQueue<Long> pq = new PriorityQueue<>();
//
//        for (int i = 1; i <= k; i++) {
//            pq.offer(Long.valueOf(i));
//        }
//
//        for (int i = 0; i < room_number.length; i++) {
//            long index = room_number[i];
//            PriorityQueue<Long> temp = new PriorityQueue<>();
//            if (pq.contains(index)) {
//                pq.remove(index);
//                answer[i] = index;
//            } else {
//                while (index > pq.peek()) {
//                    temp.offer(pq.poll());
//                }
//                answer[i] = pq.poll();
//                while (!temp.isEmpty()) {
//                    pq.offer(temp.poll());
//                }
//            }
//        }
//        return answer;
//    }
}
