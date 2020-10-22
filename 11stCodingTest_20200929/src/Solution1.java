// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution1 {
    public int solution(String S) {
        // write your code in Java SE 8
        int answer = 0;
        int acount = 0;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'a') {
                if (acount == 2) {
                    return -1;
                }
                acount++;
            } else {
                answer += 2 - acount;
                acount = 0;
            }
        }
        answer += 2 - acount;

        return answer;
    }
}
