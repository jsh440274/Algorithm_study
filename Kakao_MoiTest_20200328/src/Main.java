public class Main {
    public static void main(String[] args) {

//        no1 no1 = new no1();
//        int[][] a1 = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
//        int[] m = {1, 5, 3, 5, 1, 2, 1, 4};
//        int res1 = no1.solution(a1, m);
//        System.out.println(res1);

//        no2 no2 = new no2();
//        String s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
//        String s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
//        String s3 = "{{20,111},{111}}";
//        String s4 = "{{123}}";
//        String s5 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
//        int[] res2_1 = no2.solution(s1);
//        print(res2_1);
//        int[] res2_2 = no2.solution(s2);
//        print(res2_2);
//        int[] res2_3 = no2.solution(s3);
//        print(res2_3);
//        int[] res2_4 = no2.solution(s4);
//        print(res2_4);
//        int[] res2_5 = no2.solution(s5);
//        print(res2_5);

//        no3 no3 = new no3();
//        String bi1[] = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
//        String ui1[] = {"fr*d*", "abc1**"};
//        int res3_1 = no3.solution(bi1, ui1);
//        String bi2[] = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
//        String ui2[] = {"*rodo", "*rodo", "******"};
//        int res3_2 = no3.solution(bi2, ui2);
//        String bi3[] = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
//        String ui3[] = {"fr*d*", "*rodo", "******", "******"};
//        int res3_3 = no3.solution(bi3, ui3);
//        System.out.println(res3_1);
//        System.out.println(res3_2);
//        System.out.println(res3_3);


//        no4 no4 = new no4();
//        long k = 10;
//        long[] rn = {1, 3, 4, 1, 3, 1};
//        long[] res4 = no4.solution(k, rn);
//        print(res4);

        no5 no5 = new no5();
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        int res5 = no5.solution(stones, k);
        System.out.println(res5);


    }

    public static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void print(long[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
