public class Main {
    public static void main(String[] args) {
        no1 no1 = new no1();
        no2 no2 = new no2();

        int[] arr1 = {2,6,8,14};
        int[] arr2 = {1,2,3};

        int res1 = no2.solution(arr1);
        int res2 = no2.solution(arr2);

        System.out.println(res1);
        System.out.println(res2);

        String a1 = "()()";
        String a2 = "(())()";
        String a3 = ")()(";
        String a4 = "(()(";

        boolean b1 = no1.solution(a1);
        boolean b2 = no1.solution(a2);
        boolean b3 = no1.solution(a3);
        boolean b4 = no1.solution(a4);

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
    }
}
