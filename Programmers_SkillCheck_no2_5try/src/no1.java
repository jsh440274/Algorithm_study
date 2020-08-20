public class no1 {
//    int[][] board;

    //    public int solution(int[][] board) {
//        int answer = 0;
//        this.board = board;
//        for (int i = 0; i < board.length; i++) {
//            int x = 1;
//            for (int j = 0; j < board[i].length; j++) {
//                if (x != 0) {
//                    --x;
//                }
//                while (x + i < board.length && x + j < board[i].length && isSquare(x, i, j)) {
//                    x++;
//                }
//                answer = Math.max(answer, x);
//            }
//        }
//        return answer * answer;
//    }
//
//    public boolean isSquare(int x, int i, int j) {
//        for (int d = 0; d <= x; d++) {
//            if (board[i + x][j + x - d] != 1 || board[i + x - d][j + x] != 1) {
//                return false;
//            }
//        }
//        if (board[i + x][j + x] != 1) {
//            return false;
//        }
//        return true;
//    }
    public int solution(int[][] board) {
        int answer = 1;
        int x = board[0].length - 1;
        int y = board.length - 1;
        for (int i = 1; i <= y; i++) {
            for (int j = 1; j <= x; j++) {
                if (board[i][j] == 1) {
                    int temp = Math.min(board[i][j - 1], board[i - 1][j - 1]);
                    temp = Math.min(board[i - 1][j], temp);
                    board[i][j] = temp + 1;
                    answer = Math.max(answer, board[i][j]);
                }
            }
        }
        return answer * answer;
    }
}
