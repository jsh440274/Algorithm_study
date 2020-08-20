import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long count = sc.nextInt();
        long[][] fibonacci = new long[41][2];
        int max = 2;
        fibonacci[0][0] = 1;
        fibonacci[0][1] = 0;
        fibonacci[1][0] = 0;
        fibonacci[1][1] = 1;

        for (int i = 0; i < count; i++) {
            int n = sc.nextInt();
            if (max <= n) {
                for (int j = max; j <= n; j++) {
                    fibonacci[j][0] = fibonacci[j - 1][0] + fibonacci[j - 2][0];
                    fibonacci[j][1] = fibonacci[j - 1][1] + fibonacci[j - 2][1];
                }
            }
            System.out.println(fibonacci[n][0] + " " + fibonacci[n][1]);
        }
    }
}
