class no3 {
    public static int[] numbers;
    public static int[] arr;
    public static boolean[] visited;
    public static int k;
    public static int answer = -1;

    public int solution(int[] numbers, int K) {
        this.numbers = numbers;
        this.k = K;
        arr = new int[numbers.length];
        visited = new boolean[numbers.length];
        making_arr(0, 0, 0);
        return answer;
    }

    public static void making_arr(int index, int start, int temp) {
        if(answer != -1)return;
        if (index == numbers.length) {
            for (int i = 1; i < arr.length; i++) {
                if (Math.abs(arr[i - 1] - arr[i]) > k) return;
            }
            if (answer == -1) {
//                answer = (temp + (temp % 2)) / 2;
                answer = mixing(arr, numbers);
            } else {
//                answer = Math.min(answer, (temp + (temp % 2)) / 2);
                answer = Math.min(answer, mixing(arr, numbers));
            }
            return;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                arr[index] = numbers[i];
                visited[i] = true;
//                if (index != i) temp++;
                making_arr(index + 1, i, temp);
//                if (index != i) temp--;
                arr[index] = 0;
                visited[i] = false;
            }
        }
    }

    public static int mixing(int[] arr, int[] numbers) {
        int res = 0;
        boolean flag = true;
        do {

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != numbers[i]) {
                    flag = false;
                    for (int j = i; j < arr.length; j++) {
                        if (arr[i] == numbers[j]) {
                            int temp = numbers[j];
                            numbers[j] = numbers[i];
                            numbers[i] = temp;
                            res++;
                            break;
                        }
                    }
                }
            }
        } while (flag);
        return res;
    }
}

/*
class no3 {
    public static int[] numbers;
    public static int k;
    public static boolean[] visited;
    public static int answer = -1;

    public int solution(int[] numbers, int K) {
        this.numbers = numbers;
        this.k = K;
        this.visited = new boolean[numbers.length];

        int i = 1;
        while (answer == -1) {
            swap(i, 0, i);
            i++;
        }
        return answer;
    }

    public static void swap(int depth, int start, int original_depth) {
        if (depth == 0) {
            for (int i = 1; i < numbers.length; i++) {
                int temp = Math.abs(numbers[i - 1] - numbers[i]);
                if (temp > k) {
                    return;
                }
            }
            answer = original_depth;
            return;
        } else {
            for (int i = start; i < numbers.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    for (int j = 0; j < numbers.length; j++) {
                        if (visited[j]) continue;
                        visited[j] = true;
                        int temp = numbers[i];
                        numbers[i] = numbers[j];
                        numbers[j] = temp;
                        swap(depth - 1, i, original_depth);
                        temp = numbers[j];
                        numbers[j] = numbers[i];
                        numbers[i] = temp;
                        visited[j] = false;
                    }
                    visited[i] = false;
                }
            }
        }
    }
}
 */



/*
문제 설명
자연수 N개가 중복없이 들어있는 배열이 있습니다. 이때, 서로 다른 두 원소의 위치를 바꾸는 Swap 연산을 이용해 원소들의 위치를 바꿔 서로 인접한 원소의 차가 K 이하가 되도록 하려 합니다. 단, Swap 연산을 최대한 적게 사용해야 합니다

배열 numbers가 매개변수로 주어질 때, 서로 인접한 원소의 차가 K 이하가 되도록 하는데 필요한 Swap 횟수의 최솟값을 return 하도록 solution 함수를 완성해주세요.

제한사항
numbers의 길이(N)는 1 이상 8 이하입니다.
numbers의 원소는 1 이상 100 이하인 자연수입니다.
숫자는 중복없이 들어있습니다.
K는 1 이상 100 이하인 자연수입니다.
서로 인접한 원소의 차가 K 이하가 되도록 할 수 있는 방법이 없다면 -1을 return 하세요.
입출력 예
numbers	                    k	    result
[10, 40, 30, 20]	        20	    1
[3, 7, 2, 8, 6, 4, 5, 1]	3	    2
입출력 예 설명
입출력 예 #1
30과 40의 위치를 바꾸면 [10, 30, 40, 20]이 되며, 인접한 원소의 차가 모두 20 이하가 됩니다.

입출력 예 #2
3과 4의 위치를 바꾸고, 2와 5의 위치를 바꾸면 [4, 7, 5, 8, 6, 3, 2, 1]이 되며, 인접한 원소의 차가 모두 3 이하가 됩니다.
 */