public class Main {
    public static void main(String[] args) {
        no1 no1 = new no1();
        no2 no2 = new no2();

        int n1 = 11;
        int[] st1 = {4, 11};
        int w1 = 1;

        int w2 = 2;
        int[] st2 = {9};
        int n2 = 16;

        int res1 = no1.solution(n1, st1, w1);
        int res2 = no1.solution(n2, st2, w2);

        System.out.println(res1);
        System.out.println(res2);

//        int n1 = 12;
//        int n2 = 12;
//
//        int[] weak1 = {1, 5, 6, 10};
//        int[] weak2 = {1, 3, 4, 9, 10};
//
//        int[] dist1 = {1, 2, 3, 4};
//        int[] dist2 = {3, 5, 7};
//
//        int res1 = no2.solution(n1, weak1, dist1);
//        int res2 = no2.solution(n2, weak2, dist2);
//
//        System.out.println(res1);
//        System.out.println(res2);


    }
}
