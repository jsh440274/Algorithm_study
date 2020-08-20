import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Solution no1 = new Solution();

        int[][] key1 = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock1 = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        boolean res1 = no1.solution(key1, lock1);
        System.out.println(res1);
    }
}
