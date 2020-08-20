public class main {
    public static void main(String[] args) {
        no1 no1 = new no1();
        no2 no2 = new no2();

        int[][] res1 = no1.solution(2);

        int[][] routes2 = {{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}};
        int res2 = no2.solution(routes2);

        System.out.println(res1);
        System.out.println(res2);
    }
}
