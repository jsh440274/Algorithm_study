public class Main {
    public static void main(String[] args) {
        no1 no1 = new no1();
        no2 no2 = new no2();
        no3 no3 = new no3();
        no4 no4 = new no4();

        String[] s1 = {"2019/01/01 5000", "2019/01/20 15000", "2019/02/09 90000"};
        String[] s2 = {"2019/01/30 5000", "2019/04/05 10000", "2019/06/10 20000", "2019/08/15 50000", "2019/12/01 100000"};
        int[] res1_1 = no1.solution(s1);
        print(res1_1);
        int[] res1_2 = no1.solution(s2);
        print(res1_2);

//        String[] id1 = {"5.5.5.5", "155.123.124.111", "10.16.125.0", "155.123.124.111", "5.5.5.5", "155.123.124.111", "10.16.125.0", "10.16.125.0"};
//        String[] id2 = {"7.124.10.0", "7.124.10.0", "0.0.0.0", "7.124.10.0", "0.0.0.0", "7.124.10.0"};
//        String[] lang1 = {"Java", "C++", "Python3", "C#", "Java", "C", "Python3", "JavaScript"};
//        String[] lang2 = {"C++", "Java", "C#", "C#", "C", "Python3"};
//        int[] score1 = {294, 197, 373, 45, 294, 62, 373, 373};
//        int[] score2 = {314, 225, 45, 0, 155, 400};
//        int res2_1 = no2.solution(id1, lang1, score1);
//        System.out.println(res2_1);
//        int res2_2 = no2.solution(id2, lang2, score2);
//        System.out.println(res2_2);

//        String[] reges1 = {"card", "ace13", "ace16", "banker", "ace17", "ace14"};
//        String[] reges2 = {"cow", "cow1", "cow2", "cow3", "cow4", "cow9", "cow8", "cow7", "cow6", "cow5"};
//        String[] reges3 = {"bird99", "bird98", "bird101", "gotoxy"};
//        String[] reges4 = {"apple1", "orange", "banana3"};
//
//        String newid1 = "ace15";
//        String newid2 = "cow";
//        String newid3 = "bird98";
//        String newid4 = "apple";
//
//        String res3_1 = no3.solution(reges1, newid1);
//        System.out.println(res3_1);
//        String res3_2 = no3.solution(reges2, newid2);
//        System.out.println(res3_2);
//        String res3_3 = no3.solution(reges3, newid3);
//        System.out.println(res3_3);
//        String res3_4 = no3.solution(reges4, newid4);
//        System.out.println(res3_4);


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
