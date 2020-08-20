public class Main {
    public static void main(String[] args) {
        no1 no1 = new no1();
        no2 no2 = new no2();
        no3 no3 = new no3();
        no4 no4 = new no4();
        no5 no5 = new no5();


//        //no1
//        int[] nums1 = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
//        int[] nums2 = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
//        int[] nums3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
//        String hand1 = "right";
//        String hand2 = "left";
//        String hand3 = "right";
//        String res1_1 = no1.solution(nums1, hand1);
//        System.out.println(res1_1);
//        String res1_2 = no1.solution(nums2, hand2);
//        System.out.println(res1_2);
//        String res1_3 = no1.solution(nums3, hand3);
//        System.out.println(res1_3);


//        //no2
//        String exp1 = "100-200*300-500+20";
//        String exp2 = "50*6-3*2";
//        long res2_1 = no2.solution(exp1);
//        System.out.println(res2_1);
//        long res2_2 = no2.solution(exp2);
//        System.out.println(res2_2);


//        //no3
//        String games1[] = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
//        String games2[] = {"AA", "AB", "AC", "AA", "AC"};
//        String games3[] = {"XYZ", "XYZ", "XYZ"};
//        String games4[] = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
//        int[] res3_1 = no3.solution(games1);
//        print(res3_1);
//        int[] res3_2 = no3.solution(games2);
//        print(res3_2);
//        int[] res3_3 = no3.solution(games3);
//        print(res3_3);
//        int[] res3_4 = no3.solution(games4);
//        print(res3_4);


//        no4
        int[][] board1 = {{0,0,0},{0,0,0},{0,0,0}};
        int[][] board2 = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},{0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
        int[][] board3 = {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
        int[][] board4 = {{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};
        int res4_1 = no4.solution(board1);
        System.out.println(res4_1);
        int res4_2 = no4.solution(board2);
        System.out.println(res4_2);
        int res4_3 = no4.solution(board3);
        System.out.println(res4_3);
        int res4_4 = no4.solution(board4);
        System.out.println(res4_4);


        //no5

    }

    public static void print(int[] res) {
        for (int i : res) {
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
}
