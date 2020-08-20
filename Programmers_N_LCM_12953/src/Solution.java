import java.util.ArrayList;

class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        ArrayList<Integer> sosu = new ArrayList<>();

        for (int i = 2; i <= 100; i++) {
            int count = 0;
            for (int j = 2; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count == 1) {
                sosu.add(i);
            }
        }

        int[][] sosucount = new int[sosu.size()][arr.length];

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            for (int j = 0; j < sosucount.length; j++) {
                while (num % sosu.get(j) == 0) {
                    sosucount[j][i]++;
                    num /= sosu.get(j);
                }
            }
        }

        for (int i = 0; i < sosucount.length; i++) {
            int max = sosucount[i][0];
            for (int j = 1; j < arr.length; j++) {
                max = Math.max(max, sosucount[i][j]);
            }
            if (max != 0) {
                answer *= Math.pow(sosu.get(i), max);
            }
        }

        return answer;
    }
}