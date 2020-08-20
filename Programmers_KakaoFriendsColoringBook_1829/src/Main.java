public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] p = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int n = 4;
        int m = 6;
        int[] res = s.solution(m, n, p);
        print(res);
    }

    public static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + "  ");
        }
        System.out.println();
    }
}
