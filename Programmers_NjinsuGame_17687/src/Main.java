public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n1 = 2;
        int t1 = 4;
        int m1 = 2;
        int p1 = 1;
        int n2 = 16;
        int t2 = 16;
        int m2 = 2;
        int p2 = 1;
        int n3 = 16;
        int t3 = 16;
        int m3 = 2;
        int p3 = 2;
        String res1 = s.solution(n1, t1, m1, p1);
        System.out.println(res1);
        String res2 = s.solution(n2, t2, m2, p2);
        System.out.println(res2);
        String res3 = s.solution(n3, t3, m3, p3);
        System.out.println(res3);
    }
}
