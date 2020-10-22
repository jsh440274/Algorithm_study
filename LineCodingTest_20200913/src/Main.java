public class Main {
    public static void main(String[] args) {
//        //no1
//        Solution1 no1 = new Solution1();
//        int[][] box1 = {{1, 2}, {2, 1}, {3, 3}, {4, 5}, {5, 6}, {7, 8}};
//        int res1 = no1.solution(box1);
//        System.out.println(res1);
//        int[][] box2 = {{1, 2}, {3, 4}, {5, 6}};
//        int res2 = no1.solution(box2);
//        System.out.println(res2);
//        int[][] box3 = {{1, 2}, {2, 3}, {3, 1}};
//        int res3 = no1.solution(box3);
//        System.out.println(res3);

//        //no2
//        Solution2 no2 = new Solution2();
//
//        int[] ball1 = {1, 2, 3, 4, 5, 6};
//        int[] order1 = {6, 2, 5, 1, 4, 3};
//        int[] res1 = no2.solution(ball1, order1);
//        print(res1);
//
//        int[] ball2 = {11, 2, 9, 13, 24};
//        int[] order2 = {9, 2, 13, 24, 11};
//        int[] res2 = no2.solution(ball2, order2);
//        print(res2);


//        //no3
//        Solution3 no3 = new Solution3();
//
//        int n1 = 73425;
//        int[] res1 = no3.solution(n1);
//        print(res1);
//
//        int n2 = 10007;
//        int[] res2 = no3.solution(n2);
//        print(res2);
//
//        int n3 = 9;
//        int[] res3 = no3.solution(n3);
//        print(res3);


//        //no4
//        Solution4 no4 = new Solution4();
//
//        int[][] maze1 = {{0, 1, 0, 1}, {0, 1, 0, 0}, {0, 0, 0, 0}, {1, 0, 1, 0}};
//        int res1 = no4.solution(maze1);
//        System.out.println(res1);
//
//        int[][] maze2 = {{0, 1, 0, 0, 0, 0}, {0, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 1, 0}, {0, 1, 1, 1, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 0}};
//        int res2 = no4.solution(maze2);
//        System.out.println(res2);
//
//        int[][] maze3 = {{0, 1, 0, 0, 0, 0}, {0, 0, 1, 0, 0, 0}, {0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 0}};
//        int res3 = no4.solution(maze3);
//        System.out.println(res3);
//
//        int[][] maze4 = {{0, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 1, 1}, {0, 0, 0, 0, 0, 0}, {1, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0}, {1, 1, 0, 1, 1, 0}};
//        int res4 = no4.solution(maze4);
//        System.out.println(res4);


        //no5
//        Solution5 no5 = new Solution5();
//
//        int[] cards1 = {12, 7, 11, 6, 2, 12};
//        int ret1 = no5.solution(cards1);
//        System.out.println(ret1);
//
//        int[] cards2 = {1, 4, 10, 6, 9, 1, 8, 13};
//        int ret2 = no5.solution(cards2);
//        System.out.println(ret2);
//
//        int[] cards3 = {10, 13, 10, 1, 2, 3, 4, 5, 6, 2};
//        int ret3 = no5.solution(cards3);
//        System.out.println(ret3);
//
//        int[] cards4 = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
//        int ret4 = no5.solution(cards4);
//        System.out.println(ret4);


//        //no6
        Solution6 no6 = new Solution6();

        String[]companion1 = {"A fabdec 2", "B cebdfa 2", "C ecfadb 2"};
        String[]applicants1 = {"a BAC 1", "b BAC 3", "c BCA 2", "d ABC 3", "e BCA 3", "f ABC 2"};
        String[] ret1 = no6.solution(companion1, applicants1);
        print(ret1);

        String[]companion2 = {"A abc 2", "B abc 1"};
        String[]applicants2 = {"a AB 1", "b AB 1", "c AB 1"};
        String[] ret2 = no6.solution(companion2, applicants2);
        print(ret2);

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
