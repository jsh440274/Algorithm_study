import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

public class Main5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line);
        String[] han = {"원", "만", "억", "조"};

        for (int m = 0; m < n; m++) {
            line = br.readLine();
            ArrayList<String> moneys = new ArrayList<>();
            StringBuffer p = new StringBuffer();
            Stack<String> stack = new Stack<>();
            StringBuffer sb = new StringBuffer();
            for (int i = line.length() - 1; i >= 0; i--) {
                char c = line.charAt(i);
                if (c == ',') continue;
                if (sb.length() < 5) {
                    if (sb.length() == 3) {
                        sb.append(",");
                    }
                    sb.append(c);
                    if (i == 0) {
                        moneys.add(sb.reverse().toString());
                    }
                } else {
                    String temp = sb.reverse().toString();
                    sb = new StringBuffer();
                    boolean front = true;
                    for (int j = 0; j < temp.length(); j++) {
                        char t = temp.charAt(j);
                        if (t != '0' || !front) {
                            if (t == ',' && front) continue;
                            front = false;
                            sb.append(t);
                        }
                    }
                    moneys.add(sb.toString());
                    sb = new StringBuffer();
                    i++;
                }
            }
            for (int i = 0; i < moneys.size(); i++) {
                stack.push(" ");
                if (!moneys.get(i).equals("")) {
                    stack.push(han[i]);
                    stack.push(moneys.get(i));
                } else if (i == 0) {
                    stack.push(han[0]);
                }
            }
            while (stack.size() > 1) {
                String popped = stack.pop();
                System.out.print(popped);
                if (popped.equals(" ") && stack.peek().equals(" ")) {
                    while (stack.peek().equals(" ")) {
                        stack.pop();
                    }
                }
            }
            System.out.println();
        }

    }
}
