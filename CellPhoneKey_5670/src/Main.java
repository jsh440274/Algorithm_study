import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String lineing;
        while ((lineing = br.readLine()) != null) {
            int n = Integer.parseInt(lineing);
            double answer = n;
//            double answer = 0;
            String[] givenString = new String[n];
            Trie root = new Trie();
            for (int i = 0; i < n; i++) {//없으면 채운다. 이것만 하면 됨.
                String line = br.readLine();
                givenString[i] = line;
                Trie t = root;
                for (int j = 0; j < line.length(); j++) {
                    char c = line.charAt(j);
                    Trie temp = new Trie(c);
                    if (j == line.length() - 1) {
                        temp.setSingleChildToFalse();
                    }
                    ArrayList<Trie> ch = t.childNode;
                    if (ch.size() == 0) {
                        t.addChildNode(temp);
                        t = temp;
                    } else {
                        boolean exist = false;
                        for (int k = 0; k < ch.size(); k++) {
                            if (ch.get(k).checkSameC(c)) {
                                t = ch.get(k);
                                exist = true;
                                break;
                            }
                        }
                        if (!exist) {
                            t.addChildNode(temp);
                            t = temp;
                        }
                        if (j == line.length() - 1) {
                            t.setSingleChildToFalse();
                        }
                    }
                }
            }

            for (int i = 0; i < givenString.length; i++) {
                Trie t = root;
                for (int j = 0; j < givenString[i].length(); j++) {
                    char c = givenString[i].charAt(j);
                    ArrayList<Trie> childNode = t.childNode;
                    for (int k = 0; k < childNode.size(); k++) {
                        if (childNode.get(k).checkSameC(c)) {
                            if ((childNode.size() > 1 && !t.equals(root)) || !t.singleChild) {
                                answer++;
                            }
                            t = childNode.get(k);
                            break;
                        }
                    }
                }

            }
            System.out.printf("%.2f", (double) answer / n);
        }
    }

//    public static double searching(Trie t, double ret) {
//        ArrayList<Trie> temp = t.childNode;
//        ret += temp.size() - 1;
//        if (temp.size() != 0) {
//            for (int i = 0; i < temp.size(); i++) {
//                Trie index = temp.get(i);
//                ret = searching(index, ret);
//            }
//        }
//        return ret;
//    }

    public static class Trie {
        public char c;
        public boolean singleChild = true;
        public ArrayList<Trie> childNode = new ArrayList<>();

        public Trie() {
        }

        public Trie(char c) {
            this.c = c;
        }

        public void setSingleChildToFalse() {
            this.singleChild = false;
        }

        public void addChildNode(Trie t) {
            this.childNode.add(t);
        }

        public boolean checkSameC(char c) {
            return (this.c == c);
        }
    }
}


//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String lineing;
//        while ((lineing = br.readLine()) != null) {
//            int n = Integer.parseInt(lineing);
//            double answer = n;
//            Trie root = new Trie();
//            for (int i = 0; i < n; i++) {
//                String line = br.readLine();
//                answer += line.length();
//                Trie t = root;
//                for (int j = 0; j < line.length(); j++) {
//                    char c = line.charAt(j);
//                    Trie temp = new Trie(c);
//                    ArrayList<Trie> ch = t.childNode;
//                    if (ch.size() == 0) {
//                        t.addChildNode(temp);
//                        t = temp;
//                        answer--;
//                    } else {
//                        boolean exist = false;
//                        int adding = t.count;
////                    int adding = 0;
//                        for (int k = 0; k < ch.size(); k++) {
////                        adding += ch.get(k).count;
//                            if (ch.get(k).checkSameC(c)) {
//                                t = ch.get(k);
//                                exist = true;
//                                if (ch.size() == 1) {
//                                    t.addCount();
//                                    answer--;
//                                }
//                                break;
//                            }
//                        }
//                        if (!exist) {
//                            toTheLeaf(t);
//                            t.addChildNode(temp);
//                            t.setSingleChildToFalse();
//                            answer += adding;
////                        t.resetCount();
//                            t = temp;
//                        }
//                    }
//                }
//            }
//            answer /= (double) n;
//
//            answer = Math.round(answer * 100) / 100.0;
//            System.out.println(answer);
//        }
//    }
//
//    public static void toTheLeaf(Trie t) {
//        ArrayList<Trie> temp = t.childNode;
//        if (temp.size() == 0) {
//            return;
//        } else {
//            for (int i = 0; i < temp.size(); i++) {
//                Trie index = temp.get(i);
//                index.resetCount();
//                toTheLeaf(index);
//            }
//        }
//    }
//
//    public static class Trie {
//        public char c;
//        public char count = 1;
//        public boolean singleChild = true;
//        public ArrayList<Trie> childNode = new ArrayList<>();
//
//        public Trie() {
//        }
//
//        public Trie(char c) {
//            this.c = c;
//        }
//
//        public void setSingleChildToFalse() {
//            this.singleChild = false;
//        }
//
//        public void addChildNode(Trie t) {
//            this.childNode.add(t);
//        }
//
//        public boolean checkSameC(char c) {
//            return (this.c == c);
//        }
//
//        public void addCount() {
//            this.count++;
//        }
//
//        public void resetCount() {
//            this.count = 1;
//        }
//    }
//}
