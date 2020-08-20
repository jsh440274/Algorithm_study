import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class no1 {

    static char[][] map;
    static int m, n;
    static ArrayList<Character> deletingal;

    public String solution(int m, int n, String[] board) {
        String answer = "";
        Set<Character> charset = new HashSet<>();
        this.m = m;
        this.n = n;
        map = new char[m][n];

        for (int i = 0; i < m; i++) {
            String temp = board[i];
            for (int j = 0; j < n; j++) {
                map[i][j] = temp.charAt(j);
                if (!charset.contains(map[i][j])) {
                    charset.add(map[i][j]);
                }
            }
        }

        ArrayList<Character> charal = new ArrayList<>(charset);
        Collections.sort(charal);

        return answer;
    }

    public static void copyal(ArrayList<Character> charal) {
        deletingal = new ArrayList<>();
        for (int i = 0; i < charal.size(); i++) {
            deletingal.add(charal.get(i));
        }
    }

    public static boolean erasable(int i1, int j1, int i2, int j2) {
        int starti = Math.max(i1, i2);
        int endi = Math.min(i1, i2);
        int startj = Math.max(j1, j2);
        int endj = Math.min(j1, j2);
        boolean case1 = true, case2 = true;
        char symbol = map[i1][j1];

        for (int i = starti; i < endi; i++) {
            if (map[i][j1] != symbol && map[i][j1] != '.') {
                case2 = false;
            }
            if (map[i][j2] != symbol && map[i][j2] != '.') {
                case1 = false;
            }
        }
        for (int j = startj; j < endj; j++) {
            if (map[i1][j] != symbol && map[i1][j] != '.') {
                case1 = false;
            }
            if (map[i2][j] != symbol && map[i2][j] != '.') {
                case2 = false;
            }
        }
        return (case1 && case2);
    }

    public static boolean clear() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != '.' || map[i][j] != '*') {
                    return false;
                }
            }
        }
        return true;
    }

//    static int n, m;
//    static char[][] map;
//    static int[] da = {0, 1, 0, -1};
//    static int[] db = {1, 0, -1, 0};
//    static Stack<String> ansStack = new Stack<>();
//
//    public String solution(int m, int n, String[] board) {
//        String answer = "IMPOSSIBLE";
//        this.m = m;
//        this.n = n;
//        map = new char[m][n];
//
//        for (int i = 0; i < m; i++) {
//            String x = board[i];
//            for (int j = 0; j < n; j++) {
//                map[i][j] = x.charAt(j);
//            }
//        }
//
//        return answer;
//    }
//
//    public static void findway(int starti, int startj, int nowi, int nowj, int curvedi, int curvedj) {
//        if (starti == nowi && startj == nowj) {//시작지점일때  사방으로 조사  같은놈이 있는지 먼저 조사하고 없으면 .있는지 조사
//            for (int x = 0; x < 4; x++) {
//                int newi = nowi + da[x];
//                int newj = nowj + db[x];
//                if (newi >= 0 && newi < m && newj >= 0 && newj < n) {//사방을 조사
//                    if (map[newi][newj] == map[starti][startj]) {//같은애가 나왔을 때
//
//                    } else if (map[newi][newj] == '.') {//.을 만났을때
//                        findway(starti, startj, newi, newj, curvedi, curvedj);
//                    }
//                }
//            }
//        } else if (curvedi == -1) {//꺾이지 않을때 start를 기준으로 방향을 정해서 그쪽으로 더해 + curved신경쓰기
//        } else {//꺾일때 curved를 기준으로 방향을 정해서 그쪽으로 더해
//            if (nowi - curvedi == 0) {
//                if (nowj - curvedj > 0) {
//                    nowj--;
//                    if (nowj >= 0) {
//                        findway(starti, startj, nowi, nowj, curvedi, curvedj);
//                    }
//                } else {
//                    nowj++;
//                    if (nowj < n) {
//                        findway(starti, startj, nowi, nowj, curvedi, curvedj);
//                    }
//                }
//            } else {
//                if (nowi - curvedi > 0) {
//                    nowi--;
//                    if (nowi >= 0) {
//                        findway(starti, startj, nowi, nowj, curvedi, curvedj);
//                    }
//                } else {
//                    nowi++;
//                    if (nowi < m) {
//                        findway(starti, startj, nowi, nowj, curvedi, curvedj);
//                    }
//                }
//            }
//        }
//    }
}
