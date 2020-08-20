import java.util.*;

public class Solution1 {
    public static boolean solution(String[] name_list) {
        boolean answer = false;
        HashMap<Character, TrieNode> map = new HashMap<>();
        map.put(null, new TrieNode());

        for (String s : name_list) {
            TrieNode temp = map.get(null);
            for (int i = 0; i < s.length(); i++) {
                char index = s.charAt(i);

            }
        }

        return answer;
    }

    public static class TrieNode {
        public ArrayList<TrieNode> childNode = new ArrayList<TrieNode>();
        public char c;
        public boolean isLeafNode;

        public TrieNode() {
            this.isLeafNode = false;
        }

        public TrieNode(char c) {
            this.c = c;
            this.isLeafNode = true;
        }

        public char getC() {
            return c;
        }

        public void setLeafNodeToFalse() {
            this.isLeafNode = false;
        }
    }
}

/*
import java.util.*;

public class Solution1 {
    public static boolean solution(String[] name_list) {
        boolean answer = false;
        Set<String> words = new HashSet<>();
        HashMap<Character, ArrayList<Character>> map = new HashMap<>();

        Arrays.sort(name_list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                } else {
                    return o1.compareTo(o2);
                }
            }
        });

        for (int i = 0; i < name_list.length; i++) {
            StringBuilder sb = new StringBuilder();
            String index = name_list[i];

            for (int j = 0; j < index.length() - 1; j++) {
                char letter = index.charAt(j);
                if (map.containsKey(letter)) {
                    sb.append(letter);
                    ArrayList<Character> temp = map.get(letter);
                    if (temp == null) {//끝을 만났을 때
                        if (words.contains(sb.toString())) {
                            return true;
                        } else {
                            sb = new StringBuilder();
                        }
                    } else {
                        if (!temp.contains(index.charAt(j + 1))) {
                            if (words.contains(sb.toString())) {
                                return true;
                            } else {
                                sb = new StringBuilder();
                            }
                        }
                    }
                } else {
                    ArrayList<Character> temp = new ArrayList<>();
                    temp.add(index.charAt(j + 1));
                    map.put(letter, temp);
                }
            }
            if (sb.length() != 0) {
                if (words.contains(sb.toString())) {
                    return true;
                }
            }
            if (!map.containsKey(index.charAt(index.length() - 1))) {
                map.put(index.charAt(index.length() - 1), null);
            }
            words.add(index);
        }

        return answer;
    }
*/