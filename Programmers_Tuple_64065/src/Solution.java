import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        StringTokenizer st = new StringTokenizer(s, "{|}");
        ArrayList<node> al = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        while (st.hasMoreTokens()) {
            String temp = st.nextToken();
            if (temp.equals(",")) continue;
            else {
                al.add(new node(temp));
            }
        }

        Collections.sort(al, Collections.reverseOrder());
        answer = new int[al.size()];
        int index = 0;

        for (int i = 0; i < al.size(); i++) {
            String[] temp = al.get(i).s.split(",");
            for (int j = 0; j < temp.length; j++) {
                int input = Integer.parseInt(temp[j]);
                if (!set.contains(input)) {
                    set.add(input);
                    answer[index] = input;
                    index++;
                }
            }
        }

        return answer;
    }

    public class node implements Comparable<node> {
        String s;

        public node(String s) {
            this.s = s;
        }

        @Override
        public int compareTo(node target) {
            if (target.s.length() > this.s.length()) {
                return 1;
            } else if (target.s.length() < this.s.length()) {
                return -1;
            }
            return 0;
        }
    }
}