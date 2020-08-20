import java.util.ArrayList;

class Solution {
    public int[] solution(int brown, int red) {
        int[] answer = new int[2];
        int total = brown + red;
        ArrayList<Integer> yaksu = new ArrayList<>();

        for (int i = total / 3; i >= 3; i--) {
            if (total % i == 0) {
                yaksu.add(i);
            }
        }

        for (int i = 0; i < yaksu.size(); i++) {
            int a = yaksu.get(i);
            for (int j = i; j < yaksu.size(); j++) {
                int b = yaksu.get(j);
                if (a * b == total && (2 * (a + b)) - 4 == brown) {
                    answer[0] = a;
                    answer[1] = b;
                    break;
                }
            }
        }
        return answer;
    }
}