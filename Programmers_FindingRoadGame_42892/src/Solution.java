import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

class Solution {
    public static HashMap<Integer, int[]> map;
    public static int[][] nodeinfo;

    public int[][] solution(int[][] nodeinfo) {
        int nodeCount = nodeinfo.length;
        int[][] answer = new int[2][nodeCount];
        map = new HashMap<>();
        this.nodeinfo = nodeinfo;

        Arrays.sort(nodeinfo, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o2[1] - o1[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        return answer;
    }
}