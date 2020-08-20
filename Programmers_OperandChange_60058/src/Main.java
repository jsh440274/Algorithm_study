public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        String p1 = "(()())()";
        String res1 = s.solution(p1);
        System.out.println(res1);
        String p2 = ")(";
        String res2 = s.solution(p2);
        System.out.println(res2);
        String p3 = "()))((()";
        String res3 = s.solution(p3);
        System.out.println(res3);
    }
}
