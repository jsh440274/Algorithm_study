public class main {
    public static void main(String[] args) {
        Solution s = new Solution();

        String msg1 = "KAKAO";
        String msg2 = "TOBEORNOTTOBEORTOBEORNOT";
        String msg3 = "ABABABABABABABAB";

        int[] res1 = s.solution(msg1);
        print(res1);
        int[] res2 = s.solution(msg2);
        print(res2);
        int[] res3 = s.solution(msg3);
        print(res3);
    }

    public static void print(int[] res) {
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
