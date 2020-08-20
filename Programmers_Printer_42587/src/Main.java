public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] p1 = {2, 1, 3, 2};
        int[] p2 = {1, 1, 9, 1, 1, 1};
        int l1 = 2;
        int l2 = 0;

        int res1 = s.solution(p1, l1);
        int res2 = s.solution(p2, l2);

        System.out.println(res1);
        System.out.println(res2);
    }
}
