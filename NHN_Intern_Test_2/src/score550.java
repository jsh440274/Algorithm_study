import java.util.Scanner;

public class score550 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] dp = new String[80];
        for (int i = 0; i < 80; i++) {
            dp[i] = "";
        }
        dp[0] = "1";

        for (int i = 1; i < n; i++) {
            String prev = dp[i - 1];
            char num = prev.charAt(0);
            int count = 0;
            for (int j = 0; j < prev.length(); j++) {
                char compareing = prev.charAt(j);
                if (compareing == num) {
                    count++;
                } else {
                    dp[i] += Character.toString(num) + Integer.toString(count);
                    count = 1;
                    num = compareing;
                }
            }
            dp[i] += Character.toString(num) + Integer.toString(count);
        }

        int result = 0;
        for (int i = 0; i < dp[n - 1].length(); i++) {
            if (dp[n - 1].charAt(i) == '1') {
                result++;
            }
        }
        System.out.println(result);
    }
}
