public class Main {
    public static void main(String[] args) {
        Solution no1 = new Solution();

        int n1 = 3;
        int m1 = 3;
        int n2 = 6;
        int m2 = 3;
        int[][] citymap1 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int[][] citymap2 = {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};

        int res1 = no1.solution(m1, n1, citymap1);
        System.out.println(res1);
        int res2 = no1.solution(m2, n2, citymap2);
        System.out.println(res2);
    }
}
