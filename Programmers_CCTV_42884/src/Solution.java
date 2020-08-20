import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0, start = 0, end = 0;
        Comparator<int[]> start_t = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        };
        PriorityQueue<node> pq = new PriorityQueue();
        Arrays.sort(routes, start_t);

        for (int i = 0; i < routes.length; i++) {
            node temp = new node(routes[i]);
            if (pq.isEmpty()) {
                pq.offer(temp);
                start = temp.start;
                end = temp.end;
            } else {
                if (end < temp.start || start > temp.end) {
                    answer++;
                    pq.clear();
                    i--;
                } else {
                    pq.offer(temp);
                    if (end > temp.end) end = temp.end;
                    if (start < temp.start) start = temp.start;
                }
            }
        }

        if (!pq.isEmpty()) {
            answer++;
        }

        return answer;
    }

    public class node implements Comparable<node> {
        public int start;
        public int end;

        public node(int[] point) {
            this.start = point[0];
            this.end = point[1];
        }

        @Override
        public int compareTo(node o) {
            return o.end - this.end;
        }
    }
}