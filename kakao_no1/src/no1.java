import java.util.Stack;

public class no1 {
    public int solution(int[][] board, int[] moves) {
        int result = 0;
        Stack<Integer> stack = new Stack();
        int[] top = new int[board.length];

        for (int i = 0; i < top.length; i++) {
            int j = 0;
            while (board[j][i] == 0) {
                j++;
            }
            top[i] = j;
        }

        for (int i = 0; i < moves.length; i++) {
            int k = moves[i] - 1;
            if (top[k] == board.length) {
                continue;
            } else {
                int popped = board[top[k]][k];
                if (!stack.isEmpty() && stack.peek() == popped) {
                    result += 2;
                    stack.pop();
                } else {
                    stack.push(popped);
                }
                top[k]++;
            }
        }
        return result;
    }
}
