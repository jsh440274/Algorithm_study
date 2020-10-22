import java.util.ArrayList;

class Solution3 {
    public static String[] line;

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Trie root = new Trie();

        for (int i = 0; i < info.length; i++) {
            root.addNode(info[i]);
        }

        for (int i = 0; i < query.length; i++) {
            String[] temp = query[i].split(" and ");
            line = new String[temp.length + 1];
            System.arraycopy(temp, 0, line, 0, temp.length - 1);
            String[] temp2 = temp[temp.length - 1].split(" ");
            System.arraycopy(temp2, 0, line, line.length - 2, 2);
            answer[i] = root.find(root.root, 0);
        }
        return answer;
    }

    public class Trie {
        trieNode root;

        public Trie() {
            root = new trieNode();
        }

        public void addNode(String string) {
            trieNode temp = root;
            String[] line = string.split(" ");
            for (int i = 0; i < line.length; i++) {
                String ss = line[i];
                boolean find = false;
                for (int j = 0; j < temp.next.size(); j++) {
                    if (temp.next.get(j).s.equals(ss)) {
                        find = true;
                        temp = temp.next.get(j);
                    }
                }
                if (!find) {
                    trieNode t = new trieNode(ss);
                    temp.next.add(t);
                    temp = t;
                }
            }
        }

        public int find(trieNode temp, int index) {
            int count = 0;
            if (index == line.length - 1) {
                if (line[index].equals("-")) {
                    count += root.next.size();
                } else {
                    int num = Integer.parseInt(line[index]);
                    for (int i = 0; i < temp.next.size(); i++) {
                        int value = Integer.parseInt(temp.next.get(i).s);
                        if (num <= value) {
                            count++;
                        }
                    }
                }
                return count;
            }
            if (line[index].equals("-")) {
                for (int i = 0; i < temp.next.size(); i++) {
                    count += find(temp.next.get(i), index + 1);
                }
            } else {
                for (int i = 0; i < temp.next.size(); i++) {
                    if (temp.next.get(i).s.equals(line[index])) {
                        temp = temp.next.get(i);
                        count = find(temp, index + 1);
                    }
                }
            }
            return count;
        }
    }

    public class trieNode {
        String s;
        ArrayList<trieNode> next = new ArrayList<>();

        public trieNode() {

        }

        public trieNode(String s) {
            this.s = s;
        }
    }
}