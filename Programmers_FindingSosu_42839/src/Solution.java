import java.util.HashSet;
import java.util.Set;

class Solution {
    public static int answer = 0;
    public static boolean[] visited;
    public static Set<Integer> set = new HashSet<Integer>();

    public int solution(String numbers) {
        if (numbers.length() == 1) {
            return isSosu(Integer.parseInt(numbers)) ? 1 : 0;
        }
        char[] pnum = numbers.toCharArray();
        visited = new boolean[pnum.length];
        for (int i = 1; i <= pnum.length; i++) {
            pickNum(pnum, "", i);
        }
        answer = set.size();
        return answer;
    }

    public static void pickNum(char[] cnum, String num, int depth) {
        if (num.length() != 0 && depth == 0) {
            int t = Integer.parseInt(num);
            if (isSosu(t)) {
                set.add(t);
            }
            return;
        }
        for (int i = 0; i < cnum.length; i++) {
            if (!visited[i]) {
                num += cnum[i];
                visited[i] = true;
                depth--;
                pickNum(cnum, num, depth);
                num = num.substring(0, num.length() - 1);
                visited[i] = false;
                depth++;
            }
        }
    }

    public static boolean isSosu(int n) {
        int i = 0;
        int last = n / 2;   //약수가 없는 수가 소수이므로 2부터 n/2(자기자신/2)까지만 확인하면 됨
        if (n <= 1)//소수는 1보다 큰 자연수여야 함
        {
            return false;
        }
        //(자기자신/2)보다 큰수는 약수가 될 수 없음
        for (i = 2; i <= last; i++) //i를 2부터 last까지 1씩 증가시키며 반복 수행
        {
            if ((n % i) == 0) //n을 i로 나누었을때 나머지가 0이면(즉, i는 n의 약수가 아님)
            {
                return false; //소수가 아니므로 0반환(i가 약수이므로 n은 소수가 아님)
            }
        }
        return true; //1~last(자기자신/2)사이에 약수가 없으므로 소수임
    }
}