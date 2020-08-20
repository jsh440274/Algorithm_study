import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        no1 no1 = new no1();
//        int answer = no1.solution(n,m);
//        System.out.println(answer);

//        int[] people1 = {2, 3};
//        int[] tshirts1 = {1, 2, 3};
//        int[] people2 = {1, 2, 3};
//        int[] tshirts2 = {1, 1};
//        no2 no2 = new no2();
//        int answer1 = no2.solution(people1,tshirts1);
//        int answer2 = no2.solution(people2,tshirts2);
//        System.out.println(answer1);
//        System.out.println(answer2);

//        int[] grade1 = {5,3,1};
//        int max_diff1 = 1;
//        int[] grade2 = {4,1,3,5};
//        int max_diff2 = 2;
//        no3 no3 = new no3();
//        int answer1 = no3.solution(grade1, max_diff1);
//        int answer2 = no3.solution(grade2, max_diff2);
//        System.out.println(answer1);
//        System.out.println(answer2);

        int N1 = 5;
        int[][] directory1 = {{1, 2}, {1, 3}, {2, 4}, {2, 5}};
        int[][] query1 = {{1, 5}, {2, 5}, {3, 5}, {4, 5}};
        int N2 = 4;
        int[][] directory2 = {{3, 2}, {3, 1}, {3, 4}};
        int[][] query2 = {{4, 2}, {3, 1}, {2, 2}};
        no4 no4 = new no4();
        int[] answer1 = no4.solution(N1, directory1, query1);
        int[] answer2 = no4.solution(N2, directory2, query2);
        for (int i = 0; i < answer1.length; i++) {
            System.out.println(answer1[i] + ", ");
        }
        for (int i = 0; i < answer2.length; i++) {
            System.out.println(answer2[i] + ", ");
        }

    }
}
