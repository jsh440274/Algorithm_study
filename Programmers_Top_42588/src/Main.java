public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] n1 = {6, 9, 5, 7, 4};
        int[] n2 = {3, 9, 9, 3, 5, 7, 2};
        int[] n3 = {1, 5, 3, 6, 7, 6, 5};

        int[] res1 = s.solution(n1);
        int[] res2 = s.solution(n2);
        int[] res3 = s.solution(n3);

        print(res1);
        print(res2);
        print(res3);
    }

    public static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
