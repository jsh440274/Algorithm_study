class Solution {
    public int solution(int n) {
        int answer = 1;
        for (int i = 1; i <= (n + (n % 2)) / 2; i++) {
            int num = 0;
            int j = i;
            while (num < n) {
                num += j;
                j++;
            }
            if (num == n) {
                answer++;
            }
        }
        return answer;
    }
}