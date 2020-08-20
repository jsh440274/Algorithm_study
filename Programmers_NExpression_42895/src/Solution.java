import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

    public int solution(int n, int number) {
        if (n == number) {
            return 1;
        }
        int answer = -1;//n이 1이면 답 1
        ArrayList<Integer> one = new ArrayList<>();
        one.add(n);
        map.put(1, one);
        for (int i = 2; i <= 8; i++) {//할 수 있는 애들을 전부 만들어봄. 조합으루다가 만들어봄
            ArrayList<Integer> temp = making_expr(i);
            if (temp.contains(number)) {
                answer = i;
                break;
            }
            map.put(i, temp);
        }
        return answer;
    }

    public static ArrayList<Integer> making_expr(int i) {//조합을 만들어야 하네 5 = 4+1 || 3+2
        ArrayList res = new ArrayList();
        int n = map.get(1).get(0);
        int longest = n;
        for (int j = 1; j < i; j++) {
            longest *= 10;
            longest += n;
        }
        res.add(longest);

        for (int j = 1; j < i; j++) {
            ArrayList<Integer> t1 = map.get(j);
            ArrayList<Integer> t2 = map.get(i - j);
            ArrayList<Integer> temp = calc_two(t1, t2);
            for (int k = 0; k < temp.size(); k++) {
                if (!res.contains(temp.get(k))) {
                    res.add(temp.get(k));
                }
            }
        }

        return res;
    }

    public static ArrayList<Integer> calc_two(ArrayList<Integer> t1, ArrayList<Integer> t2) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < t1.size(); i++) {
            int a = t1.get(i);
            for (int j = 0; j < t2.size(); j++) {
                int b = t2.get(j);
                res.add(a + b);
                res.add(a - b);
                res.add(a * b);
                if (b != 0) {
                    res.add(a / b);
                }
            }
        }
        return res;
    }
}