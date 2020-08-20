public class Main {
    public static void main(String[] args) {
        Solution no1 = new Solution();

        int n1 = 2;
        int s1 = 9;
        int[] res1 = no1.solution(n1, s1);
        print(res1);
        int n2 = 2;
        int s2 = 1;
        int[] res2 = no1.solution(n2, s2);
        print(res2);
        int n3 = 2;
        int s3 = 8;
        int[] res3 = no1.solution(n3, s3);
        print(res3);

    }

    public static void print(int[] res) {
        for (int i : res) {
            System.out.println(i + " ");
        }
        System.out.println();
    }
}
