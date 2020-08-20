class Solution {
    public String solution(int n) {
        String answer = "";
        while (n > 0) {
            int rest = n % 3;
            n /= 3;
            if (rest == 0) {
                rest = 4;
                n--;
            }
            answer = rest + answer;
        }
        return answer;
    }
}