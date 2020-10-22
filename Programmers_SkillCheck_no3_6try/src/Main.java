public class Main {
    public static void main(String[] args) {
        //no1
        Solution1 no1 = new Solution1();
        int n = 5;
        int[] money = {1, 2, 5};
        int res = no1.solution(n, money);
        System.out.println(res);


//        //no2
//        Solution2 no2 = new Solution2();
//        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
//        int res2 = no2.solution(jobs);
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
