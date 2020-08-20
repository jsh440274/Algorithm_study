import java.util.Scanner;

public class Main {
    public static long multiple(int a, int n) {
        if (n == 0) return 1;
        else {
            long temp = multiple(a, n / 2);
            if (n % 2 == 0) {
                return temp * temp;
            } else {
                return temp * temp * a;
            }

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        long result = multiple(a, b) % c;

        System.out.println(result);

    }
}
