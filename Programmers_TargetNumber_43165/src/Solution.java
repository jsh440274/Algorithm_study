class Solution {
    public static int[] numbers;
    public static boolean[] visited;
    public static int target;
    public static int answer = 0;
    public static int total = 0;

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        visited = new boolean[numbers.length];

        for (int num : numbers) {
            total += num;
        }
        for (int i = 1; i <= numbers.length; i++) {
            perm_minus(0, i);
        }

        return answer;
    }

    public static void perm_minus(int index, int depth) {
        if (depth == 0) {
            if (total == target) {
                answer++;
            }
            return;
        }
        for (int i = index; i < numbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                total -= 2 * numbers[i];
                perm_minus(i, depth - 1);
                total += 2 * numbers[i];
                visited[i] = false;
            }
        }
    }
}