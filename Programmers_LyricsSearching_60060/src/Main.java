public class Main {
    public static void main(String[] args) {
        Solution no1 = new Solution();

        String[] q1 = {"fro??", "????o", "fr???", "fro???", "pro?", "??????"};
        String[] word1 = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
//        String[] q1 = {"????", "?????", "??????", "???????"};
        int[] res1 = no1.solution(word1, q1);
//        String[] word1 = {"fffff", "rrrr", "ssss", "ddddd", "eeeee", "eeees"};
//        String[] q1 = {"????", "?????", "??????", "???????", "????", "?????"};
//        int[] res1 = no1.solution(word1, q1);
        print(res1);
    }

    public static void print(int[] res) {
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
