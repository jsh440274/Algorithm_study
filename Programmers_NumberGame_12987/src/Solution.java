import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Queue<Integer> aq = new LinkedList<>();
        Queue<Integer> bq = new LinkedList<>();

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = A.length - 1; i >= 0; i--) {
            aq.offer(A[i]);
            bq.offer(B[i]);
        }

        for (int i = 0; i < A.length; i++) {
            int index = bq.peek();
            int temp = aq.poll();
            if (temp < index) {
                answer++;
                bq.poll();
            } else {
                aq.offer(temp);
            }
        }

        return answer;
    }
}