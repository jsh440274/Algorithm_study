import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0, index = 0, running = 0, finished = 0, n = jobs.length;
        PriorityQueue<job> pq = new PriorityQueue<>();
        Comparator<int[]> t = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return 1;
                } else if (o1[0] < o2[0]) {
                    return -1;
                }
                return 0;
            }
        };
        Arrays.sort(jobs, t);

        while (index < n) {
            if (jobs[index][0] == running) {
                job temp = new job(jobs[index][0], jobs[index][1]);
                pq.offer(temp);
                index++;
            }
            if (!pq.isEmpty()) {
                job temp = pq.peek();
                if (temp.time + finished == running) {
                    finished = running;
                    answer += running - temp.start;
                    pq.poll();
                }
            }
            running++;
        }

        while (!pq.isEmpty()){
            job temp = pq.poll();
            running += temp.time;
            answer += running - temp.start;
        }

        return answer / n;
    }

    public class job implements Comparable<job> {
        int start;
        int time;

        public job(int start, int time) {
            this.start = start;
            this.time = time;
        }

        @Override
        public int compareTo(job t) {
            if (t.time > this.time) {
                return -1;
            } else if (t.time < this.time) {
                return 1;
            }
            return 0;
        }
    }
}


//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.PriorityQueue;
//
//class Solution {
//    public int solution(int[][] jobs) {
//        int answer = 0, end = 0;
//        int n = jobs.length;
//        Comparator<int[]> job_compare = new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] - o2[0];
//            }
//        };
//        Arrays.sort(jobs, job_compare);
//        PriorityQueue<job> pq = new PriorityQueue<>();//소요시간이 작은 애들부터 빨리 끝냄
//
//        for (int i = 0; i < n; i++) {
//            if (jobs[i][0] < end) {
//                pq.offer(new job(jobs[i][0], jobs[i][1]));
//            } else {
//                if (pq.isEmpty()) {
//                    end = jobs[i][0] + jobs[i][1];
//                    answer += jobs[i][1];
//                } else {
//                    job polled = pq.poll();
//                    end += polled.time;
//                    answer += end - polled.start;
//                }
//            }
//        }
//        while (!pq.isEmpty()) {
//            job polled = pq.poll();
//            end += polled.time;
//            answer += end - polled.start;
//        }
//
//        return answer / n;
//    }
//
//    public class job implements Comparable<job> {
//        int start;
//        int time;
//
//        public job(int s, int t) {
//            start = s;
//            time = t;
//        }
//
//        @Override
//        public int compareTo(job t) {
//            if (t.time < this.time) {
//                return 1;
//            } else if (t.time > this.time) {
//                return -1;
//            } else {
//                return 0;
//            }
//        }
//    }
//}