import java.util.Arrays;
import java.util.Comparator;

class Solution2 {
    public int solution(int[][] jobs) {
        int n = jobs.length;
        int answer = 0;
        boolean[] visited = new boolean[jobs.length];
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] > o2[0] ? 1 : -1;
            }
        });

        int now = jobs[0][0];
        //요청된 시간을 보고 이 시간이 끝날때까지 그걸로 설정쓰.
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            int finish = answer + jobs[i][1];
            int index = 0;
            int min = Integer.MIN_VALUE;
            while (i + index < n && jobs[i + index][0] < finish) {
                if (min > jobs[i + index][0]) {
                }
                index++;
            }
            answer = finish;
        }
        return answer / n;
    }
}