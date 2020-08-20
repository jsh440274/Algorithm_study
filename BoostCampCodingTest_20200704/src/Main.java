public class Main {
    public static void main(String[] args) {
        Solution1 no1 = new Solution1();
        Solution2 no2 = new Solution2();
        int A[] = {2, 3, 4, 5};
        int B[] = {1, 6, 7};
        no2.solution(A, B);

//        String a[] = {"ab", "cd", "ef"};
//        boolean res1 = no1.solution(a);
//        System.out.println(res1);
        String b[] = {"a", "bc", "aa"};
        boolean res2 = no1.solution(b);
        System.out.println(res2);
        String c[] = {"ab", "ac", "dc", "ec"};
        boolean res3 = no1.solution(c);
        System.out.println(res3);
    }

    public static void print(int[] res) {
        for (int i : res) {
            System.out.println(i + " ");
        }
        System.out.println();
    }

    public static void print(int[][] res) {
        for (int[] i : res) {
            System.out.println("{");
            for (int j : i) {
                System.out.println(j + ",");
            }
            System.out.println("},");
        }
    }
}