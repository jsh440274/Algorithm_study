public class Main {
    public static void main(String[] args) {
        no1 no1 = new no1();
        no2 no2 = new no2();

//        int[] h1 = {6, 9, 5, 7, 4};
//        int[] h2 = {3, 9, 9, 3, 5, 7, 2};
//        int[] h3 = {1, 5, 3, 6, 7, 6, 5};
//
//        int[] r1 = no2.solution(h1);
//        int[] r2 = no2.solution(h2);
//        int[] r3 = no2.solution(h3);
//
//        for (int i = 0; i < r1.length; i++) {
//            System.out.print(r1[i] + " ");
//        }
//        System.out.println();
//        for (int i = 0; i < r2.length; i++) {
//            System.out.print(r2[i] + " ");
//        }
//        System.out.println();
//        for (int i = 0; i < r3.length; i++) {
//            System.out.print(r3[i] + " ");
//        }
//        System.out.println();

        int [][] board1 = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
        int [][] board2 = {{0,0,1,1},{1,1,1,1}};

        int r3 = no1.solution(board1);
        int r4 = no1.solution(board2);

        System.out.println(r3);
        System.out.println(r4);
    }
}
