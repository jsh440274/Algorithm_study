public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int n1 = 3;
        int n2 = 5;
        int n3 = 2;
        String[] words1 = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        String[] words2 = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        String[] words3 = {"hello", "one", "even", "never", "now", "world", "draw"};
        int[] res1 = s.solution(n1, words1);
        int[] res2 = s.solution(n2, words2);
        int[] res3 = s.solution(n3, words3);

        print(res1);
        print(res2);
        print(res3);
    }

    public static void print(int[] res) {
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
