import java.util.HashSet;

public class no1 {
    public int solution(int p) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        p++;
        int thisyear = p;

        while (true) {
            if (thisyear == 0) {
                return p;
            }
            int number = thisyear % 10;
            if (set.contains(number)) {
                p++;
                thisyear = p;
                set.clear();
                continue;
            } else {
                set.add(number);
                thisyear /= 10;
            }
        }

//        return answer;
    }
}