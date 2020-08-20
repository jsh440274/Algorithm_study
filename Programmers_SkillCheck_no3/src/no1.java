public class no1 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int prev = 1;

        for (int now : stations) {
            if (now - w > prev) {
                answer += (now - w - prev) / (2 * w + 1);
                if ((now - w - prev) % (2 * w + 1) != 0) {
                    answer++;
                }
            }
            prev = now + w + 1;
        }
        if (n + 1 > prev) {
            answer += (n + 1 - prev) / (2 * w + 1);
            if ((n + 1 - prev) % (2 * w + 1) != 0) {
                answer++;
            }
        }
        return answer;
    }
}
