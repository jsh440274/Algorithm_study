public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        String s1 = "aabbaccc";
        String s2 = "ababcdcdababcdcd";
        String s3 = "abcabcdede";
        String s4 = "abcabcabcabcdededededede";
        String s5 = "xababcdcdababcdcd";

        int res1 = s.solution(s1);
        int res2 = s.solution(s2);
        int res3 = s.solution(s3);
        int res4 = s.solution(s4);
        int res5 = s.solution(s5);

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        System.out.println(res4);
        System.out.println(res5);
    }
}
