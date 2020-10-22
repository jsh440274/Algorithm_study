
public class Solution3 {

    public long[] numbers = {0, 0, 1, 1, 1, 3, 3, 1};
    public long answer;

    public long Solution(int k) {

        answer = 0;
        matching(k, 1);

        return answer;
    }

    public void matching(int k, long temp) {
        if (k == 0) {
            answer += temp;
            return;
        } else {
            for (int i = 2; i < 8; i++) {
                //temp==0 일때 첫째자리수. i == 6일때 0이 포함됨. 맨 처음에 0이 올 수 있는지 예외처리해야함.
                if (temp == 0 && i == 6) {
                    //남은게 6이면 그냥 한자리수로밖에 못만드니까 0을 포함해줘야함.
                    if (k != 6) {
                        matching(k - i, temp * 2);
                    } else {
                        matching(k - i, temp * 3);
                    }
                } else {
                    if (k >= i) {
                        matching(k - i, temp * numbers[i]);
                    }
                }
            }
        }
    }
}
//
//public class Solution3 {
//
//    public long Solution(int k) {
//        long[] numbers = {0, 0, 0, 1, 1, 1, 3, 3, 1};
//        long answer = 0;
//        long[] dp = new long[k + 1];
//
//        for (int j = 0; j < 8; j++) {
//            dp[j] = numbers[j];
//        }
//        for (int i = 8; i < k; i++) {
//            dp[i] = dp[i - 1] + numbers[i % 8];
//        }
//
//        answer = dp[k - 1];
//        return answer;
//    }
//}
