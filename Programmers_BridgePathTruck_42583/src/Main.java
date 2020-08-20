public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int b1 = 2;
        int b2 = 100;
        int b3 = 100;
        int w1 = 10;
        int w2 = 100;
        int w3 = 100;
        int[] t1 = {7, 4, 5, 6};
        int[] t2 = {10};
        int[] t3 = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};

        int res1 = s.solution(b1, w1, t1);
        int res2 = s.solution(b2, w2, t2);
        int res3 = s.solution(b3, w3, t3);

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}
