public class Main {
    public static void main(String[] args) {
        Solution no1 = new Solution();

        String b1 = "hit";
        String t1 = "cog";
        String[] w1 = {"hot", "dot", "dog", "lot", "log", "cog"};
        String b2 = "hit";
        String t2 = "cog";
        String[] w2 = {"hot", "dot", "dog", "lot", "log"};

        int res1 = no1.solution(b1, t1, w1);
        System.out.println(res1);
        int res2 = no1.solution(b2, t2, w2);
        System.out.println(res2);
    }
}
