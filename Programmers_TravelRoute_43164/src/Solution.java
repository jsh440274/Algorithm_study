import java.util.*;

class Solution {
    public static HashMap<String, ArrayList<destination>> map;
    public static HashMap<Integer, Boolean> visited;
    public static String[][] tickets;
    public static String[] answer;
    public static Stack<String> ans_stack;
    public static boolean flag;

    public String[] solution(String[][] tickets) {
        map = new HashMap<>();
        visited = new HashMap<>();
        flag = false;
        this.tickets = tickets;

        for (int i = 0; i < tickets.length; i++) {
            String key = tickets[i][0];
            String value = tickets[i][1];
            ArrayList<destination> temp = map.getOrDefault(key, new ArrayList<>());
            temp.add(new destination(value, i));
            map.put(key, temp);
            visited.put(i, false);
        }
        answer = new String[tickets.length + 1];
        ans_stack = new Stack<>();
        visited.put(0, false);

        bfs("ICN", tickets.length);

        answer[0] = "ICN";
        int i = 1;
        while (!ans_stack.isEmpty()) {
            answer[i] = ans_stack.pop();
            i++;
        }

        return answer;
    }

    public static void bfs(String city, int depth) {
        if (depth == 0) {
            for (int i = 0; i < tickets.length; i++) {
                if (!visited.get(i)) return;
            }
            flag = true;
        } else {
            ArrayList<destination> next_al = map.get(city);
            if (!map.containsKey(city)) return;
            Collections.sort(next_al);
            for (int i = 0; i < next_al.size(); i++) {
                destination n = next_al.get(i);
                String next_city = n.city;
                int index = n.ticket_index;
                if (visited.get(index)) continue;
                visited.put(index, true);
                bfs(next_city, depth - 1);
                if (flag) {
                    ans_stack.push(next_city);
                    return;
                }
                visited.put(index, false);
            }
        }
    }

    public class destination implements Comparable<destination> {
        String city;
        int ticket_index;

        public destination(String city, int index) {
            this.city = city;
            this.ticket_index = index;
        }

        @Override
        public int compareTo(destination o) {
            for (int i = 0; i < this.city.length(); i++) {
                if (this.city.charAt(i) < o.city.charAt(i)) {
                    return -1;
                } else if (this.city.charAt(i) > o.city.charAt(i)) {
                    return 1;
                }
            }
            return 0;
        }
    }
}