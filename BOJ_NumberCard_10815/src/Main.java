//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.HashSet;
//import java.util.Set;
//
//public class Main {
//    //이분탐색으로 하려고 하는 순간 이거 그냥 Set으로 쓰면 contains에서 시간복잡도 1 아닌가 하는 생각이 간단히 해결.
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringBuffer sb = new StringBuffer();
//
//        int n = Integer.parseInt(br.readLine());
//        Set<Long> sang = new HashSet<>();
//        String[] card = br.readLine().split(" ");
//
//        for (int i = 0; i < n; i++) {
//            sang.add(Long.parseLong(card[i]));
//        }
//
//        int m = Integer.parseInt(br.readLine());
//
//        String[] nums = br.readLine().split(" ");
//        for (int i = 0; i < m; i++) {
//            long num = Long.parseLong(nums[i]);
//            if (sang.contains(num)) {
//                sb.append(1);
//            } else {
//                sb.append(0);
//            }
//            if (i != m - 1) {
//                sb.append(' ');
//            }
//        }
//        System.out.println(sb.toString());
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    //이분탐색으로 문제 해결함. 시간 초과가 난 이유가 로직의 문제가 아니라 프린트문으로 계속 출력했기 때문이었음. StringBuffer로 한꺼번에 프린트하여 해결.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        int[] sang = new int[n];
        String[] card = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            sang[i] = Integer.parseInt(card[i]);
        }

        Arrays.sort(sang);

        int m = Integer.parseInt(br.readLine());

        String[] nums = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(nums[i]);
            int start = 0;
            int end = n - 1;
            boolean found = false;

            while (start <= end) {
                if (sang[start] == num || sang[end] == num) {
                    found = true;
                    break;
                }
                int mid = (start + end) / 2;
                int temp = sang[mid];
                if (temp == num) {
                    found = true;
                    break;
                } else if (temp > num) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            if (found) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            if (i != m - 1) {
                sb.append(' ');
            }
        }
        System.out.println(sb.toString());
    }
}