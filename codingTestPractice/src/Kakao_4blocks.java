public class Kakao_4blocks {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] table = new char[m][n];
        int[][] erase_table = new int[m][n];
        for (int i = 0; i < m; i++) {
            char[] line = board[i].toCharArray();
            for (int j = 0; j < n; j++) {
                table[i][j] = line[j];
                erase_table[i][j] = 1;
            }
        }
        boolean cont = true;
        while (cont == true) {
            cont = false;
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (table[i][j] != '\0' && table[i][j] == table[i - 1][j] && table[i][j] == table[i][j - 1] && table[i][j] == table[i - 1][j - 1]) {
                        erase_table[i][j] = 0;
                        erase_table[i - 1][j] = 0;
                        erase_table[i][j - 1] = 0;
                        erase_table[i - 1][j - 1] = 0;
                    }
                }
            }
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (erase_table[i][j] == 0) {
                        cont = true;
                        erase_table[i][j] = 1;
                        answer++;
                        for (int k = i - 1; k >= 0; k--) {
                            table[k+1][j] = table[k][j];
                        }
                        table[0][j] = '\0';
                    }
                }
            }
        }
        return answer;
    }
}
