import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int rope(int[] ropes) {
        int total = 0;
        Arrays.sort(ropes);
        for (int i = 0; i < ropes.length; i++) {
            int temp_total = 0;
            if (total < ropes[i] * (ropes.length - i)) {
                total = ropes[i] * (ropes.length - i);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int loop = s.nextInt();
        int[] ropes = new int[loop];

        for (int i = 0; i < loop; i++) {
            ropes[i] = s.nextInt();
        }

        System.out.println(rope(ropes));
    }
}
