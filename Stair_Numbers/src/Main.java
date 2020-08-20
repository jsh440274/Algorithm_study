import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[10];

        dp[0] = 0;

        for (int i = 1; i < 10; i++) {
            dp[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            int temp_0 = dp[1];
            int temp_9 = dp[8];
            int temp = dp[0];
            for (int j = 1; j < 9; j++) {
                int temp_ = dp[j];
                dp[j] = (temp + dp[j + 1]) % 1000000000;
                temp = temp_;
            }
            dp[0] = temp_0 % 1000000000;
            dp[9] = temp_9 % 1000000000;
        }

        int sum = 0;

        for (int i = 0; i < 10; i++) {
            sum = (sum + dp[i]) % 1000000000;
        }

        System.out.println(sum);
    }
}