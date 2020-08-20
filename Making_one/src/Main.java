import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int src = sc.nextInt();
        int[] d = new int[src];

        d[0] = 0;

        for (int i = 1; i < src; i++) {
            d[i] = d[i - 1] + 1;
            if ((i + 1) % 3 == 0) {
                d[i] = Math.min(d[i], d[i / 3] + 1);
            }
            if ((i + 1) % 2 == 0) {
                d[i] = Math.min(d[i], d[i / 2] + 1);
            }
        }
        System.out.println(d[src - 1]);
    }
}
