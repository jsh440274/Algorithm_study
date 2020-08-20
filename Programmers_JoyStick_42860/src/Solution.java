class Solution {
    public int solution(String name) {
        int answer = 0, count = 0, index = 0;
        int[] updown = new int[name.length()];
        for (int i = 0; i < updown.length; i++) {
            updown[i] = Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            answer += updown[i];
        }

        for (int i = 0; i < updown.length; i++) {
            if (updown[i] == 0) {
                int count_zero = 0;
                for (int j = i; updown[j] == 0; j++) {
                    count_zero++;
                }
                if (count < count_zero) {
                    count = count_zero;
                    index = i;
                }
            }
        }
        int temp = Math.min(updown.length - 1 - count, updown.length * 2 - count * 2 - 2);
//        answer += updown.length - 1 - count;
        answer += temp;
        return answer;
    }
}