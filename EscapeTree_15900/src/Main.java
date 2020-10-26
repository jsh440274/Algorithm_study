import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static boolean[] visited;
    public static ArrayList<Integer>[] map;
    public static int anscount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //리프노드까지 가면서 부모 노드들의 개수를 셈
        //리프노드의 부모들을 전부 더한 수가 짝수 -> yes

        int n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        map = new ArrayList[n + 1];
        anscount = 0;

        visited[0] = true;
        visited[1] = true;
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

        findingLeaf(1, 0);

        System.out.println(anscount % 2 == 0 ? "No" : "Yes");

    }

    public static void findingLeaf(int root, int parent) {
        boolean isLeaf = true;
        for (int i = 0; i < map[root].size(); i++) {
            int next = map[root].get(i);
            if (!visited[next]) {
                isLeaf = false;
                visited[next] = true;
                findingLeaf(next, parent + 1);
                visited[next] = false;
            }
        }
        if (isLeaf) {
            anscount += parent;
        }
    }
}