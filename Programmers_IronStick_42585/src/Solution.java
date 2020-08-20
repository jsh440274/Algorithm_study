import java.util.Stack;

class Solution {
    public int solution(String arrangement) {
        Stack<Integer> s = new Stack();
        int answer = 0;
        for (int i = 0; i < arrangement.length(); i++) {
            char oper = arrangement.charAt(i);
            if (oper == '(') {
                s.push(i);
            } else {
                int j = s.pop();
                if (i != j + 1) {
                    answer++;
                } else {
                    answer += s.size();
                }
            }
        }
        return answer;
    }
}