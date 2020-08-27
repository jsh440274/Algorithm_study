//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.Queue;
//
//public class Main {
//    static int n;
//    static int[][] map;
//    static int[][] heading;
//    static int[][] d = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
//    static Queue<Integer> q = new LinkedList<>();
//    static Queue<Character> p = new LinkedList<>();
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        n = Integer.parseInt(br.readLine());
//        map = new int[n + 1][n + 1];
//        heading = new int[n + 1][n + 1];
//        for (int i = 0; i <= n; i++) {
//            Arrays.fill(heading[i], -1);
//        }
//        map[1][1] = 2;
//        heading[1][1] = 0;
//        int[] start = {1, 1};
//        int[] end = {1, 1};
//        int k = Integer.parseInt(br.readLine());
//
//        while (k > 0) {
//            String[] line = br.readLine().split(" ");
//            map[Integer.parseInt(line[0])][Integer.parseInt(line[1])] = 1;
//            k--;
//        }
//
//        int l = Integer.parseInt(br.readLine());
//        while (l > 0) {
//            String[] line = br.readLine().split(" ");
//            q.offer(Integer.parseInt(line[0]));
//            p.offer(line[1].charAt(0));
//            l--;
//        }
//        int answer = moving(start, end, 1, 0);
//        System.out.println(answer);
//    }
//
//    public static int moving(int[] start, int[] end, int second, int head) {
//        boolean flag = false;
//        int[] next = d[head];//이거는 다음에 넘어갈 곳. 오른쪽 왼쪽 위 아래
//        int[] tempe = {end[0], end[1]};
//        end[0] += next[0];
//        end[1] += next[1];
//        //다음에 넘어갈 곳이 몸통에 닿는 부분이거나( == 2 ) map을 넘어간곳( < 0 || > n)이면 바로 리턴
//        if (end[0] < 1 || end[0] > n || end[1] < 1 || end[1] > n || map[end[0]][end[1]] == 2) {
//            return second;
//        }
//        //다음에 넘어갈 곳이 map에서 사과 있는곳( == 1 ) 이면 start 건드리지 말고 사과 있는곳이 아니면 start부분 빼주고
//        if (map[end[0]][end[1]] != 1) {
//            map[start[0]][start[1]] = 0;
//            next = d[heading[start[0]][start[1]]];
//            heading[start[0]][start[1]] = -1;
//            start[0] += next[0];
//            start[1] += next[1];
//        }
//        map[end[0]][end[1]] = 2;
//
//        if (!q.isEmpty() && q.peek() == second) {
//            q.poll();
//            char polled = p.poll();
//            if (polled == 'D') {
//                if (head == 0) {
//                    head = 3;
//                } else if (head == 1) {
//                    head = 2;
//                } else if (head == 2) {
//                    head = 0;
//                } else {
//                    head = 1;
//                }
//            } else {
//                if (head == 0) {
//                    head = 2;
//                } else if (head == 1) {
//                    head = 3;
//                } else if (head == 2) {
//                    head = 1;
//                } else {
//                    head = 0;
//                }
//            }
//            next = d[head];
//            if (start[0] == end[0] && start[1] == end[1]) {
//                start[0] = tempe[0] + next[0];
//                start[1] = tempe[1] + next[1];
//            }
//            end[0] = tempe[0] + next[0];
//            end[1] = tempe[1] + next[1];
//            heading[tempe[0]][tempe[1]] = head;
//        }
//        heading[end[0]][end[1]] = head;
//        return moving(start, end, second + 1, head);
//    }
//}
import java.io.*;
import java.util.*;

class Main {
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[][] map = new int[N+2][N+2];
        Map<Integer, String> dirSet = new HashMap<>();
        // 테투리 설정
        for(int i = 0; i < N+2; i++) {
            map[0][i] = map[N+1][i] = map[i][0] = map[i][N+1] = 1;
        }
        // 사과 설정
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 2;
        }

        // 방향 설정
        int L = Integer.parseInt(br.readLine());
        for(int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String c = st.nextToken();
            dirSet.put(x, c);
        }

        int dir = 1;
        int time = 0;
        Deque<Location> snake = new ArrayDeque<>();
        snake.add(new Location(1,1));
        while(true) {
            time++;
            Location head = snake.peekLast();
            int nX = head.x + dx[dir];
            int nY = head.y + dy[dir];
            if(map[nY][nX] == 1) {
                break;
            }
            if(map[nY][nX] != 2) {
                Location tail = snake.poll();
                map[tail.y][tail.x] = 0;
            }
            map[nY][nX] = 1;
            snake.addLast(new Location(nY, nX));
            if(dirSet.containsKey(time)) {
                dir = (dirSet.get(time).equals("D")) ? (dir+1) % 4 : (dir+3) % 4;
            }
        }
        System.out.println(time);
    }

    private static class Location {
        int x;
        int y;
        Location(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}