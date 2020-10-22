import java.io.*;
import java.util.*;

public class Main {
    public static boolean ret;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Trie trie = new Trie();
        Set<Character> cset = new HashSet<>();
        while (n > 0) {
            trie.add(br.readLine());
            n--;
        }
        int q = Integer.parseInt(br.readLine());
        ////
        while (q > 0) {
            String line = br.readLine();
            ret = false;
            /////
            for (int i = 0; i < line.length(); i++) {
                trie.finding(line, i, trie.root);
            }
            if (ret) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            q--;
        }
    }

    public static class Trie {
        trieNode root = new trieNode();

        public void add(String s) {
            trieNode r = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int index = c - 'a';
                if (r.child[index] == null) {
                    trieNode temp = new trieNode(c);
                    r.child[index] = temp;
                    r = temp;
                } else {
                    r = r.child[index];
                }
                if (i == s.length() - 1) {
                    r.ending = true;
                }
            }
        }

        public void finding(String s, int si, trieNode r) {
            char cc = s.charAt(si);
            int index = cc - 'a';
            if (r.child[index] != null) {
                r = r.child[index];
                si++;
                if (r.ending || si == s.length() - 1) {
                    ret = true;
                    return;
                }
                finding(s, si, r);
            } else {
                return;
            }
        }
    }

    public static class trieNode {
        char c;
        boolean ending = false;
        trieNode[] child = new trieNode[26];

        public trieNode() {
        }

        public trieNode(char c) {
            this.c = c;
        }
    }
}
