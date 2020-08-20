import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int n = sc.nextInt();

        int[] cards = new int[num];

        for (int i = 0; i < num; i++) {
            cards[i] = sc.nextInt();
        }

        int sum = 0;

        for (int i = 0; i < num; i++) {
            for (int j = i + 1; j < num; j++) {
                for (int k = j + 1; k < num; k++) {
                    int temp_sum = cards[i] + cards[j] + cards[k];
                    if(temp_sum > n){
                        continue;
                    }
                    else{
                        sum = Math.max(sum, temp_sum);
                    }
                }
            }
        }

        System.out.println(sum);
    }
}
