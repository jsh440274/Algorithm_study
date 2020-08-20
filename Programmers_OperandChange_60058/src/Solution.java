import java.util.Stack;

class Solution {
    public String solution(String p) {
        if (p.equals("")) return "";

        StringBuilder answer = new StringBuilder();
        int index = balancedString_split(p);

        String u = p.substring(0, index);
        String v = p.substring(index);

        if (isrightString(u)) {
            answer.append(u);
            answer.append(solution(v));
        } else {
            answer.append('(');
            answer.append(solution(v));
            answer.append(')');
            if (u.length() >= 2) {
                String temp = u.substring(1, u.length() - 1);
                String reversed_u = reverse(temp);
                answer.append(reversed_u);
            }
        }

        return answer.toString();
    }

    public static int balancedString_split(String t) {
        int ret = t.length();
        int left_operand = 0;
        int right_operand = 0;

        for (int i = 0; i < t.length(); i++) {
            if (left_operand != 0 && right_operand != 0 && left_operand == right_operand) {
                return i;
            }
            if (t.charAt(i) == '(') {
                left_operand++;
            } else {
                right_operand++;
            }
        }
        return ret;
    }

    public static boolean isrightString(String t) {
        int index = 0;
        Stack<Character> s = new Stack<>();
        while (index < t.length()) {
            if (t.charAt(index) == '(') {
                s.push('(');
            } else {
                if (s.isEmpty()) return false;
                else {
                    s.pop();
                }
            }
            index++;
        }
        return s.isEmpty();
    }

    public static String reverse(String s) {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                ret.append(')');
            } else {
                ret.append('(');
            }
        }
        return ret.toString();
    }
}