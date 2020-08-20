public class Main {
    public static void main(String[] args) {
        no1 no1 = new no1();
        int n = 6;
        int[] s = {7, 10};

        long res1_ = no1.solution(n, s);
        System.out.println(res1_);

//        no2 no2 = new no2();
//        res2_ = no1.solution();

    }


    public static void print(int[] res) {
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}
