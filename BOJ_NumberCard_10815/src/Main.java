import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    //이분탐색으로 하려고 하는 순간 이거 그냥 Set으로 쓰면 contains에서 시간복잡도 1 아닌가 하는 생각이 간단히 해결.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<Long> sang = new HashSet<>();
        String[] card = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            sang.add(Long.parseLong(card[i]));
        }

        int m = Integer.parseInt(br.readLine());

        String[] nums = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            long num = Long.parseLong(nums[i]);
            if (sang.contains(num)) {
                System.out.print("1");
            } else {
                System.out.print("0");
            }
            if (i != m - 1) {
                System.out.print(" ");
            }
        }
    }
}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//
//public class Main {
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        long[] sang = new long[n];
//        String[] card = br.readLine().split(" ");
//
//        for (int i = 0; i < n; i++) {
//            sang[i] = Long.parseLong(card[i]);
//        }
//
//        Arrays.sort(sang);
//
//        int m = Integer.parseInt(br.readLine());
//
//        String[] nums = br.readLine().split(" ");
//        for (int i = 0; i < m; i++) {
//            long num = Long.parseLong(nums[i]);
//            int start = 0;
//            int end = n;
//            boolean found = false;
//
//            while (start < end) {
//                int mid = (start + end) / 2;
//                long temp = sang[mid];
//                if (temp == num) {
//                    found = true;
//                    break;
//                } else if (temp > num) {
//                    end = mid;
//                } else {
//                    start = mid + 1;
//                }
//            }
//
//            if (found) {
//                System.out.print("1");
//            } else {
//                System.out.print("0");
//            }
//            if (i != m - 1) {
//                System.out.print(" ");
//            }
//        }
//    }
//}