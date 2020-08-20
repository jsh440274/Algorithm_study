public class no1 {
    public int solution(int n, int m) {
        int answer = n;
        while (n / m > 0) {
            answer += n / m;
            n = (n / m) + (n % m);
        }
        if (n % m == 0) {
            answer++;
        }
        return answer;
    }
}
