public class Main {
    public static void main(String[] args) {
//        //no1
//        Solution1 no1 = new Solution1();
//        int n1 = 45;
//        int res1 = no1.solution(n1);
//        System.out.println(res1);
//        int n2 = 125;
//        int res2 = no1.solution(n2);
//        System.out.println(res2);

        //no2
//        Solution2 no2 = new Solution2();
//
//        int[][] arr1 = {{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}};
//        int[] res1 = no2.solution(arr1);
//        print(res1);
//        int[][] arr2 = {{1, 1, 1, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, {0, 1, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 1, 0, 0, 1}, {0, 0, 0, 0, 1, 1, 1, 1}};
//        int[] res2 = no2.solution(arr2);
//        print(res2);


        //no3
        Solution3 no3 = new Solution3();

        int n1 = 4;
        int[][] edges1 = {{1, 2}, {2, 3}, {3, 4}};
        int res1 = no3.solution(n1, edges1);
        System.out.println(res1);

        int n2 = 5;
        int[][] edges2 = {{1, 5}, {2, 5}, {3, 5}, {4, 5}};
        int res2 = no3.solution(n2, edges2);
        System.out.println(res2);

//        no4
//        Solution4 no4 = new Solution4();
//        String s1 = "baby";
//        long res1 = no4.solution(s1);
//        System.out.println(res1);
//
//        String s2 = "oo";
//        long res2 = no4.solution(s2);
//        System.out.println(res2);

    }

    public static void print(int[] res) {
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void print(long[] res) {
        for (long i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void print(String[] res) {
        for (String i : res) {
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

    public static void print(long[][] res) {
        StringBuilder sb = new StringBuilder();
        for (long[] i : res) {
            sb.append("{");
            for (long j : i) {
                sb.append(j + ",");
            }
            sb.append("},");
        }
        sb.substring(0, sb.length() - 1);
        System.out.println(sb.toString());
    }

    public static void print(String[][] res) {
        StringBuilder sb = new StringBuilder();
        for (String[] i : res) {
            sb.append("{");
            for (String j : i) {
                sb.append(j + ",");
            }
            sb.append("},");
        }
        sb.substring(0, sb.length() - 1);
        System.out.println(sb.toString());
    }
}
