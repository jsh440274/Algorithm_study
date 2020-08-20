public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int n1 = 1;
        int n2 = 2;
        int n3 = 3;

        int[] res1 = s.solution(n1);
        print(res1);
        int[] res2 = s.solution(n2);
        print(res2);
        int[] res3 = s.solution(n3);
        print(res3);


    }

    public static void print(int[] res) {
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
