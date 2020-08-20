import java.util.HashSet;
import java.util.Set;

class Solution {
    public static StringBuilder sb;
    public static Set<Character> chars;
    public static String sentence;

    public String solution(String sentence) {
        sb = new StringBuilder();
        chars = new HashSet<>();
        String answer = "invalid";
        if (sentence.length() < 3) {
            return answer;
        }

        this.sentence = sentence;

        for (int i = 0; i < sentence.length() - 1; i++) {
            char now = sentence.charAt(i);
            if (now >= 'a') {//소문자 만남. 2인지 봐야지.
                if (chars.contains(now)) {
                    return answer;
                }
                chars.add(now);
                int nextI = checkRuleTwo(i);
                if (nextI == -1) {
                    return answer;
                } else {
                    int inside = checkRuleOne(i + 1);
                    ruleTwoinsert(i, nextI, inside);
                }
                i = nextI;
            } else {//대문잔데 그냥 줄줄이 연달아서 있음
                int nextI = checkRuleOne(i + 1);
                if (nextI == -1) {
                    return answer;
                } else {
                    ruleOneinsert(i, nextI);
                }
                i = nextI + 1;
            }
            sb.append(' ');
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public static int checkRuleTwo(int i) {
        char now = sentence.charAt(i);
        int count = 1;
        int index = sentence.indexOf(now, i + 1);
        int ret = -1;
        while (index != -1) {
            count++;
            ret = index;
            index = sentence.indexOf(now, index + 1);
        }
        if (ret - i < 3) return -1;
        if (count == 2) {
            int isOne = checkRuleOne(i + 1);
            if (isOne == -1 || isOne == ret - 2) {
                return ret;
            }
        }
        return -1;
    }

    public static int checkRuleOne(int i) {
        char now = sentence.charAt(i);
        if (chars.contains(now)) {
            return -1;
        }
        if (now <= 'Z') {
            i++;
            if (sentence.charAt(i) <= 'Z') {
                return -1;
            }
            now = sentence.charAt(i);
        }
        int count = 1;
        int j = i + 2;
        while (j < sentence.length() && sentence.charAt(j) == now) {
            count++;
            j += 2;
        }
        if (count == 1) {
            if (i == 0 || sentence.charAt(i - 1) >= 'a' || sentence.charAt(i + 1) >= 'a') {
                return -1;
            }
        }
        chars.add(now);
        return j - 2;
    }

    public static void ruleOneinsert(int i, int max) {
        for (int j = i; j <= max; j += 2) {
            sb.append(sentence.charAt(j));
        }
        sb.append(sentence.charAt(max + 1));
    }

    public static void ruleTwoinsert(int start, int max, int isruleOne) {
        for (int i = start + 1; i < max; i++) {
            sb.append(sentence.charAt(i));
            if (isruleOne != -1) {
                i++;
            }
        }
    }
}