import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        node[] al = new node[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            al[i] = new node(numbers[i]);
        }
        Arrays.sort(al);
        if (al[0].num.equals(0)) {
            return "0";
        }
        for (node n : al) {
            answer.append(n.num);
        }
        return answer.toString();
    }

    public class node implements Comparable<node> {
        public String num;

        public node(int s) {
            this.num = String.valueOf(s);
        }

        @Override
        public int compareTo(node o) {
            return (o.num + this.num).compareTo(this.num + o.num);
        }
    }
}