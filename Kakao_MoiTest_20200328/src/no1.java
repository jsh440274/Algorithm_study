import java.util.Stack;

public class no1 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> s = new Stack<>();
        Stack<Integer>[] maps = new Stack[board[0].length];

        for (int i = 0; i < board[0].length; i++) {
            Stack<Integer> temp = new Stack<>();
            maps[i] = temp;
        }
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != 0) {
                    maps[j].push(board[i][j]);
                }
            }
        }

        for (int i = 0; i < moves.length; i++) {
            if (!maps[moves[i] - 1].isEmpty()) {
                int popped = maps[moves[i] - 1].pop();
                if (!s.isEmpty() && s.peek() == popped) {
                    s.pop();
                    answer += 2;
                } else {
                    s.push(popped);
                }
            }
        }

        return answer;
    }
}
