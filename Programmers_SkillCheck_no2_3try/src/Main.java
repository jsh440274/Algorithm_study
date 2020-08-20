public class Main {
    public static void main(String[] args) {
        no1 no1 = new no1();
        no2 no2 = new no2();

        int[] people1 = {70, 50, 80, 50};
        int[] people2 = {70, 80, 50};

        int limit1 = 100;
        int limit2 = 100;

        int result1 = no2.solution(people1, limit1);
        int result2 = no2.solution(people2, limit2);

        System.out.println(result1);
        System.out.println(result2);

        String str1 = "()()";
        String str2 = "(())()";
        String str3 = "(()(";

        boolean rewult1 = no1.solution(str1);
        boolean rewult2 = no1.solution(str2);
        boolean rewult3 = no1.solution(str3);

        System.out.println(rewult1);
        System.out.println(rewult2);
        System.out.println(rewult3);

    }
}
