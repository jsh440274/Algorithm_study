public class Main {
    public static void main(String[] args) {
        Solution no1 = new Solution();

        String dirs1 = "ULURRDLLU";
        String dirs2 = "LULLLLLLU";

        int res1 = no1.solution(dirs1);
        System.out.println(res1);
        int res2 = no1.solution(dirs2);
        System.out.println(res2);
    }
}
