import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int answer = N;
            score[] map = new score[N];
            for (int n = 0; n < N; n++) {
                int paper = sc.nextInt();
                int interview = sc.nextInt();
                map[n] = new score(paper, interview);
            }
            Arrays.sort(map);
            int maxinterview = map[0].interview;
            for (int j = 1; j < N; j++) {
                //서류 등수가 높은 순 -> j 이전 데이터 중 가장 높은 면접 등수와만 비교하면 됨
                int cur = map[j].interview; //현재 검사하는 지원자의 면접 등수
                if (maxinterview < cur) {//저장된 면접 등수보다 낮으면
                    maxinterview = cur;//max값 업데이트
                }
                if (cur < maxinterview)//높으면
                    answer--;//감소
            }

            System.out.println(answer);
        }
    }

    public static class score implements Comparable<score> {
        public int paper;
        public int interview;

        public score(int paper, int interview) {
            this.paper = paper;
            this.interview = interview;
        }

        @Override
        public int compareTo(score o) {
            return o.paper - this.paper;
        }
    }
}
