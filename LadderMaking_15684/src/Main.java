import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n;
    static int h;
    static int m;
    static boolean[][] ladder;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        h = sc.nextInt();
        m = sc.nextInt();
        ladder = new boolean[m][n];
        ArrayList<int[]> drawingPoint = new ArrayList();
        int result = -1;

        for (int i = 0; i < h; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            ladder[x - 1][y - 1] = true;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
//                if ((j == 0 && !ladder[i][j]) || (j == n - 1 && !ladder[i][j - 1]) || (j != 0 && j != n - 1 && !ladder[i][j - 1] && !ladder[i][j])) {
                if (j != n - 1 && !ladder[i][j] && (j == 0 || !ladder[i][j - 1]) && (j == n - 2 || !ladder[i][j + 1])) {
                    int[] temp = {i, j};
                    drawingPoint.add(temp);
                }
            }
        }

        if (goDown()) {
            result = 0;
        } else {
            for (int i = 0; i < drawingPoint.size(); i++) {
                int[] temp = drawingPoint.get(i);
                int x = temp[0];
                int y = temp[1];
                ladder[x][y] = true;
                if (goDown()) {
                    result = 1;
                }
                ladder[x][y] = false;
                if (result == 1) break;
            }
            if (result == -1) {
                for (int i = 0; i < drawingPoint.size(); i++) {
                    int[] temp1 = drawingPoint.get(i);
                    int x1 = temp1[0];
                    int y1 = temp1[1];
                    ladder[x1][y1] = true;
                    for (int j = i; j < drawingPoint.size(); j++) {
                        int[] temp2 = drawingPoint.get(j);
                        int x2 = temp2[0];
                        int y2 = temp2[1];
                        ladder[x2][y2] = true;
                        if (goDown()) {
                            result = 2;
                        }
                        ladder[x2][y2] = false;
                        if (result == 2) break;
                    }
                    ladder[x1][y1] = false;
                    if (result == 2) break;
                }
            }
        }

        System.out.println(result);
    }

    public static boolean goDown() {
//        int[] place = new int[n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                int index = j + place[j];
//                if (j != 0) {
//                    if (ladder[i][j - 1]) {
//                        if (ladder[i][j]) return false;//오른쪽이랑 왼쪽이랑 같이 연결된 선 있으면 탙락.
//                        place[index]--;
//                    }
//                }
//                if (ladder[i][j]) {
//                    if (j == n - 1) return false;
//                    place[index]++;
//                }
//            }
//        }
        for (int i = 0; i < n; i++) {
            int place = i;
            for (int j = 0; j < m; j++) {
                if (place != n - 1 && ladder[j][place]) {
                    place++;
                } else if (place != 0 && ladder[j][place - 1]) {
                    place--;
                }
            }
            if (place != i) return false;
        }
//        for (int i = 0; i < n; i++) {
//            if (place[i] != 0) return false;
//        }
        return true;
    }
}
