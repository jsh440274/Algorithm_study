import java.util.Stack;

public class no1 {
    boolean solution(String s) {
        Stack<Character> q = new Stack<>();
        boolean answer = true;

        for (int i = 0; i < s.length(); i++) {
            char index = s.charAt(i);
            if (index == '(') {
                q.push(index);
            } else if (!q.isEmpty()) {
                q.pop();
            }else{
                return false;
            }
        }

        if (!q.isEmpty()) {
            answer = false;
        }
        return answer;
    }
}
