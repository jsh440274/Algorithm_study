import java.util.ArrayList;

public class no2 {
    public int solution(int[] arr) {
        int answer = 1;
        ArrayList<Integer> sosu = new ArrayList<>();

        for (int i = 2; i <= 100; i++) {
            boolean issosu = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    issosu = false;
                    break;
                }
            }
            if (issosu) {
                sosu.add(i);
            }
        }

        int[][] sosumap = new int[sosu.size()][arr.length];

        for (int i = 0; i < sosu.size(); i++) {
            int s = sosu.get(i);
            for (int j = 0; j < arr.length; j++) {
                while (arr[j] > 1) {
                    if (arr[j] % s == 0) {
                        arr[j] /= s;
                        sosumap[i][j]++;
                    } else {
                        break;
                    }
                }
            }
        }

        for (int i = 0; i < sosu.size(); i++) {
            int minsosu = 0;
            int indexsosu = sosu.get(i);
            for (int j = 0; j < arr.length; j++) {
                minsosu = Math.max(minsosu, sosumap[i][j]);
            }
            for (int a = 0; a < minsosu; a++) {
                answer *= indexsosu;
            }
        }

        return answer;
    }
}
