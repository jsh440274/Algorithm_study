import java.util.ArrayList;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> al = new ArrayList<>();
        int max = 0, count = 0;

        for (int i = 0; i < progresses.length; i++) {
            int rest = (100 - progresses[i]);
            int time = rest / speeds[i];
            if (rest % speeds[i] != 0) {
                time++;
            }
            if (max < time) {
                max = time;
                al.add(count);
                count = 1;
            } else {
                count++;
            }
        }
        int[] answer = new int[al.size()];
        for (int i = 1; i < al.size(); i++) {
            answer[i - 1] = al.get(i);
        }
        answer[answer.length - 1] = count;
        return answer;
    }
}