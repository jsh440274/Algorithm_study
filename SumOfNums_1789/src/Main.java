import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static long minval;
    public static long index;
    public static Set<Long> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //소인수분해??
        //아니면 그냥 쭉 탐색하는데 격차가 가장 작은거
        //어차피 n곱하기 n+1이니까 기준값보다 작으면 왼쪽으로 크면 오른쪽으로
        //n곱하기 n+1의 값이 기준보다 작은 애들 중에서 그 차이가 가장 작은 애를 고름.

        long n = Long.parseLong(br.readLine());

        minval = Long.MAX_VALUE;
        index = n;

        if (n == 1) {
            System.out.println("1");
        } else {
            long answer = findingN(0, n, n);
            System.out.println(answer);
        }

    }

    public static long findingN(long start, long end, long original) {
        long mid = (start + end) / 2;
        if (set.contains(mid)) {
            return index;
        } else {
            set.add(mid);
        }
        long res = mid * (mid + 1) / 2;
        //같으면 mid 리턴, 크면 오른쪽, 작으면 왼쪽
        if (res == original) {
            return mid;
        } else if (res > original) {
            return findingN(start, mid, original);
        } else {
            if (original - res < minval) {
                minval = original - res;
                index = mid;
            }
            return findingN(mid + 1, end, original);
        }
    }
}