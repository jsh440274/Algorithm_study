public class Main {
    public static void main(String[] args) {
        Solution no1 = new Solution();

//        int n1 = 3;
//        int k1 = 5;
//        int[] res = no1.solution(n1, k1);
//        print(res);
        int n2 = 4;
        int k2 = 10;
        int[] res2 = no1.solution(n2, k2);
        print(res2);
    }

    public static void print(int[] res) {
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

//    public static void print(int[][] res) {
//        for (int[] i : res) {
//            System.out.println("{");
//            for (int j : i) {
//                System.out.println(j + ",");
//            }
//            System.out.println("},");
//        }
//    }
}
