import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static int calc_guitar_string(ArrayList<int[]> nm, int n) {
        int total_money = 1000;
        for (int i = 0; i < nm.size(); i++) {
            int maker_i_money = 0;
            int six = nm.get(i)[0];
            int one = nm.get(i)[1];
            int gasungbi = six / one;
            if (n % 6 >= gasungbi) {
                maker_i_money = six * (n / 6 + 1);
            } else {
                maker_i_money = six * (n / 6) + one * (n % 6);
            }
            if (total_money > maker_i_money) {
                total_money = maker_i_money;
            }
        }
        return total_money;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int m = s.nextInt();

        ArrayList<int[]> nm = new ArrayList();

        for (int i = 0; i < m; i++) {
            int[] temp = new int[2];
            temp[0] = s.nextInt();
            temp[1] = s.nextInt();
            nm.add(temp);
        }

        System.out.println(calc_guitar_string(nm, n));
    }
}
