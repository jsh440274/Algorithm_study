class Solution {
    public static int[] nums;
    public static boolean[] visited;
    public static int answer = 0;

    public int solution(int[] nums) {
        this.nums = nums;
        visited = new boolean[nums.length];

        pick3(0, 3, 0);

        return answer;
    }

    public void pick3(int start, int depth, int num) {
        if (depth == 0) {
            if (num <= 1) {
                return;
            }
            for (int i = 2; i < num; i++) {
                if (num % i == 0) return;
            }
            answer++;
            return;
        } else {
            for (int i = start; i < nums.length; i++) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                num += nums[i];
                pick3(i, depth - 1, num);
                num -= nums[i];
                visited[i] = false;
            }
        }
    }


    public static boolean isSosu(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}