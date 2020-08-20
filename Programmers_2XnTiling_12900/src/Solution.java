class Solution {
    public int solution(int n) {
        int answer = 0;
        int one = n;
        int two = 0;

        while (two <= n / 2) {
            answer += combination(one, two);
            two++;
            one -= 2;
        }

        return answer;
    }

    public static int combination(int one, int two) {
        int n = one + two;
        int upper = 1;
        int lower = 1;
        for (int i = 0; i < two; i++) {
            upper *= n - i;
        }
        for (int i = 1; i <= two; i++) {
            lower *= i;
        }
        return upper / lower;
    }
}