import java.util.LinkedList;
import java.util.Queue;

public class no1 {
    public int[] solution(String[] purchase) {
        int[] month = new int[13];
        month[1] = 31;
        month[2] = 28;
        month[3] = 31;
        month[4] = 30;
        month[5] = 31;
        month[6] = 30;
        month[7] = 31;
        month[8] = 31;
        month[9] = 30;
        month[10] = 31;
        month[11] = 30;
        month[12] = 31;
        int[] answer = new int[5];
        int sub = 0;
        int add = 0;
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        Queue<Integer> q3 = new LinkedList<>();

        int index = 0;
        String[] money = purchase[index].split(" ");
        String[] temp = money[0].split("/");
        int day = Integer.parseInt(temp[2]);
        for (int i = 1; i < Integer.parseInt(temp[1]); i++) {
            day += month[i];
        }
        for (int i = 1; i <= 365; i++) {
            if (day == i) {
                for (int j = 1; j < Integer.parseInt(temp[1]); j++) {
                    day += month[j];
                }
                add += Integer.parseInt(money[1]);
                q2.add(day);
                q3.add(Integer.parseInt(money[1]));
                index++;
                if (index < purchase.length) {
                    money = purchase[index].split(" ");
                    temp = money[0].split("/");
                    day = Integer.parseInt(temp[2]);
                }
            }
            if (q.size() == 30) {
                //앞에서부터 poll하고 sub추가
                //등급매겨서 플러스
                if (!q2.isEmpty()) {
                    int nowday = q2.peek();
                    if (nowday + 30 == i) {
                        sub += q3.poll();
                        q2.poll();
                    }
                }
                int rank = q.poll() - sub;
                if (rank >= 0 && rank <= 10000) {
                    answer[0]++;
                }else if (rank >= 10000 && rank < 20000) {
                    answer[1]++;
                }else if (rank >= 20000 && rank < 50000) {
                    answer[2]++;
                }else if (rank >= 50000 && rank < 100000) {
                    answer[3]++;
                }else if (rank >= 100000) {
                    answer[4]++;
                }
            }
            q.add(add);
        }

        while (!q.isEmpty()) {
            int rank = q.poll();
            if (rank >= 0 && rank <= 10000) {
                answer[0]++;
            }else if (rank >= 10000 && rank < 20000) {
                answer[1]++;
            }else if (rank >= 20000 && rank < 50000) {
                answer[2]++;
            }else if (rank >= 50000 && rank < 100000) {
                answer[3]++;
            }else if (rank >= 100000) {
                answer[4]++;
            }
        }

        return answer;
    }
}
