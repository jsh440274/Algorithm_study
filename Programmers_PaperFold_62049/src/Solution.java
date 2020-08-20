class Solution {
    public int[] solution(int n) {
        int[] dp = {0};
        for (int i = 0; i < n - 1; i++) {
            dp = full(dp);
        }
        return dp;
    }

    public int[] full(int[] left) {
        int[] res = new int[left.length * 2 + 1];
        res[left.length] = 0;
        for (int i = 0; i < left.length; i++) {
            res[i] = left[i];
            res[res.length - 1 - i] = 1 - left[i];
        }
        return res;
    }
}