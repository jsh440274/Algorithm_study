import java.util.ArrayList;

class Solution {
    public int solution(String str1, String str2) {//공집합일때 생각.
        double answer = 0;
        double intersect = 0;
        double union = 0;
        ArrayList<String> a_set = new ArrayList<>();
        ArrayList<String> b_set = new ArrayList<>();
        ArrayList<String> temp_set = new ArrayList<>();

        String a_string = str1.toLowerCase();
        String b_string = str2.toLowerCase();

        for (int i = 2; i <= a_string.length(); i++) {
            String temp = a_string.substring(i - 2, i);
            if (!isAlphabet(temp.charAt(0), temp.charAt(1))) {
                continue;
            }
            a_set.add(temp);
            temp_set.add(temp);
        }
        for (int i = 2; i <= b_string.length(); i++) {
            String temp = b_string.substring(i - 2, i);
            if (!isAlphabet(temp.charAt(0), temp.charAt(1))) {
                continue;
            }
            b_set.add(temp);
        }
        int a_size = a_set.size();
        int b_size = b_set.size();
        if (a_size == 0 && b_size == 0) {
            return 65536;
        }
        temp_set.retainAll(b_set);
        intersect = temp_set.size();
        union = a_size + b_size - intersect;
        double temp_ans = (intersect / union) * 65536;
        answer = Math.round(temp_ans);

        return (int)answer;
    }

    public static boolean isAlphabet(char a, char b) {
        if (a > 'z' || a < 'a' || b > 'z' || b < 'a') return false;
        return true;
    }
}