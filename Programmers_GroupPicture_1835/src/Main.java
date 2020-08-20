public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n1 = 2;
        String[] s1 = {"N~F=0", "R~T>2"};
        int n2 = 2;
        String[] s2 = {"M~C<2", "C~M>1"};
        int res1 = s.solution(n1, s1);
        int res2 = s.solution(n2, s2);
        System.out.println(res1);
        System.out.println(res2);
    }
}
