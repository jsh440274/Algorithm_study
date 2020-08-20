import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        ArrayList<fullname> al = new ArrayList<>();

        for (String i : files) {
            al.add(new fullname(i));
        }

        Collections.sort(al);

        for (int i = 0; i < files.length; i++) {
            answer[i] = al.get(i).original;
        }
        return answer;
    }

    public class fullname implements Comparable<fullname> {
        String original;
        String head;
        int num;
        String tail;

        public fullname(String ori) {
            this.original = ori;
            int start = -1;
            int end = -1;
            StringBuffer strbuf = new StringBuffer();
            for (int i = 0; i < ori.length(); i++) {
                if (ori.charAt(i) >= 48 && ori.charAt(i) <= 57) {
                    if (start == -1) {
                        start = i;
                    }
                } else {
                    if (start != -1 && end == -1) {
                        end = i;
                        strbuf.append(ori.substring(start, end));
                    }
                }
            }
            if (start == -1 && end == -1) {
                this.tail = ori.toLowerCase();
            } else {
                this.head = ori.substring(0, start).toLowerCase();
                String strnum = ori.substring(start, end);
                if (strnum == null) {
                    this.num = -1;
                } else {
                    this.num = Integer.parseInt(strnum);
                }
                this.tail = ori.substring(end);
            }
        }

        @Override
        public int compareTo(fullname o) {
            if (this.head == null || o.head == null) {
                return 0;
            }
            if (this.head.equals(o.head)) {
                if (this.num > o.num) {
                    return 1;
                } else if (this.num < o.num) {
                    return -1;
                } else {
                    if (this.tail == null || o.tail == null) return 0;
                    fullname a = new fullname(this.tail);
                    fullname b = new fullname(o.tail);
                    return a.compareTo(b);
                }
            } else {
                return this.head.compareTo(o.head);
            }
        }
    }
}