import java.util.Scanner;

public class Main {
    static int[] histogram;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String[] firstLine = sc.nextLine().split(" ");
            int n = Integer.parseInt(firstLine[0]);
            if (n == 0) break;
            histogram = new int[n];
            for (int i = 1; i < n; i++) {
                histogram[i - 1] = Integer.parseInt(firstLine[i]);
            }
            int result = solve(0, n - 1);
            System.out.println(result);
        }
    }

    public static int solve(int left, int right) {
        if (right == left) return histogram[left];//하나의 블럭 밖에 없을때
        int mid = (right + left) / 2;//중간값으로 나눔
        //mid를 /2한 순간부터 홀수를 어떨지에대해서 알 필요가 없네 젠장

        //여기가 왼쪽하고 오른쪽 비교 부분
        int result = Math.max(solve(left, mid), solve(mid + 1, right));//분할한 기준으로 왼쪽 오른쪽 중 큰쪽을 고름
        int lower = mid;
        int higher = mid + 1;
        int height = Math.min(lower, higher);//높이는 항상 높은 쪽으로 간다. 높은쪽을 기준으로 정해야 직사각형 밑변을 늘려나갈 때 높이를 유지할 수 있기 때문.

        //여기서부터 가운데 걸친거 부분
        result = Math.max(height * 2, result);//왼쪽이랑 오른쪽 말고 가운데 경계선에 있는 블록들에 가장 큰 값이 걸쳤을 때 경우 -> 가운데 두개 블럭을 선택해서 만든 직사각형하고 비교해서 큰값을 고름
        while (left < lower || higher < right) {//왼쪽이 끝에 안닿았거나 오른쪽이 끝에 안닿았을때
            if (higher < right && (lower == left || histogram[higher + 1] > histogram[lower - 1])) {//오른쪽은 끝에 안닿았고 왼쪽이 끝에 닿았거나 오른쪽으로 확장할 수 있을 때
                higher++;
                height = Math.min(height, histogram[higher]);
            } else {//오른쪽이 끝에 닿았고 왼쪽이 끝에 안닿았거나 왼쪽으로 확장할 수 있을 때.
                lower--;
                height = Math.min(height, histogram[lower]);
            }
            result = Math.max(result, height * (higher - lower + 1));//기존에 계산해 놓은 직사각형 넓이랑 왼쪽 오른쪽으로 확장시켜서 구한 넓이 중에서 큰 값.
        }
        return result;
    }
}
