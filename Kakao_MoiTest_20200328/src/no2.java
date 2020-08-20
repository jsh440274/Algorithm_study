import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class no2 {
    public int[] solution(String s) {
        int[] answer;
        Set<Integer> ans_set = new HashSet<>();
        ArrayList<tuple> tempans = new ArrayList<>();
        ArrayList<Integer> ans_al = new ArrayList<>();

        String substring = s.substring(1, s.length() - 1);
        String[] tuples = substring.split("\\{|\\}");


        for (int i = 0; i < tuples.length; i++) {
            if (!tuples[i].equals("") && !tuples[i].equals(",")) {
                tuple t = new tuple(tuples[i]);
                tempans.add(t);
            }
        }
        Collections.sort(tempans);

        for (int i = 0; i < tempans.size(); i++) {
            String[] temp = tempans.get(i).a.split(",");
            for (int j = 0; j < temp.length; j++) {
                int x = Integer.parseInt(temp[j]);
                if (!ans_set.contains(x)) {
                    ans_al.add(x);
                    ans_set.add(x);
                }
            }
        }

        answer = new int[ans_al.size()];

        for (int i = 0; i < ans_al.size(); i++) {
            answer[i] = ans_al.get(i);
        }

        return answer;
    }

    public class tuple implements Comparable<tuple> {
        public String a;

        public tuple(String b) {
            a = b;
        }

        @Override
        public int compareTo(tuple o) {
            if (this.a.length() > o.a.length()) {
                return 1;
            } else if (this.a.length() < o.a.length()) {
                return -1;
            }
            return 0;
        }
    }
}
