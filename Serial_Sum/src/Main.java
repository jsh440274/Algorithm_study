import java.util.Scanner;

public class Main {
    public static int newMax(int[] nums, int index) {
        int max = nums[index];
        int temp  = 0;
        for (int i = index; i >= 0; i--) {
            temp += nums[i];
            max = Math.max(max, temp);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        int[] nums = new int[count];
        int[] dp = new int[count];

        for (int i = 0; i < count; i++) {
            nums[i] = sc.nextInt();
        }

        dp[0] = nums[0];

        for (int i = 1; i < count; i++) {
            int temp = newMax(nums, i);
            dp[i] = Math.max(dp[i-1], temp);
        }

        System.out.println(dp[dp.length-1]);
    }
}
