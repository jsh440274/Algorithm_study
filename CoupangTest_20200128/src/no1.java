import java.util.Arrays;

public class no1 {
    public int[] solution(int n, int min_position, int max_position, int[] positions) {
        int distance = (max_position - min_position) / (n - 1);

        int[] answer = new int[n - positions.length];
        Arrays.sort(positions);

        int i = 0;
        int j = 0;
        int num = min_position;
        while (num < max_position) {
            if (positions[j] == num) {
                j++;
            } else {
                answer[i] = num;
                i++;
            }
            num += distance;
        }
        if(max_position != positions[positions.length-1]){
            answer[answer.length -1] = max_position;
        }

        return answer;
    }
}
