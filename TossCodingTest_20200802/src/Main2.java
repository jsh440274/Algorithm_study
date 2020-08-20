import java.io.*;
import java.util.ArrayList;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        int n = Integer.parseInt(num);
        if (n <= 1) {
            System.out.println("없음");
        } else {
            StringBuffer sb = new StringBuffer();
            ArrayList<String> ans = new ArrayList<>();
            String temp = br.readLine();
            String[] first = temp.split("\\.");
            for (int i = 0; i < first.length - 1; i++) {
                ans.add(first[i]);
            }
            int index = ans.size();
            for (int m = 1; m < n; m++) {
                String written = br.readLine();
                String[] line = written.split("\\.");
                int tempindex = 0;
                for (int i = 0; i < line.length - 1; i++) {
                    if (ans.size() == i) {
                        break;
                    }
                    if (ans.get(i).equals(line[i])) {
                        tempindex = i;
                    } else {
                        break;
                    }
                }
                index = Math.min(index, tempindex);
            }
            if (index == 0) {
                System.out.println("없음");
            } else {
                sb.append(ans.get(0));
                for (int i = 1; i < ans.size(); i++) {
                    sb.append(".");
                    sb.append(ans.get(i));
                }
                System.out.println(sb.toString());
            }
        }
    }
}
