import java.util.ArrayList;
import java.util.HashMap;

//처음 생각 -> 앞으로 트라이랑 뒤로 트라이를 두개 만들어서 접두사인경우는 앞으로 트라이에서 찾고 접미사인 경우는 뒤로 트라이에서 찾는다.
//개쩌는 생각 -> 트라이 노드에 남은 글자수가 얼마나 있는지에 대한 해쉬맵을 만든다. insert하면서 한글자씩 트라이 노드를 만들때 해쉬맵에도 
//             값들을 바꿔주면 나중에 재귀적으로 돌아서 확인할 필요 없이 한큐에 확인할 수 있음
class Solution {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        Trie forwordT = new Trie();//앞으로 트라이.
        Trie backwordT = new Trie();//뒤로 트라이.

        for (int i = 0; i < words.length; i++) {
            forwordT.insert(words[i], false);
            backwordT.insert(words[i], true);
        }

        for (int i = 0; i < queries.length; i++) {
            String index = queries[i];
//            if (index.charAt(0) == '?' && index.charAt(index.length() - 1) == '?') {
//                answer[i] = forwordT.finding(index, false);
//            } else
            if (index.charAt(0) == '?') {
                answer[i] = backwordT.finding(index, true);
            } else {
                answer[i] = forwordT.finding(index, false);
            }
        }

        return answer;
    }

    public static class Trie {
        public trieNode root;

        public Trie() {
            this.root = new trieNode();
        }

        public void insert(String s, boolean reverse) {
            trieNode parent = root;
            if (reverse) {
                StringBuffer temp = new StringBuffer(s);
                s = temp.reverse().toString();
            }
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int length = s.length() - i;
                ArrayList<trieNode> t = parent.child;
                int getted = parent.countingMap.getOrDefault(length, 0);
                parent.countingMap.put(length, getted + 1);
                if (t.size() == 0) {
                    trieNode input = new trieNode(c);
                    t.add(input);
                    parent = input;
                } else {
                    boolean exist = false;
                    for (int j = 0; j < t.size(); j++) {
                        trieNode get = t.get(j);
                        if (get.sameC(c)) {
                            exist = true;
                            parent = get;
                            break;
                        }
                    }
                    if (!exist) {
                        trieNode input = new trieNode(c);
                        t.add(input);
                        parent = input;
                    }
                }
            }
            parent.endOfTheWord();
        }

        public int finding(String s, boolean reverse) {
            trieNode indexnode = null;
            trieNode parent = this.root;
            int count = s.length();
            if (reverse) {
                StringBuffer temp = new StringBuffer(s);
                s = temp.reverse().toString();
            }

            //여기서 이제 ?를 어떻게 처리할 것인가 생각해봄.
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                ArrayList<trieNode> child = parent.child;
                if (c == '?' && indexnode == null) {
                    indexnode = parent;
                    count -= i;
                    break;
                }
                for (int j = 0; j < child.size(); j++) {
                    trieNode temp = child.get(j);
                    if (temp.sameC(c)) {
                        parent = temp;
                        break;
                    }
                }
            }

//            tracking(indexnode, count);
            return tracking(indexnode, count);

//            return ans;
        }

        public int tracking(trieNode indexnode, int count) {
            return indexnode.countingMap.getOrDefault(count, 0);
        }
    }

    public static class trieNode {
        boolean ending = false;
        char c;
        public HashMap<Integer, Integer> countingMap = new HashMap<>();
        ArrayList<trieNode> child = new ArrayList<>();

        public trieNode() {
        }

        public trieNode(char c) {
            this.c = c;
        }

        public boolean sameC(char c) {
            return (this.c == c);
        }

        public void endOfTheWord() {
            this.ending = true;
        }

    }
}

//처음 생각 -> 앞으로 트라이랑 뒤로 트라이를 두개 만들어서 접두사인경우는 앞으로 트라이에서 찾고 접미사인 경우는 뒤로 트라이에서 찾는다.
//문제는 정확성이 아니라 시간 초과가 난다는거.

