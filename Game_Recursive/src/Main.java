import java.util.*;

public class Main {
    static int[][] board;
    static int[][] dp;
    static int n;
    static int m;
    static ArrayList<Integer>[] H_index;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nm = sc.nextLine();
        String[] nms = nm.split(" ");
        n = Integer.parseInt(nms[0]);
        m = Integer.parseInt(nms[1]);
        board = new int[n][m];
        dp = new int[n][m];
        H_index = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            H_index[i] = new ArrayList<>();
        }
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j) - 48;
                if (board[i][j] == 24) {
                    H_index[i].add(j);
                }
            }
        }
        Set<String> visited = new HashSet<>();
        System.out.println(result(visited, 0, 0, 0));
    }

    static int result(Set<String> visited, int i, int j, int count) {
        //////
        for (int a = 0; a < H_index[i].size(); a++) {
            if (H_index[i].get(a) < j) {
                j++;
            } else {
                break;
            }
        }
        if (j >= m) {
            return count;
        }
        //////
        String this_point = (new StringBuffer()).append(i).append(",").append(j).toString();//"i,j"형태로 set에 저장
        if (count == -1 || visited.contains(this_point)) {//이미 들렀다가 간 경우나 -1로 반환될 경우->사이클 생성, 무한루프라서 -1
            return -1;
        }
        int point = board[i][j];
        count += 1;
        if (point == 24) {//해당 point가 구멍인 경우-> 종료
            return count;
        }
        int temp = count;
        if (i - point > 0) {//위쪽 이동
            visited.add(this_point);
            temp = Math.max(temp, result(visited, i - point, j, count));
        }
        if (i + point < n) {//아래쪽 이동
            visited.add(this_point);
            temp = Math.max(temp, result(visited, i + point, j, count));
        }
        if (j - point > 0) {//왼쪽 이동
            visited.add(this_point);
            temp = Math.max(temp, result(visited, i, j - point, count));
        }
        if (j + point < m) {//오른쪽 이동
            visited.add(this_point);
            temp = Math.max(temp, result(visited, i, j + point, count));
        }
        return temp;
    }
}