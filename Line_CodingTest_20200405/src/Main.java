public class Main {
    public static void main(String[] args) {
//        no1 no1 = new no1();
//        String string1 = "Hello, world!";
//        int res1_1 = no1.solution(string1);
//        System.out.println(res1_1);
//        String string2 = "line [plus]";
//        int res1_2 = no1.solution(string2);
//        System.out.println(res1_2);
//        String string3 = "if (Count of eggs is 4.) {Buy milk.}";
//        int res1_3 = no1.solution(string3);
//        System.out.println(res1_3);
//        String string4 = ">_<";
//        int res1_4 = no1.solution(string4);
//        System.out.println(res1_4);


        no2 no2 = new no2();
        String ans1 = "4132315142";
        String[] a1 = {"3241523133", "4121314445", "3243523133", "4433325251", "2412313253"};
        int res2_1 = no2.solution(ans1, a1);
        System.out.println(res2_1);
        String ans2 = "53241";
        String[] a2 = {"53241", "42133", "53241", "14354"};
        int res2_2 = no2.solution(ans2, a2);
        System.out.println(res2_2);
        String ans3 = "24551";
        String[] a3 = {"24553", "24553", "24553", "24553"};
        int res2_3 = no2.solution(ans3, a3);
        System.out.println(res2_3);


//        no3 no3 = new no3();
//        String a1 = "111011110011111011111100011111";
//        String a2 = "001100";
//        int b1 = 3;
//        int b2 = 5;
//        int res3_1 = no3.solution(a1, b1);
//        int res3_2 = no3.solution(a2, b2);
//
//        System.out.println(res3_1);
//        System.out.println(res3_2);


//        no4 no4 = new no4();
//        String b[][] = {{"ACCOUNT1", "100"},
//                {"ACCOUNT2", "150"}};
//
//        String t[][] = {{"1", "SAVE", "ACCOUNT2", "100"},
//                {"2", "WITHDRAW", "ACCOUNT1", "50"},
//                {"1", "SAVE", "ACCOUNT2", "100"},
//                {"4", "SAVE", "ACCOUNT3", "500"},
//                {"3", "WITHDRAW", "ACCOUNT2", "30"}};
//
//        String[][] ans = no4.solution(b, t);
//
//        print(ans);


//        no5 no5 = new no5();
//        String[][] ds = {
//                {"doc1", "t1", "t2", "t3"},
//                {"doc2", "t0", "t2", "t3"},
//                {"doc3", "t1", "t6", "t7"},
//                {"doc4", "t1", "t2", "t4"},
//                {"doc5", "t6", "t100", "t8"}};
//
//        String t[] = {"t1", "t2", "t3"};
//        String id[] = no5.solution(ds, t);
//        print(id);


//        int[] = {};
//        String[] = {};

//        res2_ = s.solution();
//        res3_ = s.solution();
//        res4_ = s.solution();
//        res5_ = s.solution();
//        res6_ = s.solution();


//        no6 no6 = new no6();
//        String[] dictionary = {
//                "/",
//                "/hello",
//                "/hello/tmp",
//                "/root",
//                "/root/abcd",
//                "/root/abcd/etc",
//                "/root/abcd/hello"};
//        String[] command = {
//                "mkdir /root/tmp",
//                "cp /hello /root/tmp",
//                "rm /hello"};
//        String[] answer = no6.solution(dictionary, command);
//        print(answer);
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

    public static void print(long[] res) {
        for (long i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void print(double[] res) {
        for (double i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void print(String[][] res) {
        for (String[] i : res) {
            for (String j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
