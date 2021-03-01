import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int ret = 0;

        for (int l = 0; l < 8; l++) {
            String line = br.readLine();

            if (l % 2 == 0) {
                for (int i = 0; i < 8; i += 2) {
                    if (line.charAt(i) == 'F') {
                        ret++;
                    }
                }
            } else {
                for (int i = 1; i < 8; i += 2) {
                    if (line.charAt(i) == 'F') {
                        ret++;
                    }
                }
            }
        }

        System.out.println(ret);
    }
}