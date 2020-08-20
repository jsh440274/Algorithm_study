public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a1 = {1, 4, 2};
        int[] a2 = {1,2};
        int[] b1 = {5, 4, 4};
        int[] b2 = {3,4};
        int res1 = s.solution(a1, b1);
        int res2 = s.solution(a2, b2);
        System.out.println(res1);
    }
}
