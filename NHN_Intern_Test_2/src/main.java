import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] dp = new String[80];
        for (int i = 0; i < 80; i++) {
            dp[i] = "";
        }
        dp[0] = "1";
        int result = 0;

        for (int i = 1; i < n - 1; i++) {
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

        int count = 0;
        char num = '1';

        if (n == 1) {
            System.out.println(1);
        } else {
            for (int j = 0; j < dp[n - 2].length(); j++) {
                char compareing = dp[n - 2].charAt(j);
                if (compareing == num) {
                    count++;
                } else {
                    if (num == '1') {
                        result++;
                    }
                    while (count > 0) {
                        if (count % 10 == 1) {
                            result++;
                        }
                        count /= 10;
                    }
                    count = 1;
                    num = compareing;
                }
            }
            while (count > 0) {
                if (count % 10 == 1) {
                    result++;
                    count /= 10;
                }
            }

            System.out.println(result);
        }
    }
}
