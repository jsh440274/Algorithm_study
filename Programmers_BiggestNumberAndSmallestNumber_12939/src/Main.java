public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "1 2 3 4";
        String s2 = "-1 -2 -3 -4";
        String s3 = "-1 -1";
        String res1 = s.solution(s1);
        String res2 = s.solution(s2);
        String res3 = s.solution(s3);
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
