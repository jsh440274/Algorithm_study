public class Main {
    public static void main(String[] args) {
        Solution no1 = new Solution();
        int n1 = 4;
        int n2 = 1;
        int n3 = 3;
        int[] wo1 = {4, 3, 3};
        int[] wo2 = {2, 1, 2};
        int[] wo3 = {1, 1};
//        long res1 = no1.solution(n1, wo1);
//        System.out.println(res1);
        long res2 = no1.solution(n2, wo2);
        System.out.println(res2);
        long res3 = no1.solution(n3, wo3);
        System.out.println(res3);
    }
}
