import java.util.Stack;

public class no2 {
    public String solution(String p) {
        int is_balanced = 0;
        int divide_index = 0;

        if (p.length() == 0) {
            return "";
        }
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(') {
                is_balanced++;
            } else {
                is_balanced--;
            }
            if (is_balanced ==0) {
                divide_index = i + 1;
                break;
            }
        }
        if (divide_index == 0){
            return p;
        }
        else {
            String u = p.substring(0, divide_index);
            String v = p.substring(divide_index);
            if (is_correct_string(u)) {
                return u + solution(v);
            } else {
                String trim = u.substring(1, u.length() - 1);
                return "(" + solution(v) + ")"+ oposite(trim) ;
            }
        }
    }

    public boolean is_correct_string(String p) {
        Stack left = new Stack();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == '(') {
                left.push(c);
            } else {
                if (left.isEmpty()) {
                    return false;
                }
                left.pop();
            }
        }
        if (!left.isEmpty()) {
            return false;
        }
        return true;
    }

    public String oposite(String u) {
        char[] ret = u.toCharArray();
        for (int i = 0; i < ret.length; i++) {
            if (ret[i] == '(') {
                ret[i] = ')';
            } else {
                ret[i] = '(';
            }
        }
        return String.valueOf(ret);
    }
}
