public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        String str1_1 = "FRANCE";
        String str1_2 = "handshake";
        String str1_3 = "aa1+aa2";
        String str1_4 = "E=M*C^2";
        String str2_1 = "french";
        String str2_2 = "shake hands";
        String str2_3 = "AAAA12";
        String str2_4 = "e=m*c^2";

        int res1 = s.solution(str1_1, str2_1);
        System.out.println(res1);
        int res2 = s.solution(str1_2, str2_2);
        System.out.println(res2);
        int res3 = s.solution(str1_3, str2_3);
        System.out.println(res3);
        int res4 = s.solution(str1_4, str2_4);
        System.out.println(res4);

    }
}
