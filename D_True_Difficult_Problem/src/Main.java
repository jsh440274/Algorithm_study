import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int node_num = Integer.parseInt(sc.nextLine());
        String node_line = sc.nextLine();
        String[] nodes = node_line.split(" ");
        int[][] path = new int[node_num][node_num];
        for (int i = 0; i < node_num - 1; i++) {
            String line = sc.nextLine();
            String[] lines = line.split(" ");
            int src = Integer.parseInt(lines[0]) - 1;
            int dst = Integer.parseInt(lines[1]) - 1;
            path[src][dst] = 1;
            path[dst][src] = 1;
        }

        HashMap<String, int[]> color_index_count = new HashMap<>();
        for (int i = 0; i < nodes.length; i++) {
            int[] temp = {i, 1};
            if (color_index_count.containsKey(nodes[i])) {
                temp[1] = 0;
                color_index_count.replace(nodes[i], temp);
            } else {
                color_index_count.put(nodes[i], temp);
            }
        }

        Iterator itr = color_index_count.entrySet().iterator();
        ArrayList<Integer> result = new ArrayList<>();

        while (itr.hasNext()) {
            Map.Entry<String, int[]> e = (Map.Entry<String, int[]>) itr.next();
            int[] value = e.getValue();
            if (value[1] == 1) {
                Set<String> visited_color = new HashSet<>();
                int[][] temp_path = path;
                if (isRoot(path, visited_color, value[0], nodes)) {
                    result.add(value[0] + 1);
                }
            }
        }

        int result_first = 0;
        int result_second = 0;
        int result_third = 0;

        for (int i = 0; i < result.size(); i++) {
            int num = result.get(i);
            result_first += 1;
            result_second += num;
            result_third += (num * num);
        }

        System.out.println(result_first);
        System.out.println(result_second);
        System.out.println(result_third);
    }
    static boolean isRoot(int[][] paths, Set<String> visited_color, int index, String[] nodes) {
        if (!visited_color.contains(nodes[index])) {
            visited_color.add(nodes[index]);
            for (int i = 0; i < paths.length; i++) {
                if (paths[index][i] == 1) {
                    paths[index][i] = 0;
                    paths[i][index] = 0;
                    if (!isRoot(paths, visited_color, i, nodes)) {
                        return false;
                    }
                }
            }
            return true;
        }
        else{
            return false;
        }
    }
}