import java.util.Stack;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuffer answer = new StringBuffer();
        StringBuffer full = new StringBuffer();
        int count_length = m * t + p;
        int num = 0;
        while (full.length() < count_length) {
            StringBuffer a = ConvertingNumbers(n, num);
            full.append(a);
            num++;
        }
        int index = p - 1;
        while (answer.length() < t) {
            answer.append(full.charAt(index));
            index += m;
        }
        return answer.toString();
    }

    public static char ConvertingAlphabet(int number) {
        if (number >= 10) {
            number += 55;
        } else {
            number += 48;
        }
        return (char) number;
    }

    public static StringBuffer ConvertingNumbers(int n, int number) {
        StringBuffer stringBuffer = new StringBuffer();
        if (number < n) {
            char temp = ConvertingAlphabet(number);
            stringBuffer.append(temp);
            return stringBuffer;
        }
        Stack<Character> stack = new Stack<>();
        while (number > 0) {
            char temp = ConvertingAlphabet(number % n);
            stack.push(temp);
            number /= n;
        }
//        stringBuffer.append(number);
        while (!stack.isEmpty()) {
            stringBuffer.append(stack.pop());
        }
        return stringBuffer;
    }
}