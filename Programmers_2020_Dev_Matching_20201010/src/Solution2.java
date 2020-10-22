import java.util.*;

public class Solution2 {
    public String solution(String p, int n) {
        StringBuffer answer = new StringBuffer();
        int[] ians = new int[3];

        String[] ampmp = p.split(" ");
        String[] pretime = ampmp[1].split(":");

        if (pretime[0].equals("12")) {
            pretime[0] = "00";
        }

        int tentime = Integer.parseInt(pretime[0]) * 3600 + Integer.parseInt(pretime[1]) * 60 + Integer.parseInt(pretime[2]) + n;

        if (ampmp[0].equals("PM")) {
            tentime += (3600 * 12);
        }

        for (int i = 0; i < 3; i++) {
            int inputtime = tentime % 60;
            ians[i] = inputtime;
            tentime /= 60;
        }

        while (ians[2] >= 24) {
            ians[2] -= 24;
        }

        for (int i = 2; i >= 0; i--) {
            String temp = String.valueOf(ians[i]);
            if (temp.length() <= 1) {
                answer.append(0);
            }
            answer.append(temp);
            if (i != 0) {
                answer.append(":");
            }
        }

        return answer.toString();
    }
}