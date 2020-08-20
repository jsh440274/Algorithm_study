import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] l = br.readLine().split(" ");
        int n = Integer.parseInt(l[0]);
        int s = Integer.parseInt(l[1]);
        String[] line = br.readLine().split(" ");
        long[] nums = new long[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Long.parseLong(line[i]);
        }

        int front = -1;//앞쪽 포인터
        int back = -1;//뒤쪽 포인터
        int temp = 0;//바뀐 갯수
        int ans = 100001;//실제 갯수
        long sum = 0;//s랑 비교값

        while (true) {
            if (sum < s) {
                temp++;
                back++;
                if (back >= nums.length) {
                    break;
                }
                sum += nums[back];
            } else {
                ans = Math.min(ans, temp);
                temp--;
                front++;
                if (front > back) {
                    break;
                }
                sum -= nums[front];
            }
        }
        if (ans == 1000001) {
            ans = 0;
        }

        System.out.println(ans);
    }
}
