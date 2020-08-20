class Solution {

    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        long[] factorial = new long[n];
        boolean[] visited = new boolean[n];
        factorial[1] = 1;
        for (int i = 2; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        int fact_index = n - 1;
        int ans_index = 0;
        while (true) {
            int index = 0;
            while (k > factorial[fact_index]) {
                while (visited[index]) index++;
                index++;
                k -= factorial[fact_index];
            }
            while (visited[index]) index++;
            answer[ans_index] = index + 1;
            visited[index] = true;
            ans_index++;
            fact_index--;
            if (fact_index == 0) {
                for (int i = 0; i < visited.length; i++) {
                    if (!visited[i]) {
                        answer[n - 1] = i + 1;
                    }
                }
                break;
            }
        }

        return answer;
    }
}