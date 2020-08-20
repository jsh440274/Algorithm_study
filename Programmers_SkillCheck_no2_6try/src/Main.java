public class Main {
    public static void main(String[] args) {
        no1 no1 = new no1();
        no2 no2 = new no2();


        String arrangement = "()(((()())(())()))(())";

        int no2res = no2.solution(arrangement);

        System.out.println(no2res);
    }
}
