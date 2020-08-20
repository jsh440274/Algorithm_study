import java.util.ArrayList;

class no2 {
    public long solution(long n) {
        long answer = 0;
        int exp = 0, count = 1;
        ArrayList<Long> ans_al = new ArrayList<>();
        ans_al.add(0, (long) 1);
        while (count < n) {
            exp++;
            long newnum = (long) Math.pow(3, exp);
            ArrayList<Long> big_al = new ArrayList<>();
            big_al.addAll(ans_al);
            big_al.add(newnum);
            count++;
            if (count == n) {
                return big_al.get(count - 1);
            }
            for (int i = 0; i < ans_al.size(); i++) {
                big_al.add(newnum + ans_al.get(i));
                count++;
                if (count == n) {
                    return big_al.get(count - 1);
                }
            }
            ans_al = big_al;
        }
        return answer;
    }
}