public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] p = {1, 2, 3, 2, 3};
        int[] ans = s.solution(p);

        print(ans);

    }

    public static void print(int[] p) {
        for (int i = 0; i < p.length; i++) {
            System.out.print(p[i] + " ");
        }
        System.out.println();
    }
}
