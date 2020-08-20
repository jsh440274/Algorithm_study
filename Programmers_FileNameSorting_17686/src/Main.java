public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        String[] fn1 = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String[] fn2 = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};

        String[] res1 = s.solution(fn1);
        print(res1);
        String[] res2 = s.solution(fn2);
        print(res2);
    }

    public static void print(String[] res) {
        for (String i : res) {
            System.out.print("\"" + i + "\"" + " ");
        }
        System.out.println();
    }
}
