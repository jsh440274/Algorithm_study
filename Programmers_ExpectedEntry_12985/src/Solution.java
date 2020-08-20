class Solution {
    public int solution(int n, int a, int b) {
        int answer = 1;
        long a1 = (long) a;
        long b1 = (long) b;
        while (Math.abs(a1 - b1) > 1 || Math.max(a1, b1) % 2 != 0) {
            a1 = (a1 + (a1 % 2)) / 2;
            b1 = (b1 + (b1 % 2)) / 2;
            answer++;
        }
        return answer;
    }
}