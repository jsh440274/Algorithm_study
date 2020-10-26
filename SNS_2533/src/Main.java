import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static ArrayList<Integer>[] map;
    public static int n;
    //dp 배열은 0번째가 얼리어답터가 아닐때, 1번째가 얼리어답터일때
    public static int[][] dp;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new ArrayList[n + 1];
        dp = new int[n + 1][2];
        visited = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);

            map[a].add(b);
            map[b].add(a);
        }

        early(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));

    }

    public static void early(int root) {
        dp[root][0] = 0;
        dp[root][1] = 1;
        visited[root] = true;

        ArrayList<Integer> child = map[root];
        for (int c : child) {
            if (!visited[c]) {
                early(c);
                dp[root][0] += dp[c][1];
                dp[root][1] += Math.min(dp[c][1], dp[c][0]);
            }
        }
    }
}

/*
그냥 레벨 단위로 뭉뚱그려서 얼리어답터 레벨과 얼리어답터가 아닌 레벨로 나눠서 생각했는데 틀림.
부모가 얼리어답터가 아니면 자식은 얼리어답터여야 하지만 부모가 얼리어답터이면 자식은 얼리어답터일수도 있고 아닐수도 있음.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static ArrayList<Integer>[] map;
    public static int n;
    public static int[] level;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new ArrayList[n + 1];
        level = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);

            map[a].add(b);
            map[b].add(a);
        }

        leveling(0, 1);

        int oddans = 0;
        int evenans = 0;

        for (int i = 0; i < level.length; i++) {
            //해당 레벨에 노드들이 존재할때
            if (level[i] != 0) {
                //홀수 레벨의 경우
                if (i % 2 == 1) {
                    oddans += level[i];
                }
                //짝수 레벨의 경우
                else {
                    evenans += level[i];
                }
            }
            else{
                break;
            }
        }

        System.out.println(Math.min(oddans, evenans));
    }

    //레벨순위하면서 레벨별로 얼마나 많은 노드들이 있는지 확인. 레벨 짝수, 홀수끼리 다 더한 값이 더 작은걸로 답을 내기 위함.
    //bfs처럼 확인한다.
    public static void leveling(int depth, int root) {
        visited[root] = true;
        level[depth] ++;
        for (int next : map[root]) {
            if (!visited[next]) {
                leveling(depth + 1, next);
            }
        }
    }
}

*/