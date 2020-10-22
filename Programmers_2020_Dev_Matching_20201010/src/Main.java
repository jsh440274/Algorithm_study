public class Main {
    public static void main(String[] args) {
        //no1
        Solution1 no1 = new Solution1();

        String[] votes1 = {"AVANT", "PRIDO", "SONATE", "RAIN", "MONSTER", "GRAND", "SONATE", "AVANT", "SONATE", "RAIN", "MONSTER", "GRAND", "SONATE", "SOULFUL", "AVANT", "SANTA"};
        int k1 = 2;
        String res1 = no1.solution(votes1, k1);
        System.out.println(res1);
        String[] votes2 = {"AAD", "AAA", "AAC", "AAB"};
        int k2 = 4;
        String res2 = no1.solution(votes2, k2);
        System.out.println(res2);



//        //no2
//        Solution2 no2 = new Solution2();
//
//        String p1 = "PM 01:00:00";
//        int n1 = 10;
//        String res1 = no2.solution(p1, n1);
//        System.out.println(res1);
//        String p2 = "PM 11:59:59";
//        int n2 = 1;
//        String res2 = no2.solution(p2, n2);
//        System.out.println(res2);
//


//        //no3
//        Solution3 no3 = new Solution3();
//
//        int n1 = 10;
//        int[][] groups1 = {{1, 5}, {2, 7}, {4, 8}, {3, 6}};
//        int res1 = no3.solution(n1, groups1);
//        System.out.println(res1);
//        int n2 = 7;
//        int[][] groups2 = {{6, 7}, {1, 4}, {2, 4}};
//        int res2 = no3.solution(n2, groups2);
//        System.out.println(res2);
//        int n3 = 100;
//        int[][] groups3 = {{1, 50}, {1, 100}, {51, 100}};
//        int res3 = no3.solution(n3, groups3);
//        System.out.println(res3);


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
