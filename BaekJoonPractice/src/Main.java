import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int calc_min(int[] p) {
        int total = 0;

        Arrays.sort(p);

        for (int i = 0; i < p.length; i++) {
            int temp = 0;
            for (int j = 0; j <= i; j++) {
                temp += p[j];
            }
            total += temp;
        }

        return total;
    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int people = s.nextInt();
        int[] wait_time = new int[people];

        for(int i=0; i< people; i++){
            wait_time[i] = s.nextInt();
        }

        System.out.println(calc_min(wait_time));

    }
}
