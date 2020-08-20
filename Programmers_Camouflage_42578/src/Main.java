public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        String clothes1[][] = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int res1 = s.solution(clothes1);
        System.out.println(res1);

        String clothes2[][] = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        int res2 = s.solution(clothes2);
        System.out.println(res2);

    }
}