import java.util.PriorityQueue;

public class no2 {
    public int solution(int[] people, int[] tshirts) {
        int answer = 0;

        PriorityQueue<Integer> pp = new PriorityQueue<>();
        PriorityQueue<Integer> ts = new PriorityQueue<>();

        for (int p : people) {
            pp.add(p);
        }
        for (int t : tshirts) {
            ts.add(t);
        }

        while (!ts.isEmpty()) {
            if (pp.peek() <= ts.peek()) {
                pp.poll();
                answer++;
            }
            ts.poll();
        }

        return answer;
    }
}
