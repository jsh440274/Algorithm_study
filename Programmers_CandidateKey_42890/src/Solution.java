import java.util.ArrayList;

class Solution {
    public static int[] visited;
    public static String[][] relation;
    public static int answer;
    public static ArrayList<String> arr;

    public int solution(String[][] relation) {
        answer = 0;
        this.relation = relation;
        visited = new int[relation[0].length];
        for (int i = 1; i <= relation[0].length; i++) {
            makingCandidateKey(i, 0, new ArrayList<>());
        }
        return answer;
    }

    public static void makingCandidateKey(int depth, int index, ArrayList<String> indexes) {
        if (depth == 0) {
            arr = new ArrayList<>();
            for (int i = 0; i < relation.length; i++) {
                StringBuffer matching = new StringBuffer();
                for (int j = 0; j < indexes.size(); j++) {
                    matching.append(relation[i][Integer.parseInt(indexes.get(j))]);
                }
                String tempans = matching.toString();
                if (arr.contains(tempans)) {
                    return;
                }
                arr.add(tempans);
            }
            answer++;
            for (int j = 0; j < indexes.size(); j++) {
                visited[Integer.parseInt(indexes.get(j))] = 2;
            }
            return;
        } else {
            for (int i = index; i < visited.length; i++) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    indexes.add(String.valueOf(i));
                    makingCandidateKey(depth - 1, i, indexes);
                    indexes.remove(String.valueOf(i));
                    if (visited[i] == 1) {
                        visited[i] = 0;
                    }
                }
            }
        }
    }
}