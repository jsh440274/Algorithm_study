public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] p1 = {93, 30, 55};
        int[] s1 = {1, 30, 5};
        int[] ans = s.solution(p1, s1);

        print(ans);
    }

    public static void print(int[] asn) {
        for (int i = 0; i < asn.length; i++) {
            System.out.print(asn[i] + " ");
        }
        System.out.println();
    }
}
