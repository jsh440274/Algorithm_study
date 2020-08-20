public class no4 {
    public int[] solution(int N, int[][] directory, int[][] query) {
        int[] answer = new int[query.length];
        int[][] route = new int[N][N];
        for (int i = 0; i < directory.length; i++) {
            route[directory[i][0] - 1][directory[i][1] - 1] = 1;
        }
        for (int i = 0; i < query.length; i++) {
            int count = 0;

        }
        return answer;
    }
}
