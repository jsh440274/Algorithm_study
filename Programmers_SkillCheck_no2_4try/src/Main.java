public class Main {
    public static void main(String[] args) {
        no1 no1 = new no1();
        no2 no2 = new no2();

        String[][] clothes1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int result1 = no1.solution(clothes1);
        System.out.println(result1);
        String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        int result2 = no1.solution(clothes2);
        System.out.println(result2);

        int stock1 = 4;
        int[] date1 = {4, 10, 15};
        int[] supplies1 = {20, 5, 10};
        int k1 = 30;
        int result = no2.solution(stock1, date1, supplies1, k1);

        System.out.println(result);
    }
}
