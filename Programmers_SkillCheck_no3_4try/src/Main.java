public class Main {
    public static void main(String[] args) {
        no1 no1 = new no1();
        no2 no2 = new no2();

        String[] board1 = {"DBA", "C*A", "CDB"};
        String[] board2 = {"NRYN", "ARYA"};
        String[] board3 = {".ZI.", "M.**", "MZU.", ".IU."};
        String[] board4 = {"AB", "BA"};

        String res1_1 = no1.solution(3, 3, board1);
        String res1_2 = no1.solution(2, 4, board2);
        String res1_3 = no1.solution(4, 4, board3);
        String res1_4 = no1.solution(2, 2, board4);

        System.out.println(res1_1);
        System.out.println(res1_2);
        System.out.println(res1_3);
        System.out.println(res1_4);

        String[] oper1 = {"I 16", "D 1"};
        String[] oper2 = {"I 7", "I 5", "I -5", "D -1"};

        int[] res2_1 = no2.solution(oper1);
        int[] res2_2 = no2.solution(oper2);

        print(res2_1);
        print(res2_2);

        System.out.println();
    }

    public static void print(int[] res) {
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i] + " ");
        }
        System.out.println();
    }
}
