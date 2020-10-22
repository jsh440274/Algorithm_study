import java.util.ArrayList;
import java.util.Collections;

public class Solution1 {
    public int[] solution(int[] numbers) {

        ArrayList<Integer> set = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            int a = numbers[i];
            for (int j = i + 1; j < numbers.length; j++) {
                int b = numbers[j];
                if (!set.contains(a + b)) {
                    set.add(a + b);
                }
            }
        }

        Collections.sort(set);
        int[] answer = new int[set.size()];
        for (int i = 0; i < set.size(); i++) {
            answer[i] = set.get(i);
        }

        return answer;
    }
}
