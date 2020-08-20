public class Main {
    public static void main(String[] args) {
        Solution no1 = new Solution();

        int[] a1 = {5, 1, 3, 7};
        int[] b1 = {2, 2, 6, 8};
        int[] a2 = {2, 2, 2, 2};
        int[] b2 = {1, 1, 1, 1};

        int res1 = no1.solution(a1, b1);
        System.out.println(res1);
        int res2 = no1.solution(a2, b2);
        System.out.println(res2);
    }
}
