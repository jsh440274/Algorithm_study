public class Main {
    public static void main(String[] args) {
        Solution no1 = new Solution();
        int n1 = 6;
        int[][] edge1 = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        int res1 = no1.solution(n1, edge1);
        System.out.println(res1);
    }
}
