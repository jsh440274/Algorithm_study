import java.util.ArrayList;
import java.util.Collections;

public class no2 {
    public int solution(int[][] routes) {
        int carNum = routes.length;
        int answer = 0;

        class cars implements Comparable<cars> {
            int start;
            int end;

            public cars(int start, int end) {
                this.start = start;
                this.end = end;
            }

            @Override
            public int compareTo(cars target) {
                return (this.end - this.start) >= (target.end - target.start) ? 1 : -1;
            }
        }

        ArrayList<cars> al = new ArrayList<>();

        for (int i = 0; i < carNum; i++) {
            al.add(new cars(routes[i][0], routes[i][1]));
        }

        Collections.sort(al);

        for (int i = 0; i < al.size(); i++) {
            cars temp1 = al.remove(i);
            answer++;
            for (int j = 0; j < al.size(); j++) {
                cars temp2 = al.get(j);
                if (temp2.start <= temp1.start && temp2.end >= temp1.end) {
                    al.remove(temp2);
                    j--;
                }
                if (temp2.start == temp1.end) {
                    temp1.start = temp1.end;
                    al.remove(temp2);
                    j--;
                }
                if (temp2.end == temp1.start) {
                    temp1.end = temp1.start;
                    al.remove(temp2);
                    j--;
                }
            }
        }
        return answer;
    }
}
