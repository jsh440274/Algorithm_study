import java.util.Arrays;

class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        work[] works = new work[lines.length];
        for (int i = 0; i < lines.length; i++) {
            String[] line = lines[i].split(" ");
            double end = ConvertingTime(line[1]);
            double second = Double.parseDouble(line[2].substring(0, line[2].length() - 1));
            double start = end - second;
            works[i] = new work(start, end);
        }
        Arrays.sort(works);

        for (int i = 0; i < lines.length; i++) {

        }
        return answer;
    }

    public static double ConvertingTime(String time) {
        String[] timeline = time.split(":");
        double hour = Double.parseDouble(timeline[0]);
        double minute = Double.parseDouble(timeline[1]);
        double second = Double.parseDouble(timeline[2]);
        double total = second + minute * 60 + hour * 3600;
        return total;
    }

    public class work implements Comparable<work> {
        long start;
        long end;

        public work(double start, double end) {
            this.start = (long) start * 1000;
            this.end = (long) end * 1000;
        }

        @Override
        public int compareTo(work o) {
            if (this.start > o.start) {
                return 1;
            } else if (this.start < o.start) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}

//import java.util.Arrays;
//        import java.util.PriorityQueue;
//
//class Solution {
//    public int solution(String[] lines) {
//        int answer = 0;
//        work[] works = new work[lines.length];
//        PriorityQueue<Long> pq = new PriorityQueue<>();
//
//        for (int i = 0; i < lines.length; i++) {
//            String[] line = lines[i].split(" ");
//            double end = ConvertingTime(line[1]);
//            double second = Double.parseDouble(line[2].substring(0, line[2].length() - 1));
//            double start = end - second - 1;
//            works[i] = new work(start, end);
//        }
//
//        Arrays.sort(works);
//        long currentTime = works[0].start;
//        int nextIndex = 0;
//
//        while (currentTime <= works[works.length - 1].end) {
//            if (nextIndex < works.length && currentTime == works[nextIndex].start) {
//                pq.add(works[nextIndex].end);
//                nextIndex++;
//            }
//            if (!pq.isEmpty() && pq.peek() == currentTime) {
//                pq.poll();
//            }
//            answer = Math.max(answer, pq.size());
//            currentTime++;
//        }
//
//        return answer;
//    }
//
//    public static double ConvertingTime(String time) {
//        String[] timeline = time.split(":");
//        double hour = Double.parseDouble(timeline[0]);
//        double minute = Double.parseDouble(timeline[1]);
//        double second = Double.parseDouble(timeline[2]);
//        double total = second + minute * 60 + hour * 3600;
//        return total;
//    }
//
//    public class work implements Comparable<work> {
//        long start;
//        long end;
//
//        public work(double start, double end) {
//            this.start = (long) start * 1000;
//            this.end = (long) end * 1000;
//        }
//
//        @Override
//        public int compareTo(work o) {
//            if (this.start > o.start) {
//                return 1;
//            } else if (this.start < o.start) {
//                return -1;
//            } else {
//                return 0;
//            }
//        }
//    }
//}