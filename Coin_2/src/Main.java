import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Set<Integer> coinset = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            coinset.add(sc.nextInt());
        }

        Object[] coinsobj = coinset.toArray();
        int[] coins = new int[coinsobj.length];

        for (int i = 0; i < coinsobj.length; i++) {
            coins[i] = (int) coinsobj[i];
        }

        int[] dp = new int[coins.length];

        for (int i = 0; i < dp.length; i++) {

        }

    }
}
