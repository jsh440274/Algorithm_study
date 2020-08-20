import java.util.ArrayList;

public class MoiTest {
    public int[] solution(int[] answers) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int score_a = 0;
        int score_b = 0;
        int score_c = 0;

        int max_score = -1;
        ArrayList<Integer> AL_answer = new ArrayList();

        for (int i = 0; i < answers.length; i++) {
            if (a[i % a.length] == answers[i]) {
                score_a++;
            }
            if (b[i % b.length] == answers[i]) {
                score_b++;
            }
            if (c[i % c.length] == answers[i]) {
                score_c++;
            }
        }

        int[] pre_answer = {score_a, score_b, score_c};

        for (int i = 0; i < 3; i++) {
            if (max_score < pre_answer[i]) {
                max_score = pre_answer[i];
            }
        }

        for (int i = 0; i < 3; i++) {
            if (pre_answer[i] == max_score) {
                AL_answer.add(i + 1);
            }
        }

        int[] answer = new int[AL_answer.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = AL_answer.get(i);
        }

        return answer;
    }
}
