class Solution {
    public int[] solution(int n, int s) {
        int[] answer = {-1};
        if (n > s) return answer;
        answer = new int[n];

        int divided = s / n;
        int rest = s % n;

        for (int i = 0; i < n; i++) {
            answer[i] = divided;
            if (i == n - 1 - rest) {
                divided++;
            }
        }

        return answer;
    }
}