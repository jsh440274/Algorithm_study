import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        //8개 단위로 15씩 차이가 난다는 규칙이 있다. 이를 활용해서 풀이.
        int[] rule = {1, 2, 4, 7, 8, 11, 13, 14};
        int ans = ((n - 1) / 8) * 15 + rule[(n - 1) % 8];
        System.out.println(ans);

    }
}

//1부터 하나씩 비교해보는 방법은 시간초과가 걸림.
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;

//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int n = Integer.parseInt(br.readLine());
//        long i = 1;
//
//        while (n > 0) {
//            if (i % 3 != 0 && i % 5 != 0) {
//                n--;
//            }
//            i++;
//        }
//
//        System.out.println(i - 1);
//    }
//}