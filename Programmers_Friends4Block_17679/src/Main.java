public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int m1 = 4;
        int m2 = 6;
        int n1 = 5;
        int n2 = 6;
        String[] board1 = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        String[] board2 = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        int res1 = s.solution(m1, n1, board1);
        System.out.println(res1);
        int res2 = s.solution(m2, n2, board2);
        System.out.println(res2);
    }
}
