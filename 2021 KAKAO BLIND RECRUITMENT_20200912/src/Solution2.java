import java.util.*;

class Solution2 {
    public static HashMap<Integer, HashMap<String, Integer>> bigmap = new HashMap<>();
    public static Set<String> visited = new HashSet<>();
    public static String order = "";

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};

        for (int i = 0; i < orders.length; i++) {
            order = orders[i];
            visited = new HashSet<>();
            for (int j = 0; j < order.length() - 1; j++) {
                makeCourse(j + 1, order.substring(j, j + 1));
            }
        }

        ArrayList<String> retal = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            ArrayList<String> temp = new ArrayList<>();
            int max = 0;
            if (!bigmap.containsKey(course[i])) {
                continue;
            }
            HashMap<String, Integer> t = bigmap.get(course[i]);
            Set<String> keys = t.keySet();
            for (String key : keys) {
                if (t.get(key) >= max) {
                    if (t.get(key) > max) {
                        temp = new ArrayList<>();
                    }
                    temp.add(key);
                    max = t.get(key);
                }
            }
            if (max != 1) {
                retal.addAll(temp);
            }
        }

        answer = new String[retal.size()];
        for (int i = 0; i < retal.size(); i++) {
            answer[i] = retal.get(i);
        }

        Arrays.sort(answer);

        return answer;
    }

    public static void makeCourse(int index, String sb) {
        int length = sb.length();
        HashMap<String, Integer> temp = bigmap.getOrDefault(length + 1, new HashMap<String, Integer>());
        for (int i = index; i < order.length(); i++) {
            char[] input2 = (sb + order.charAt(i)).toCharArray();
            Arrays.sort(input2);
            StringBuffer sssss = new StringBuffer();
            for (int j = 0; j < input2.length; j++) {
                sssss.append(input2[j]);
            }
            String input = sssss.toString();
            int num = temp.getOrDefault(input, 0);
            if (!visited.contains(input)) {
                temp.put(input, num + 1);
                visited.add(input);
                bigmap.put(length + 1, temp);
            }
            makeCourse(i + 1, sb);
            makeCourse(i + 1, input);
        }
    }
}