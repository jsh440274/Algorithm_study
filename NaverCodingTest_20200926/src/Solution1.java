public class Solution1 {
    public String Solution(int n, int[] p, int[] c) {
        String answer = "";
        int count = 0;
        int[] money = {100, 50, 25};
        int saved = 0;
        double total = 0;

        for (int i = 0; i < n; i++) {
            int order = c[i];
            int now = p[i] + saved;
            if (order <= now) {
                saved = now - order;
                total += order * money[count];
                count = 0;
            } else {
                if (count == 2) {
                    n = i + 1;
                    break;
                } else {
                    saved = now;
                    count++;
                }
            }
        }

        double ret = total / n;


        answer = String.format("%.2f", ret);

        return answer;
    }
}
