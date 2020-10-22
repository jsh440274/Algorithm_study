public class Main {
    public static void main(String[] args) {
//        //no1
//        Solution1 no1 = new Solution1();
//
//        int[] numbers1 = {2, 1, 3, 4, 1};
//        int[] res1 = no1.solution(numbers1);
//        print(res1);
//
//        int[] numbers2 = {5, 0, 2, 7};
//        int[] res2 = no1.solution(numbers2);
//        print(res2);

//        //no2
//        Solution2 no2 = new Solution2();
//        int n1 = 4;
//        int[] res1 = no2.solution(n1);
//        print(res1);
//        int n2 = 5;
//        int[] res2 = no2.solution(n2);
//        print(res2);
//        int n3 = 6;
//        int[] res3 = no2.solution(n3);
//        print(res3);

        //no3
        Solution3 no3 = new Solution3();
        int[] a1 = {9, -1, -5};
        int res1 = no3.solution(a1);
        System.out.println(res1);

        int[] a2 = {-16, 27, 65, -2, 58, -92, -71, -68, -61, -33};
        int res2 = no3.solution(a2);
        System.out.println(res2);

//        //no4
//        Solution4 no4 = new Solution4();
//        int[][] b1 = {{0, 1, 0}, {1, 1, 1}, {1, 1, 0}, {0, 1, 1}};
//        int res1 = no4.solution(b1);
//        System.out.println(res1);
//        int[][] b2 = {{1, 0, 0}, {1, 0, 0}};
//        int res2 = no4.solution(b2);
//        System.out.println(res2);
//        int[][] b3 = {{1, 0, 0, 1, 1}, {0, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 0, 1}};
//        int res3 = no4.solution(b3);
//        System.out.println(res3);

    }

    public static void print(int[] res) {
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void print(int[][] res) {
        StringBuilder sb = new StringBuilder();
        for (int[] i : res) {
            sb.append("{");
            for (int j : i) {
                sb.append(j + ",");
            }
            sb.append("},");
        }
        sb.substring(0, sb.length() - 1);
        System.out.println(sb.toString());
    }
}
