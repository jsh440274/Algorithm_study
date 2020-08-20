public class Main {
    public static void main(String[] args) {
//        no1
        no1 no1 = new no1();
        int p1 = 1987;
        int p2 = 2015;
        int res1_1 = no1.solution(p1);
        System.out.println(res1_1);
        int res1_2 = no1.solution(p2);
        System.out.println(res1_2);

        //no2
        no2 no2 = new no2();
        long n1 = 4;
        long n2 = 11;
        long res2_1 = no2.solution(n1);
        System.out.println(res2_1);
        long res2_2 = no2.solution(n2);
        System.out.println(res2_2);


        //no3
        no3 no3 = new no3();
        int[][] skills = {{1, 2}, {1, 3}, {3, 6}, {3, 4}, {3, 5}};
        int tot = 121;
        int[] res3 = no3.solution(tot, skills);
        print(res3);
    }

    public static void print(int[] res) {
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
