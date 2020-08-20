import java.io.*;

public class Main6 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] split = input.split(",");
        int n = Integer.parseInt(split[0].trim());
        int m = Integer.parseInt(split[1].trim());
        int k = Integer.parseInt(split[2].trim());

        long output = calculate(n, m, k);

        System.out.println("총 " + output + "가지");
    }

    // 아래 함수를 구현해주세요
    private static long calculate(int n, int m, int k) {
        if (k < 0) {
            return 0;
        }
        if (n == 0 && m == 0) {
            return 1;
        } else {
            long ret = 0;
            if (n > 0) {
                ret += calculate(n - 1, m, k + 1);
            }
            if (m > 0) {
                ret += calculate(n, m - 1, k - 1);
            }
            return ret;
        }
    }
}