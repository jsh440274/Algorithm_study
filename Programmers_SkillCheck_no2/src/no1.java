public class no1 {
    public int solution(int n, int a, int b) {
        int answer = 1;
        while (Math.abs(b - a) != 1) {
            a = (a >> 1) + (a % 2);
            b = (b >> 1) + (b % 2);
            answer++;
        }
        return answer;
    }
}

/*
    public int solution(int n, int a, int b) {
        int answer = 1;
        while (Math.abs(b - a) != 1) {
            if (a % 2 != 0) {
                a++;
            }
            if (b % 2 != 0) {
                b++;
            }
            a >>= 1;
            b >>= 1;
            answer++;
        }
        return answer;
    }
 */
