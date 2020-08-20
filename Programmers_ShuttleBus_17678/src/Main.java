public class Main {
    public static void main(String[] args) {
        Solution no1 = new Solution();

        int n1 = 1;
        int t1 = 1;
        int m1 = 5;
        String[] tt1 = {"08:00", "08:01", "08:02", "08:03"};
        int n2 = 2;
        int t2 = 10;
        int m2 = 2;
        String[] tt2 = {"09:10", "09:09", "08:00"};
        int n3 = 2;
        int t3 = 1;
        int m3 = 2;
        String[] tt3 = {"09:00", "09:00", "09:00", "09:00"};
        int n4 = 1;
        int t4 = 1;
        int m4 = 5;
        String[] tt4 = {"00:01", "00:01", "00:01", "00:01", "00:01"};
        int n5 = 1;
        int t5 = 1;
        int m5 = 1;
        String[] tt5 = {"23:59"};
        int n6 = 10;
        int t6 = 60;
        int m6 = 45;
        String[] tt6 = {"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59",
                "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};

        String res1 = no1.solution(n1, t1, m1, tt1);
        System.out.println(res1);
        String res2 = no1.solution(n2, t2, m2, tt2);
        System.out.println(res2);
        String res3 = no1.solution(n3, t3, m3, tt3);
        System.out.println(res3);
        String res4 = no1.solution(n4, t4, m4, tt4);
        System.out.println(res4);
        String res5 = no1.solution(n5, t5, m5, tt5);
        System.out.println(res5);
        String res6 = no1.solution(n6, t6, m6, tt6);
        System.out.println(res6);
    }

    public static void print(int[] res) {
        for (int i : res) {
            System.out.println(i + " ");
        }
        System.out.println();
    }
}
