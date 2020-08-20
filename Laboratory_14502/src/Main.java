import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static ArrayList<int[]> virus = new ArrayList<>();
    static ArrayList<int[]> clean = new ArrayList<>();
    static int[][] lab;
    static int[][] around = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        lab = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                lab[i][j] = sc.nextInt();
                if (lab[i][j] == 2) {
                    int[] temp = {i, j};
                    virus.add(temp);
                } else if (lab[i][j] == 0) {
                    int[] temp = {i, j};
                    clean.add(temp);
                }
            }
        }

        wall(0, 3);

        System.out.println(answer);
    }

    public static int safezone() {
        int ans = 0;
        int[][] safelab = lab;
        ArrayList<int[]> fullvirus = virus;

//        for (int[] temp : virus) {
//        for (int x = 0; x < fullvirus.size(); x++) {
        int x = 0;
        while (x < fullvirus.size()) {
            int[] temp = fullvirus.get(x);
            int i = temp[0];
            int j = temp[1];
            for (int[] d : around) {
                int a = d[0] + i;
                int b = d[1] + j;
                if (n > a && a >= 0 && m > b && b >= 0) {
                    int[] newtemp = {a, b};
                    if (safelab[a][b] == 0) {
                        safelab[a][b] = 2;
                        paint(a, b, safelab);
                    }
                }
            }
            x++;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (safelab[i][j] == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void wall(int start, int depth) {
        if (depth == 0) {
            int tempans = safezone();
            answer = Math.max(answer, tempans);
            return;
        }
        for (int i = start; i < clean.size() - 1; i++) {
            int[] temp = clean.get(i);
            lab[temp[0]][temp[1]] = 1;
            wall(i + 1, depth - 1);
            lab[temp[0]][temp[1]] = 0;
        }
        return;
    }

    public static void paint(int y, int x, int[][] safelab) {
        for (int d[] : around) {
            int nx = d[0] + x;
            int ny = d[1] + y;

            if (0 <= ny && ny < n && 0 <= nx && nx < m) {
                if (safelab[ny][nx] == 0) {
                    safelab[ny][nx] = 3;
                    paint(ny, nx, safelab);
                }
            }
        }
    }
}
