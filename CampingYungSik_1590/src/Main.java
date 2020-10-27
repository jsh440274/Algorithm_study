import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]);
        long standard = Long.parseLong(line[1]);
        long waitingtime = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            line = br.readLine().split(" ");
            long time = standard - Long.parseLong(line[0]);
            long interval = Long.parseLong(line[1]);
            long count = Long.parseLong(line[2]);
            if (time + (interval * count) < 0) {
                continue;
            } else {
                if (time <= 0) {
                    time = Math.abs(time);
                    time %= interval;
                } else {
                    time %= interval;
                    time = interval - time;
                }
                waitingtime = Math.min(waitingtime, time);
            }
        }

        if (waitingtime == Long.MAX_VALUE) {
            System.out.println("-1");
        }
        System.out.println(waitingtime);
    }
}
