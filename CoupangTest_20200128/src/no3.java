import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.PriorityQueue;

public class no3 {
    public int[] solution(int numServer, String[] logs) throws ParseException {
        int[] answer = new int[2];
        SimpleDateFormat sdf1 = new SimpleDateFormat("kk:mm:ss.SSS");
        SimpleDateFormat sdf2 = new SimpleDateFormat("s.SSS");
        PriorityQueue<Long> pq = new PriorityQueue();
        final long abs1 = sdf1.parse("00:00:00.000").getTime();
        final long abs2 = sdf2.parse("0.000").getTime();

        long[] RRServer = new long[numServer];
        Arrays.fill(RRServer, Long.MIN_VALUE);

        for (int i = 0; i < logs.length; i++) {
            String strDate = logs[i].split(" ")[0];
            String pcsTime = logs[i].split(" ")[1];
            Date startdate = sdf1.parse(strDate);
            Date processingSecond = sdf2.parse(pcsTime);

            long startTime = startdate.getTime() - abs1;
            long processingTime = processingSecond.getTime() - abs2;
            long endTime = startTime + processingTime;

            //RC의 경우. 기냥 i번을 numServer으로 나눈 나머지루다가 접근. 순차적으로 끼워넣기를 시전.
            //없으면 그냥 넣으면 될 것이고 있으면 시작 시간 비교해서 시작 시간이 이미 있는 끝나는 시간보다 작을 경우에

            if (RRServer[i % numServer] > startTime) {
                RRServer[i % numServer] += processingTime;
            } else {
                RRServer[i % numServer] = endTime;
            }

            //LC의 경우. 큐가 꽉 안차있으면 큐에 넣고 꽉차있으면 하나씩 꺼내가면서 비교해서 넣음.
            //가장 작은 녀석이 빠졌는데 해당 시작시간보다 작으면 endTime을 넣고, 시작시간보다 크면(아직 안끝났으면) processingTime을 더해서 넣음.
            if (pq.size() != numServer) {
                pq.add(endTime);
            } else {
                long earliestTime = pq.poll();
                if (earliestTime > startTime) {
                    pq.add(earliestTime + processingTime);
                } else {
                    pq.add(endTime);
                }
            }
        }

        long RR = 0;
        long LC = 0;

        for (int i = 0; i < numServer; i++) {
            RR = Math.max(RR, RRServer[i]);
            LC = pq.poll();
        }

        if (RR == LC) {
            answer[0] = 0;
            answer[1] = 0;
        } else if (RR < LC) {
            answer[0] = 1;
            answer[1] = (int) (LC - RR);
        } else {
            answer[0] = 2;
            answer[1] = (int) (RR - LC);
        }

        return answer;
    }
}
