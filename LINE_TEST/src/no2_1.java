import java.util.ArrayList;
import java.util.Scanner;

public class no2_1 {
    public static void k_factorial(ArrayList<Integer> numbers, int[] factorial_sum) {
        int index = 0;
        while (factorial_sum[index] == 0) {
            index++;
        }
        for (int i = factorial_sum.length - 1; i > index; i--) {

        }
    }

    public static int[] making_fact_sum(int numbers, int k) {
        int[] result = new int[numbers];
        for (int i = numbers - 1; i >= 0; i--) {
            int fact = factorial(i + 1);
            if (k >= fact) {
                result[i] = k / fact;
                k = k - (k / fact) * fact;
            } else {
                result[i] = 0;
            }
        }
        return result;
    }

    public static int factorial(int k) {
        if (k <= 1) return k;
        else {
            return factorial(k - 1) * k;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        int b = sc.nextInt();

        String[] input = a.split(" ");
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            numbers.add(Integer.parseInt(input[i]));
        }
        numbers.sort(null);

        if (b == factorial(numbers.size())) {
            while (!numbers.isEmpty()) {
                System.out.print(numbers.remove(numbers.size() - 1));
            }
        } else {
            int[] factorial_sum = making_fact_sum(numbers.size(), b);
            k_factorial(numbers, factorial_sum);
        }
    }
}