public class Main {
    public static void main(String[] args) {
        Solution no1 = new Solution();


        int n1 = 5;
        int n2 = 5;
        int bf1[][] = {{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}};
        int bf2[][] = {{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}};

        int[][] res1 = no1.solution(n1, bf1);
        int[][] res2 = no1.solution(n2, bf2);

        print(res1);
        print(res2);


    }

    public static void print(int[] res) {
        for (int i : res) {
            System.out.println(i + " ");
        }
        System.out.println();
    }


    public static void print(int[][] res) {
        System.out.print("{");
        for (int[] i : res) {
            System.out.print("{");
            for (int j : i) {
                System.out.print(j + ", ");
            }
            System.out.println("}");
        }
        System.out.println("}");
    }
}
