import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (stack.isEmpty() || stack.peek() != x) {
                stack.push(x);
            } else {
                stack.pop();
            }
        }

        if (stack.isEmpty()) return 1;
        return 0;
    }
}