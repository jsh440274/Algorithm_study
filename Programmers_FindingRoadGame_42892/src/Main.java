public class Main {
    public static void main(String[] args) {
        Solution no1 = new Solution();

        int[][] ni1 = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};
        int[][] res1 = no1.solution(ni1);
        print(res1);
    }

    public static void print(int[] res) {
        for (int i : res) {
            System.out.println(i + " ");
        }
        System.out.println();
    }

    public static void print(int[][] res) {
        StringBuilder sb = new StringBuilder();
        for (int[] i : res) {
            sb.append("{");
            for (int j : i) {
                sb.append(j + ",");
            }
            sb.append("},");
        }
        sb.substring(0, sb.length() - 1);
        System.out.println(sb.toString());
    }
}
