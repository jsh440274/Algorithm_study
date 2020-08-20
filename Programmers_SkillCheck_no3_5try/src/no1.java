
public class no1 {
    public long solution(int n, int[] times) {
        long min = 1, max = 0;
        for (int i = 0; i < times.length; i++) {
            max = Math.max(times[i], max);
        }
        max *= n;
        long answer = max;

        while (min <= max) {
            long mid = (max + min) / 2;
            long capable = 0;
            for (long time : times) {
                capable += mid / time;
            }
            if (capable < n) {
                min = mid + 1;
            } else {
                if (capable == n && answer >= mid) {
                    answer = mid;
                }
                max = mid - 1;
            }
        }
        return answer;
    }


//    public long solution(int n, int[] times) {
//        long answer = 0;
//        Arrays.sort(times);
//        if (n < times.length) {
//            answer = times[n - 1];
//        } else {
//            PriorityQueue<liner> pq = new PriorityQueue<>();
//            for (int i = 0; i < times.length; i++) {
//                liner temp = new liner(times[i]);
//                pq.add(temp);
//            }
//            while (n > 0) {
//                liner temp = pq.remove();
//                answer = temp.nexttime;
//                temp.nexttime += temp.time;
//                pq.add(temp);
//                n--;
//            }
//        }
//        return answer;
//    }
//
//    public class liner implements Comparable<liner> {
//        public long time, nexttime;
//
//        public liner(int time) {
//            this.time = time;
//            this.nexttime = time;
//        }
//
//        @Override
//        public int compareTo(liner target) {
//            if (this.nexttime > target.nexttime) {
//                return 1;
//            } else if (this.nexttime < target.nexttime) {
//                return -1;
//            }
//            return 0;
//        }
//    }
}
