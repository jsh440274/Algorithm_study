import java.util.Scanner;
import java.io.FileInputStream;

class Solution {

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int[] ticket = new int[4];
            int[] month = new int[13];
            int[] dp = new int[13];
            for (int i = 0; i < 4; i++) {
                ticket[i] = sc.nextInt();
            }
            for (int i = 1; i < 13; i++) {
                month[i] = Math.min(sc.nextInt() * ticket[0], ticket[1]);
            }

            for (int i = 1; i < 13; i++) {
                dp[i] = dp[i - 1] + month[i];
                if (i >= 3) {
                    dp[i] = Math.min(dp[i], dp[i - 3] + ticket[2]);
                }
            }
            int anwer = Math.min(ticket[3], dp[12]);
            System.out.println(anwer);
        }
    }
}