public class Main {
    public static void main(String[] args) {
        no1.Solution no1 = new no1.Solution();
        String[] oper1 = {"I 16", "D 1"};
        String[] oper2 = {"I 7", "I 5", "I -5", "D -1"};

        int[] res1 = no1.solution(oper1);
        print(res1);
        int[] res2 = no1.solution(oper2);
        print(res2);


    }

    public static void print(int[] res) {
        for (int r : res) {
            System.out.print(r + " ");
        }
        System.out.println();
    }
}
