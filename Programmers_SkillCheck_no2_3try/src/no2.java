import java.util.Arrays;

public class no2 {
    public int solution(int[] people, int limit) {
        boolean[] in = new boolean[people.length];
        int answer = 0;
        Arrays.sort(people);

        for (int i = people.length - 1; i >= 0; i--) {
            if (in[i] == true) continue;
            int container = limit - people[i];
            int j = i - 1;
            while (j >= 0) {
                if (in[j] == false && container >= people[j]) {
                    break;
                }
                j--;
            }
            in[i] = true;
            if (j >= 0) {
                in[j] = true;
            }
            answer++;
        }

        return answer;
    }
}
