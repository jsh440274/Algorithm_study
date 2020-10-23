import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] linemap = new int[n + 1][2];

        ArrayList<Integer>[] map = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);

            map[a].add(b);
            map[b].add(a);

            linemap[i + 1][0] = a;
            linemap[i + 1][1] = b;
        }

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int t = Integer.parseInt(line[0]);
            int k = Integer.parseInt(line[1]);

            //단절점인지 구분
            if (t == 1) {
                ArrayList<Integer> temp = map[k];
                if (temp.size() == 1) {
                    System.out.println("no");
                } else {
                    System.out.println("yes");
                }
            }
            //단절선인지 구분
            else {
                System.out.println("yes");
            }
        }
    }
}
