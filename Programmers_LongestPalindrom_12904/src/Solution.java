class Solution {
    public static char[] cs;

    public int solution(String s) {
        int answer = 1;
        cs = s.toCharArray();

        for (int i = 1; i < cs.length - 1; i++) {
            if (cs[i - 1] == cs[i + 1]) {
                int res = finding(i, true);
                answer = Math.max(answer, res);
            }
            if (cs[i] == cs[i - 1]) {
                int res = finding(i, false);
                answer = Math.max(answer, res);
            }
        }

        return answer;
    }

    public static int finding(int index, boolean center) {
        if (center) {
            int res = 1;
            while (index - res >= 0 && index + res < cs.length) {
                if (cs[index - res] != cs[index + res]) {
                    break;
                }
                res++;
            }
            return res * 2 - 1;
        } else {
            int res = 1;
            while (index - res >= 0 && index - 1 + res < cs.length) {
                if (cs[index - res] != cs[index - 1 + res]) {
                    break;
                }
                res++;
            }
            return (res - 1) * 2;
        }
    }
}