public class Main {
    public static void main(String[] args) {
        Solution no1 = new Solution();


        int n1 = 3;
        int n2 = 3;

        int[][] com1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] com2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        int ret1 = no1.solution(n1, com1);
        System.out.println(ret1);
        int ret2 = no1.solution(n2, com2);
        System.out.println(ret2);
    }
}
