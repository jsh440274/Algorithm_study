class Solution1 {
    public int solution(int n) {
        int answer = 0;
        StringBuffer sb = new StringBuffer();

        while (n != 0) {
            int temp = n % 3;
            sb.append(temp);
            n /= 3;
        }

        String tenans = sb.toString();

        int mul = 1;
        for (int i = tenans.length() - 1; i >= 0; i--) {
            int input = (tenans.charAt(i) - '0') * mul;
            answer += input;
            mul *= 3;
        }

        return answer;
    }
}