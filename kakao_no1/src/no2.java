import java.util.*;

public class no2 {
    public int[] solution(String s) {
        int[] answer = {};
        ArrayList<Integer> nums = new ArrayList<>();


        String[] split_s = s.split("\\{|}");
        ArrayList<String> tuples = new ArrayList<>();

        for (int i = 0; i < split_s.length; i++) {
            if (split_s[i].equals("") || split_s[i].equals(",")) {
                continue;
            } else {
                tuples.add(split_s[i]);
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        int index = tuples.size();

        for (int i = 0; i < tuples.size(); i++) {
            for (int j = 0; j < tuples.size() - i - 1; j++) {
                if (tuples.get(j).length() > tuples.get(j + 1).length()) {
                    String temp = tuples.get(j + 1);
                    tuples.add(j + 1, tuples.get(j));
                    tuples.add(j, temp);
                }
            }
        }
        for (int i = 0; i < index; i++) {
            String[] tuple = tuples.get(i).split(",");
            for (int k = 0; k < tuple.length; k++) {
                int num = Integer.parseInt(tuple[k]);
                if (queue.contains(num))
                    continue;
                else {
                    queue.add(num);
                }
            }
        }


        answer = new int[queue.size()];
        int j = 0;

        while (!queue.isEmpty()) {
            answer[j] = queue.poll();
            j++;
        }


        return answer;
    }

    public void print(String s) {
        int[] a = solution(s);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
    }
}