//import java.util.ArrayList;
//
//class Solution {
//    public int[] solution(String[] words, String[] queries) {
//        int[] answer = new int[queries.length];
//
//        Trie forwordT = new Trie();//앞으로 트라이.
//        Trie backwordT = new Trie();//뒤로 트라이.
//
//        for (int i = 0; i < words.length; i++) {
//            forwordT.insert(words[i], false);
//            backwordT.insert(words[i], true);
//        }
//
//        for (int i = 0; i < queries.length; i++) {
//            String index = queries[i];
//            if (index.charAt(0) == '?') {
//                answer[i] = backwordT.finding(index, true);
//            } else {
//                answer[i] = forwordT.finding(index, false);
//            }
//        }
//
//        return answer;
//    }
//
//    public static class Trie {
//        public trieNode root;
//        public int count = 0;
//        public int ans = 0;
//
//        public Trie() {
//            this.root = new trieNode();
//        }
//
//        public void insert(String s, boolean reverse) {
//            trieNode parent = root;
//            if (reverse) {
//                StringBuffer temp = new StringBuffer(s);
//                s = temp.reverse().toString();
//            }
//            for (int i = 0; i < s.length(); i++) {
//                char c = s.charAt(i);
//                ArrayList<trieNode> t = parent.child;
//                if (t.size() == 0) {
//                    trieNode input = new trieNode(c);
//                    t.add(input);
//                    parent = input;
//                } else {
//                    boolean exist = false;
//                    for (int j = 0; j < t.size(); j++) {
//                        trieNode get = t.get(j);
//                        if (get.sameC(c)) {
//                            exist = true;
//                            parent = get;
//                            break;
//                        }
//                    }
//                    if (!exist) {
//                        trieNode input = new trieNode(c);
//                        t.add(input);
//                        parent = input;
//                    }
//                }
//            }
//            parent.endOfTheWord();
//        }
//
//        public int finding(String s, boolean reverse) {
//            ans = 0;
//            trieNode indexnode = null;
//            trieNode parent = this.root;
//            if (reverse) {
//                StringBuffer temp = new StringBuffer(s);
//                s = temp.reverse().toString();
//            }
//
//            //여기서 이제 ?를 어떻게 처리할 것인가 생각해봄.
//            for (int i = 0; i < s.length(); i++) {
//                char c = s.charAt(i);
//                ArrayList<trieNode> child = parent.child;
//                if (c == '?' && indexnode == null) {
//                    indexnode = parent;
//                    count = s.length() - i;
//                    break;
//                }
//                for (int j = 0; j < child.size(); j++) {
//                    trieNode temp = child.get(j);
//                    if (temp.sameC(c)) {
//                        parent = temp;
//                        break;
//                    }
//                }
//            }
//
//            tracking(indexnode, count);
//
//            return ans;
//        }
//
//        public void tracking(trieNode indexnode, int count) {
//            if (count == 0) {
//                if (indexnode.ending) {
//                    ans++;
//                }
//                return;
//            } else {
//                ArrayList<trieNode> temp = indexnode.child;
//                if (temp.size() == 0) {
//                    return;
//                } else {
//                    for (int i = 0; i < temp.size(); i++) {
//                        trieNode next = temp.get(i);
//                        tracking(next, count - 1);
//                    }
//                }
//            }
//        }
//    }
//
//    public static class trieNode {
//        boolean ending = false;
//        char c;
//        ArrayList<trieNode> child = new ArrayList<>();
//
//        public trieNode() {
//        }
//
//        public trieNode(char c) {
//            this.c = c;
//        }
//
//        public boolean sameC(char c) {
//            return (this.c == c);
//        }
//
//        public void endOfTheWord() {
//            this.ending = true;
//        }
//
//    }
//}