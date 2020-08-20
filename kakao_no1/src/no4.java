import java.util.ArrayList;
import java.util.PriorityQueue;

public class no4 {
    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (long i = 1; i <= k; i++) {
            pq.add(i);
        }

        for (int i = 0; i < room_number.length; i++) {
            if(pq.contains(room_number[i])){
                answer[i] = room_number[i];
                pq.remove(room_number[i]);
            }
            else{
                ArrayList<Long> temp = new ArrayList<>();
                long num = pq.poll();
                while(num < room_number[i]){
                    temp.add(num);
                    num = pq.poll();
                }
                answer[i] = num;
                for(int j=0; j< temp.size(); j++){
                    pq.add(temp.get(j));
                }
            }
        }
        return answer;
    }
}
