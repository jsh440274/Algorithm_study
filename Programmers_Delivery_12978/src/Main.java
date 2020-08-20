public class Main {
    public static void main(String[] args) {
        Solution no1 = new Solution();
        int n1 = 5;
        int n2 = 6;

        int[][] m1 = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
        int[][] m2 = {{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}};
        int k1 = 3;
        int k2 = 4;

        int res1 = no1.solution(n1, m1, k1);
        System.out.println(res1);
        int res2 = no1.solution(n2, m2, k2);
        System.out.println(res2);
    }
}
