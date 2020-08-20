public class Main {
    public static void main(String[] args) {
        Solution no1 = new Solution();

        String s1 = "abcdcba";
        String s2 = "abacde";
        String s3 = "abbbba";
        int res1 = no1.solution(s1);
        System.out.println(res1);
        int res2 = no1.solution(s2);
        System.out.println(res2);
        int res3 = no1.solution(s3);
        System.out.println(res3);
    }
}
