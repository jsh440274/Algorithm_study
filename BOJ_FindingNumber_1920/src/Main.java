import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    //먼저 풀었던 숫자 카드 문제와 완전히 일치
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Integer> set = new HashSet<>();
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());

        String[] line = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(line[i]));
        }

        int m = Integer.parseInt(br.readLine());

        line = br.readLine().split(" ");

        for (int i = 0; i < m; i++) {
            sb.append(set.contains(Integer.parseInt(line[i])) ? 1 : 0);
            if(i != m-1){
                sb.append(' ');
            }
        }
        System.out.println(sb.toString());
    }
}