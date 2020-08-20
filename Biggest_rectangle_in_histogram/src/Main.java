import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();

        while (!line.equals("0")) {
            Stack<Integer> stack = new Stack<>();
            int[] testcase = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int max = testcase[0];
            for (int i = 0; i < testcase.length; i++) {
                if (stack.isEmpty() || testcase[i] > testcase[stack.peek()]) {
                } else if (testcase[i] < testcase[stack.peek()]) {
                    int temp_rect = 0;
                    int temp = testcase[stack.peek()];
                    stack.pop();
                    if (stack.isEmpty()) {
                        temp_rect = temp * i;
                    } else {
                        temp_rect = temp * (i - stack.peek() - 1);
                    }
                    max = Math.max(max, temp_rect);
                }
                stack.push(i);
            }

            while (!stack.isEmpty()) {
                int temp = testcase[stack.peek()];
                stack.pop();
                if (stack.isEmpty()) {
                    max = Math.max(max, temp * testcase.length);
                } else {
                    max = Math.max(max, temp * (testcase.length - stack.peek() - 1));
                }
            }

            System.out.println(max);
            line = sc.nextLine();
        }
    }
}
