import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String answer = "YES";
            int n = Integer.parseInt(br.readLine());
            String[] strings = new String[n];
            for (int i = 0; i < n; i++) {
                strings[i] = br.readLine();
            }
            Arrays.sort(strings);
            for (int i = 1; i < n; i++) {
                if (strings[i].startsWith(strings[i - 1])) {
                    answer = "NO";
                    break;
                }
            }
            System.out.println(answer);
            t--;
        }
    }
}


//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//
//public class Main {
//    public static String line;
//    public static String answer;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(br.readLine());
//        while (t > 0) {
//            int n = Integer.parseInt(br.readLine());
//            trie root = new trie();
//            answer = "YES";
//            for (int i = 0; i < n; i++) {
//                line = br.readLine();
//                finding(0, root);
//                if (answer.equals("NO")) break;
//            }
//            System.out.println(answer);
//            t--;
//        }
//    }
//
//    public static void finding(int index, trie t) {
//        if (index == line.length()) {
//            t.setLeaf();
//            return;
//        } else {
//            char c = line.charAt(index);
//            ArrayList<trie> temp = t.child;
//            trie input = new trie(c);
//            if (temp.size() == 0) {
//                temp.add(input);
//            } else {
//                int exist = -1;
//                for (int i = 0; i < temp.size(); i++) {
//                    trie childnode = temp.get(i);
//                    if (childnode.num == c) {
//                        if (childnode.isLeaf) {
//                            answer = "NO";
//                            return;
//                        }
//                        exist = i;
//                        input = childnode;
//                        break;
//                    }
//                }
//                if (exist == -1) {
//                    t.addChild(input);
//                }
//            }
//            finding(index + 1, input);
//        }
//    }
//
//    public static class trie {
//        public char num;
//        public ArrayList<trie> child = new ArrayList<>();
//        public boolean isLeaf = false;
//
//        public trie() {
//        }
//
//        public trie(char num) {
//            this.num = num;
//        }
//
//        public void setLeaf() {
//            this.isLeaf = true;
//        }
//
//        public void addChild(trie child) {
//            this.child.add(child);
//        }
//    }
//}