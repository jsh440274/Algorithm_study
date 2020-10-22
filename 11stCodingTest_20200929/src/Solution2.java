// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

import java.util.HashMap;

class Solution2 {
    public int[] solution(String[] S) {
        // write your code in Java SE 8
        int[] answer = {};
        int n = S.length;
        int m = S[0].length();
        char[][] cmap = new char[n][m];

        for (int i = 0; i < n; i++) {
            cmap[i] = S[i].toCharArray();
        }

        for (int j = 0; j < m; j++) {
            boolean continuing = true;
            HashMap<Character, Integer> temphashmap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (temphashmap.containsKey(cmap[i][j])) {
                    answer = new int[3];
                    answer[0] = temphashmap.get(cmap[i][j]);
                    answer[1] = i;
                    answer[2] = j;
                    continuing = false;
                    break;
                } else {
                    temphashmap.put(cmap[i][j], i);
                }
            }
            if (!continuing) break;
        }

        return answer;
    }
}
