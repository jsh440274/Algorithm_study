public class Main {
    public static void main(String[] args) {
        //no1
//        Solution1 no1 = new Solution1();
//        String s1 = "aabab";
//        int ret1 = no1.solution(s1);
//        System.out.println(ret1);
//        String s2 = "dog";
//        int ret2 = no1.solution(s2);
//        System.out.println(ret2);
//        String s3 = "aaa";
//        int ret3 = no1.solution(s3);
//        System.out.println(ret3);
//        String s4 = "aa";
//        int ret4 = no1.solution(s4);
//        System.out.println(ret4);

        //no2
//        Solution2 no2 = new Solution2();
//        String[] S1 = {"abc", "bca", "dbe"};
//        int[] ret1 = no2.solution(S1);
//        print(ret1);
//        String[] S2 = {"zzzz", "ferz", "zdsr", "fgtd"};
//        int[] ret2 = no2.solution(S2);
//        print(ret2);
//        String[] S3 = {"gr", "sd", "rg"};
//        int[] ret3 = no2.solution(S3);
//        print(ret3);
//        String[] S4 = {"bdafg", "ceagi"};
//        int[] ret4 = no2.solution(S4);
//        print(ret4);

        //no3
        Solution3 no3 = new Solution3();

        int[] A1 = {1, 2, 1};
        int res1 = no3.solution(A1);
        System.out.println(res1);
        int[] A2 = {2, 1, 4, 4};
        int res2 = no3.solution(A2);
        System.out.println(res2);
        int[] A3 = {6, 2, 3, 5, 6, 3};
        int res3 = no3.solution(A3);
        System.out.println(res3);
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
