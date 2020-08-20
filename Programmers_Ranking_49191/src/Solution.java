//import java.util.HashMap;
//import java.util.Set;
//
//class Solution {
//    public int solution(int n, int[][] results) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int answer = 0;
//
//        for (int[] i : results) {
//            int winner = i[0];
//            int loser = i[1];
//
//            if (!map.containsKey(winner)) {
//                if (!map.containsKey(loser)) {//winner x loser x
//                    map.put(winner, 1);
//                    map.put(loser, 2);
//                } else {// winner x loser o
//                    if (map.get(loser) == 1) {
//                        map.put(loser, 3);
//                    }
//                }
//            } else {
//                if (map.get(winner) == 2) {
//                    map.put(winner, 3);
//                }
//                if (!map.containsKey(loser)) {//winner o loser x
//                    map.put(loser, 2);
//                } else {//winner o loser 0 continue;
//                    if (map.get(loser) == 1) {
//                        map.put(loser, 3);
//                    }
//                }
//            }
//        }
//
//        answer = n - map.size();
//
//        Set<Integer> kesSet = map.keySet();
//        for (int key : kesSet) {
//            if (map.get(key) == 1 || map.get(key) == 2) {
//                answer++;
//            }
//        }
//
//        return answer;
//    }
//}

import java.util.ArrayList;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] map = new int[n + 1][n + 1];
        for (int i = 0; i < results.length; i++) {
            int winner = results[i][0];
            int loser = results[i][1];
            map[winner][loser] = 1;
            map[loser][winner] = 2;
        }

        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 1; i < n + 1; i++) {
                ArrayList<Integer> winner = new ArrayList<>();
                ArrayList<Integer> loser = new ArrayList<>();
                boolean flag = true;
                int rank = n;
                for (int j = 1; j < n + 1; j++) {
                    if (j == i) continue;
                    if (map[i][j] == 0 || map[i][i] != 0) {
                        flag = false;
                        break;
                    } else if (map[i][j] == 1) {
                        winner.add(j);
                        rank--;
                    } else {
                        loser.add(j);
                    }
                }
                if (flag) {
                    map[i][i] = rank;
                    answer++;
                    if (winner.size() != 0 && loser.size() != 0) {
                        for (int k = 0; k < winner.size(); k++) {
                            int a = winner.get(k);
                            for (int l = 0; l < loser.size(); l++) {
                                int b = loser.get(l);
                                if (map[a][b] == 0 || map[b][a] == 0) {
                                    changed = true;
                                }
                                map[a][b] = 2;
                                map[b][a] = 1;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }
}