public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        String s1 = "CBD";
        String[] s2 = {"BACDE", "CBADF", "AECB", "BDA"};

        int ans = s.solution(s1, s2);

        System.out.println(ans);
    }
}
