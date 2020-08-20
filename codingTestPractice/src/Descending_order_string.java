import java.util.Arrays;

public class Descending_order_string {
    public String solution(String s) {
        String answer = "";
        char[] a = s.toCharArray();
        Arrays.sort(a);
        if (a.length == 2) {
            if (a[0] < a[1]) {
                char temp = a[0];
                a[0] = a[1];
                a[1] = temp;
            }
        } else {
            for (int i = 0; i <= (a.length - 1) / 2; i++) {
                char temp = a[i];
                a[i] = a[a.length - i - 1];
                a[a.length - i - 1] = temp;
            }
        }
        answer = String.valueOf(a);
        return answer;
    }
}
