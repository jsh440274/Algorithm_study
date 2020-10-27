import java.util.Scanner;
import java.util.Stack;

class Main {
    private static void solution(int numOfOrder, String[] orderArr) {
        // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.

        for (int n = 0; n < numOfOrder; n++) {
            String s = orderArr[n];
            StringBuffer sb = new StringBuffer();
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    if (sb.length() != 0) {
                        stack.push(sb.toString());
                    }
                    sb = new StringBuffer();
                } else if (s.charAt(i) == ')') {
                    //여기서 해야되
                    //괄호 닫기를 만나면 팝해서 그거를 해줘
                    String temp = gualho(sb.toString(), stack.pop());
                    stack.push(temp);
                } else {
//                    //괄호 아닐때 -> 숫자면 곱해주고 아니면 그냥
//                    if (s.charAt(i) == 'R' || s.charAt(i) == 'G' || s.charAt(i) == 'B') {
                    sb.append(s.charAt(i));
//                    } else {
//                        if (sb.length() != 0) {
//                            stack.push(sb.toString());
//                        }
//                        stack.push(String.valueOf(s.charAt(i)));
//                        sb = new StringBuffer();
//                    }
                }
            }
            StringBuffer ans = new StringBuffer();
            while (!stack.isEmpty()) {
                String temp = stack.pop();
                if (temp.length() == 1 && (temp.charAt(0) <= '9') && temp.charAt(0) >= '0') {

                }
                ans.insert(0, temp);
            }

            System.out.println(ans);
        }
    }


    //s가 괄호 안에 문자열
    private static String gualho(String s, String popped) {
        StringBuffer sb = new StringBuffer();
        if (s.length() != 0) {
            sb.append(popped.substring(0, popped.length() - 1));
        }
        char oper = popped.charAt(popped.length() - 1);

        //괄호 앞에 문자.
        if (oper == 'R' || oper == 'G' || oper == 'B') {
            for (int i = 0; i < s.length(); i++) {
                sb.append(oper);
                sb.append(s);
            }
        }
        //괄호 앞에 숫자.
        else {
            for (int i = 0; i < oper - '0'; i++) {
                sb.append(s);
            }
        }

        return sb.toString();
    }

    private static class InputData {
        int numOfOrder;
        String[] orderArr;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.numOfOrder = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.orderArr = new String[inputData.numOfOrder];
            for (int i = 0; i < inputData.numOfOrder; i++) {
                inputData.orderArr[i] = scanner.nextLine().replaceAll("\\s+", "");
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.numOfOrder, inputData.orderArr);
    }
}