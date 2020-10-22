import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Integer>[] map;
    public static boolean[] visited;
    public static int[] parentmap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        parentmap = new int[n + 1];

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

        finding(1);

        for (int i = 2; i < parentmap.length; i++) {
            System.out.println(parentmap[i]);
        }

    }

    //dfs로 탐색 -> 그냥 이차원 배열로 했을 때 메모리 초과가 나서 리스트에 넣어놓고 탐색
    public static void finding(int root) {
//        for (int i = 0; i < map.length; i++) {
//            if (!visited[i] && map[root][i] != 0) {
//                visited[i] = true;
//                parentmap[i] = root;
//                finding(i);
//            }
//        }
        for (int node : map[root]) {
            if (!visited[node]) {
                visited[node] = true;
                parentmap[node] = root;
                finding(node);
            }
        }
    }

}
