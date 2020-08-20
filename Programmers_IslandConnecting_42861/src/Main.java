public class Main {
    public static void main(String[] args) {
        Solution no1 = new Solution();

        int n = 4;
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};

        int res = no1.solution(n, costs);
        System.out.println(res);
    }
}
