public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int brown1 = 10;
        int red1 = 2;
        int[] res1 = s.solution(brown1, red1);
        int brown2 = 8;
        int red2 = 1;
        int[] res2 = s.solution(brown2, red2);
        int brown3 = 24;
        int red3 = 24;
        int[] res3 = s.solution(brown3, red3);

        print(res1);
        print(res2);
        print(res3);
    }

    public static void print(int[] res) {
        for (int ans : res) {
            System.out.print(ans + " ");
        }
        System.out.println();
    }
}
