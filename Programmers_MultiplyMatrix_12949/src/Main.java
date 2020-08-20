public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] a1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] a2 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};

        int[][] b1 = {{3, 3}, {3, 3}};
        int[][] b2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};

        int[][] res1 = s.solution(a1, b1);
        int[][] res2 = s.solution(a2, b2);

        print(res1);
        print(res2);
    }

    public static void print(int[][] res) {
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
