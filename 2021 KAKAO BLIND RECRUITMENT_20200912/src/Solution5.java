import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution5 {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int playend = 0;
        PriorityQueue<Integer> fpq = new PriorityQueue<>();
        Queue<Integer> fq = new LinkedList<>();
        PriorityQueue<Integer> bpq = new PriorityQueue<>();
        Queue<Integer> bq = new LinkedList<>();

        for (int i = 0; i < logs.length; i++) {
            String[] l = logs[i].split("-");
            int start = converttime(l[0]);
            int end = converttime(l[1]);
            fpq.offer(start);
            bpq.offer(end);
            playend = Math.max(end, playend);
        }

        int playtime = converttime(play_time);
        int advtime = converttime(adv_time);
        int stacked = 0;
        int minused = 0;
        int prev = 0;
        int rettime = 0;
        if (advtime >= playtime) {
            return "00:00:00";
        }

        for (int i = 1; i <= playtime; i++) {
            int firsttime = 1;
            if (i > advtime) {
                firsttime = i - advtime + 1;
                if (!fq.isEmpty() && fq.peek() == firsttime) {
                    minused++;
                    fq.poll();
                }
                if (!bq.isEmpty() && bq.peek() == firsttime) {
                    minused--;
                    bq.poll();
                }
                rettime -= minused;
            }
            if (!fpq.isEmpty() && fpq.peek() == i) {
                stacked++;
                fq.offer(fpq.poll());
            }
            if (!bpq.isEmpty() && bpq.peek() == i) {
                stacked--;
                bq.offer(bpq.poll());
            }
            rettime += stacked;
            if (prev < rettime) {
                String rett = reversetime(firsttime + 1);
                answer = rett;
                prev = rettime;
            }
        }

        return answer;
    }

    public static int converttime(String s) {
        String[] temp = s.split(":");
        int ret = Integer.parseInt(temp[0]) * 3600 + Integer.parseInt(temp[1]) * 60 + Integer.parseInt(temp[2]);
        return ret;
    }

    public static String reversetime(int s) {
        StringBuffer ret = new StringBuffer();

        if (s < 3600) {
            ret.append("00:");
        } else {
            int t = s / 3600;
            if (t < 10) {
                ret.append('0');
            }
            ret.append(t);
            ret.append(':');
            s %= 3600;
        }
        if (s < 60) {
            ret.append("00:");
        } else {
            int t = s / 60;
            if (t < 10) {
                ret.append('0');
            }
            ret.append(t);
            ret.append(':');
            s %= 60;
        }
        int t = s % 60;
        if (t < 10) {
            ret.append('0');
        }
        ret.append(t);

        return ret.toString();
    }
}