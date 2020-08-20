public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        String s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        String s3 = "{{20,111},{111}}";
        String s4 = "{{123}}";
        String s5 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";

        int[] res1 = s.solution(s1);
        int[] res2 = s.solution(s2);
        int[] res3 = s.solution(s3);
        int[] res4 = s.solution(s4);
        int[] res5 = s.solution(s5);

        print(res1);
        print(res2);
        print(res3);
        print(res4);
        print(res5);
    }

    public static void print(int[] a){
        for(int i : a){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
