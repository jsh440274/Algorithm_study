import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int max = 0;
        String[] line = br.readLine().split(" ");

        if (n == 1) {
            int light = Integer.parseInt(line[0]);
            System.out.println(Math.max(n - light, light - 0));
        } else {
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < m; i++) {
                stack.push(Integer.parseInt(line[i]));
            }
            int prev = stack.pop();
            //여기서 길 끝하고 먼저 비교해야함.
            if (prev != n) {
                max = (n - prev) * 2;
            }

            while (!stack.isEmpty()) {
                int popped = stack.pop();
                max = Math.max(prev - popped, max);
                prev = popped;
            }

//        여기서 0번째랑 비교를 해줘야함.
//        가로등이 0번째에 있는지를 먼저 보고 없으면 그냥 쌩으로 비교해야함.

            if (prev != 0) {
                max = Math.max(prev * 2, max);
            }

            System.out.println((max + 1) / 2);
        }
    }
}