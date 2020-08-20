import java.util.*;

public class no1 {

    public int solution(String p, String s) {
        int answer = 0;
        for (int i = 0; i < p.length(); i++) {
            int a = p.charAt(i) - 48;
            int b = s.charAt(i) - 48;
            int x = Math.max(a, b);
            int y = Math.min(a, b);
            int way1 = x - y;
            int way2 = 10 - x + y;
            answer += Math.min(way1, way2);

        }
        return answer;
    }
}