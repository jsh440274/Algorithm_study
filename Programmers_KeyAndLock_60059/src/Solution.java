import java.util.ArrayList;

class Solution {
    public static int[][] lock;
    public static int[][] key;
    public static int[][] key90;
    public static int[][] key180;
    public static int[][] key270;
    public static int[][] min_square;

    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int n = key.length;
        this.lock = lock;
        this.key = key;
        key90 = new int[n][n];
        key180 = new int[n][n];
        key270 = new int[n][n];
        ArrayList<int[]> holes = new ArrayList<>();
        int[][] angle = {{0, 0}, {0, n - 1}, {n - 1, n - 1}, {n - 1, 0}};

        for (int i = 0; i < n; i++) {//4방향으로 돌린거.
            for (int j = 0; j < n; j++) {
                key90[j][n - 1 - i] = key[i][j];
                key180[n - 1 - i][n - 1 - j] = key[i][j];
                key270[n - 1 - j][i] = key[i][j];
                if (lock[i][j] == 0) {
                    int[] temp = {i, j};
                    holes.add(temp);
                }
            }
        }
        int[] shortest = {-1, 20};
        for (int i = 0; i < 4; i++) {
            int min = 0;
            for (int j = 0; j < holes.size(); j++) {
                int[] temp = holes.get(j);
                int x = Math.abs(angle[i][0] - temp[0]);
                int y = Math.abs(angle[i][1] - temp[1]);
                int square_size = Math.max(x, y) + 1;
                min = Math.max(min, square_size);
            }
            if (shortest[1] > min) {
                shortest[0] = i;
                shortest[1] = min;
            }
        }

        min_square = new int[shortest[1]][shortest[1]];
        int[] start_index = angle[shortest[0]];
        if (start_index[0] == n - 1) {
            start_index[0] -= shortest[1] - 1;
        }
        if (start_index[1] == n - 1) {
            start_index[1] -= shortest[1] - 1;
        }
        for (int i = 0; i < shortest[1]; i++) {//최소단위 정사각형 -> 이거만 어떻게든 들어맞으면 가능함.
            for (int j = 0; j < shortest[1]; j++) {
                min_square[i][j] = lock[start_index[0] + i][start_index[1] + j];
            }
        }

        for (int i = 0; i <= key.length - min_square.length; i++) {
            for (int j = 0; j <= key.length - min_square.length; j++) {
                if (matching_key(i, j, key) || matching_key(i, j, key90) || matching_key(i, j, key180) || matching_key(i, j, key270)) {
                    return true;
                }
            }
        }

        return answer;
    }

    public static boolean matching_key(int index_i, int index_j, int[][] key) {
        boolean flag = true;
        if (min_square.length > key.length) {
            for (int i = 0; i < min_square.length; i++) {
                for (int j = 0; j < min_square.length; j++) {
                    if (flag) {
                        if (min_square[i][j] + key[index_i + i][index_j + j] != 1) {
                            flag = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return flag;
    }
}