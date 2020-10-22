// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution3 {
    public static final int MAXVAL = 1000000000;

    public int solution(int[] A) {
        // write your code in Java SE 8
        int answer = 0;
        int[] countmap = new int[A.length + 1];

        for (int i = 0; i < A.length; i++) {
            countmap[A[i]]++;
        }
        for (int i = 1; i < countmap.length; i++) {
            if (countmap[i] == 0) {
                int j = 1;
                while (true) {
                    if (i - j > 0 && countmap[i - j] > 1) {
                        countmap[i - j]--;
                        countmap[i] = 1;
                        answer += j;
                        break;
                    } else if (i + j < countmap.length && countmap[i + j] > 1) {
                        countmap[i + j]--;
                        countmap[i] = 1;
                        answer += j;
                        break;
                    }
                    j++;
                }
            }
        }

        if (answer > MAXVAL) {
            return -1;
        }
        return answer;
    }
}
