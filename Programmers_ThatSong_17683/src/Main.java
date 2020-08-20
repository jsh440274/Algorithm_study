public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        String m1 = "ABCDEFG";
        String m2 = "CC#BCC#BCC#BCC#B";
        String m3 = "ABC";

        String[] n1 = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String[] n2 = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
//        String[] n2 = {"03:00,03:30,FOO,FFF", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        String[] n3 = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        String res1 = s.solution(m1, n1);
        System.out.println(res1);
        String res2 = s.solution(m2, n2);
        System.out.println(res2);
        String res3 = s.solution(m3, n3);
        System.out.println(res3);
    }
}
