import java.util.Stack;

public class no2 {
    public int solution(String arrangement) {
        int answer = 0;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < arrangement.length(); i++) {
            if (arrangement.charAt(i) == '(') {
                s.push(i);
            } else {
                if (s.peek() != i - 1) {
                    s.pop();
                    answer++;
                } else {
                    s.pop();
                    answer += s.size();
                }
            }
        }
        return answer;
    }
}