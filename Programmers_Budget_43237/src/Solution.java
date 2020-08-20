//import java.util.LinkedList;
//import java.util.Queue;
//
//class Solution {
//    public int solution(int[] budgets, int M) {
//        int answer = 0, n = budgets.length, mid = M / n;
//
//        Queue<Integer> q = new LinkedList<>();
//
//        for (int bud : budgets) {
//            if (bud <= mid) {
//                M -= bud;
//                n--;
//            } else {
//                q.offer(bud);
//            }
//        }
//
//        while (answer != mid) {
//            int i = 0;
//            answer = mid;
//            while (i < q.size() && n != 0) {
//                mid = M / n;
//                int bud = q.poll();
//                if (bud <= mid) {
//                    M -= bud;
//                    n--;
//                } else {
//                    q.offer(bud);
//                }
//                i++;
//            }
//        }
//
//        return answer;
//    }
//}

class Solution {
    public int solution(int[] budgets, int M) {
        int answer = 0;
        long sum = 0;
//        int start = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;

        for (int b : budgets) {
            if (end < b) {
                end = b;
            }
            sum += b;
//            if (start > b) {
//                start = b;
//            }
        }

        if(sum <= M){
            return end;
        }

        int premid = 0;
        while (start < end) {
            answer = (start + end) / 2;
            if(premid == answer){
                break;
            }
            long m2 = 0;
            for (int b : budgets) {
                if (answer >= b) {
                    m2 += b;
                } else {
                    m2 += answer;
                }
            }
            if (m2 == M) {
                return answer;
            } else if (m2 > M) {
                end = answer;
            } else {
//                start = answer + 1;
                start = answer;
            }
            premid = answer;
        }
        return answer;
    }
}