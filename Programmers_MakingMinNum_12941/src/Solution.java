import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] A, int[] B) {
        long answer = 0;
        PriorityQueue<Integer> a = new PriorityQueue<>();
        PriorityQueue<Integer> b = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < A.length; i++) {
            a.add(A[i]);
            b.add(B[i]);
        }

        while (!a.isEmpty()) {
            answer += a.poll() * b.poll();
        }

        return (int) answer;
    }
}