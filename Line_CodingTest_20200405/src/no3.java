import java.util.ArrayList;

public class no3 {
    public int solution(String road, int n) {
        int answer = -1;
        ArrayList<Integer> broken = new ArrayList<>();
        for (int i = 0; i < road.length(); i++) {
            if (road.charAt(i) == '0') {
                broken.add(i);
            }
        }

        if (broken.size() <= n) {
            return road.length();
        }
        broken.add(road.length());

        for (int i = 0; i < broken.size() - n - 1; i++) {
            int a = broken.get(i + n + 1);
            int b = broken.get(i);
            answer = Math.max(a - b - 1, answer);
        }

        answer = Math.max(answer, broken.get(n));
        answer = Math.max(road.length() - broken.get(broken.size() - n - 1), answer);

        return answer;
    }

//
//    public static int[] brokenarr;
//    public static boolean[] visited;
//    public static int answer = -1;
//    public static String road;
//
//    public int solution(String road, int n) {
//        ArrayList<Integer> broken = new ArrayList<>();
//        this.road = road;
//        for (int i = 0; i < road.length(); i++) {
//            if (road.charAt(i) == '0') {
//                broken.add(i);
//            }
//        }
//        if (broken.size() <= n) {
//            return road.length();
//        }
//        brokenarr = new int[broken.size()];
//        visited = new boolean[broken.size()];
//        for (int i = 0; i < broken.size(); i++) {
//            brokenarr[i] = broken.get(i);
//        }
//        pickn(n);
//        return answer;
//    }
//
//    public void pickn(int n) {
//        if (n == 0) {
//            int longest = 0;
//            int pre = 0;
//            for (int i = 1; i < brokenarr.length; i++) {
//                if (!visited[i]) {
//                    int temp = brokenarr[i] - pre - 1;
//                    longest = Math.max(longest, temp);
//                    pre = brokenarr[i];
//                }
//            }
//            answer = Math.max(longest, road.length() - pre);
//            return;
//        }
//        for (int i = 0; i < brokenarr.length; i++) {
//            if (!visited[i]) {
//                visited[i] = true;
//                pickn(n - 1);
//                visited[i] = false;
//            }
//        }
//    }
}
/*문제 설명
군데군데 손상된 도로가 있습니다. 이 도로를 적절하게 보수하여, 자동차 경주 대회를 열려고 합니다. 자동차 경주 대회가 열리려면, 손상되지 않은 최대한 긴 구간이 필요합니다. 아래는 도로의 손상된 부분을 0, 정상적인 부분을 1로 나타낸 예시입니다.

111011110011111011111100011111
만약 도로의 손상된 부분을 최대 3곳까지만 보수할 수 있는 재료가 있다면, 아래와 같이 도로를 보수하여 길이가 18인 정상 도로 구간을 만들 수 있습니다.

1110(111111111111111111)00011111
도로를 보수해서 만들 수 있는 가장 긴 정상 도로 구간의 길이를 구해주세요.

제한 사항
road는 도로의 상태를 나타냅니다.
road는 길이 1 이상 300,000 이하인 문자열입니다.
road는 0과 1로만 이루어져 있습니다.
도로의 손상된 부분을 0, 정상 부분은 1로 나타냅니다.
n은 보수 가능한 최대 횟수를 의미합니다.
n은 0 이상 300,000 이하인 자연수입니다.
만들 수 있는 가장 긴 정상 도로 구간의 길이를 return 하면 됩니다.
입출력 예
road	n	result
"111011110011111011111100011111"	3	18
"001100"	5	6*/