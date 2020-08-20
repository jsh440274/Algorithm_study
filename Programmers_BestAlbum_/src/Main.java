public class Main {
    public static void main(String[] args) {
        Solution no1 = new Solution();

        String[] gen1 = {"classic", "pop", "classic", "classic", "pop"};
        int[] s1 = {500, 600, 150, 800, 2500};
        int[] res1 = no1.solution(gen1, s1);
        print(res1);

    }

    public static void print(int[] res) {
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
