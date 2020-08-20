import java.util.Arrays;

public class no3 {
    public int solution(int[] grade, int max_diff) {
        int answer = 0;
        Arrays.sort(grade);
        for (int i = 0; i < grade.length; i++) {
            int count = 0;
            for (int j = i; j < grade.length; j++) {
                if(grade[j] - grade[i] <= max_diff){
                    count ++;
                }
                else{
                    break;
                }
            }
            answer = Math.max(answer, count);
        }
        return answer;
    }
}
