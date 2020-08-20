public class Main {
    public static void main(String[] args) {
        Solution no1 = new Solution();

        String[][] tickets1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        String[][] tickets3 = {{"ICN", "COO"}, {"ICN", "BOO"}, {"COO", "ICN"}, {"BOO", "DOO"}};

//        String[] res1 = no1.solution(tickets1);
//        print(res1);
//        String[] res2 = no1.solution(tickets2);
//        print(res2);
        String[] res3 = no1.solution(tickets3);
        print(res3);
    }

    public static void print(String[] res) {
        for (String i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
