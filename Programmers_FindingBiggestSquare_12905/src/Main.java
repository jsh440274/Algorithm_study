public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] board1 = {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};
        int res1 = s.solution(board1);
        System.out.println(res1);

        int[][] board2 = {{0, 0, 1, 1}, {1, 1, 1, 1}};
        int res2 = s.solution(board2);
        System.out.println(res2);
    }
}
