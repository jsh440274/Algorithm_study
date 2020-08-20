import java.util.Stack;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> s = new Stack();
        int full = prices.length - 1;

        for (int i = 0; i < prices.length; i++) {
            if (!s.isEmpty()) {
                while (!s.isEmpty() && prices[s.peek()] > prices[i]) {
                    int ending = s.pop();
                    answer[ending] = i - ending;
                }
            }
            s.push(i);
        }
        while (!s.isEmpty()) {
            int temp = s.pop();
            answer[temp] = full - temp;
        }
        return answer;
    }
}