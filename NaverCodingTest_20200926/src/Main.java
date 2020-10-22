public class Main {
    public static void main(String[] args) {
        //no1
//        Solution1 no1 = new Solution1();
//
//        int n1 = 6;
//        int[] p1 = {5, 4, 7, 2, 0, 6};
//        int[] c1 = {4, 6, 4, 9, 2, 3};
//        String ret1 = no1.Solution(n1, p1, c1);
//        System.out.println(ret1);
//
//        int n2 = 7;
//        int[] p2 = {6, 2, 1, 0, 2, 4, 3};
//        int[] c2 = {3, 6, 6, 2, 3, 7, 6};
//        String ret2 = no1.Solution(n2, p2, c2);
//        System.out.println(ret2);


//        //no2
//        Solution2 no2 = new Solution2();
//
//        int n = 9;
//        int[][] edge = {{0, 2}, {2, 1}, {2, 4}, {3, 5}, {5, 4}, {5, 7}, {7, 6}, {6, 8}};
//        int[] res = no2.Solution(n, edge);
//        print(res);

        //no3
        Solution3 no3 = new Solution3();

        int n1 = 5;
        long res1 = no3.Solution(n1);
        System.out.println(res1);
        int n2 = 6;
        long res2 = no3.Solution(n2);
        System.out.println(res2);
        int n3 = 11;
        long res3 = no3.Solution(n3);
        System.out.println(res3);
        int n4 = 1;
        long res4 = no3.Solution(n4);
        System.out.println(res4);
        int n5 = 8;
        long res5 = no3.Solution(n5);
        System.out.println(res5);


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
