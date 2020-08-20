public class Mfain {
    public static void main(String[] args) {
        Solution s = new Solution();

        int stock = 4;
        int[] date = {4, 10, 15};
        int[] supply = {20, 5, 10};
        int k = 30;
        int res = s.solution(stock, date, supply, k);


        System.out.println(res);
    }

}
