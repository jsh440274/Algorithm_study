import java.util.ArrayList;

class Solution {
    public static ArrayList<Character>[] map;
    public static ArrayList<Boolean>[] erase;
    public static int answer = 0;

    public int solution(int m, int n, String[] board) {
        map = new ArrayList[n];
        erase = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
            erase[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                map[i].add(board[j].charAt(i));
                erase[i].add(false);
            }
        }

        while (erasing()) ;

        return answer;
    }

    public static boolean erasing() {
        boolean iserasing = false;
        //여기서 애들을 지워......
        //쥰내 지워....
        pairing();
        for (int i = map.length - 1; i >= 0; i--) {
            for (int j = map[i].size() - 1; j >= 0; j--) {
                if (erase[i].get(j)) {
                    map[i].remove(j);
                    erase[i].remove(j);
                    answer++;
                    iserasing = true;
                }
            }
        }
        return iserasing;
    }

    public static void pairing() {
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[i].size(); j++) {
                char temp = map[i].get(j);
                if (j >= map[i - 1].size()) continue;
                if (map[i - 1].get(j - 1) == temp && map[i - 1].get(j) == temp && map[i].get(j - 1) == temp) {
                    erase[i].remove(j);
                    erase[i].add(j, true);
                    erase[i - 1].remove(j);
                    erase[i - 1].add(j, true);
                    erase[i].remove(j - 1);
                    erase[i].add(j - 1, true);
                    erase[i - 1].remove(j - 1);
                    erase[i - 1].add(j - 1, true);
                }
            }
        }
    }
}