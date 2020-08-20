import java.io.*;
import java.util.*;

public class no1 {

    public static boolean yes_or_no(HashMap<String, Integer> cards) {
        Set<String> keys = cards.keySet();
        int max = -1;
        boolean flag = false;

        for (String key : keys) {
            int value = cards.get(key);
            if (max == -1) {
                max = value;
            }
            else if(value < max - 1 || value > max + 1){
                return  false;
            }
            else {
                flag = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> cards = new HashMap();
        int insects = sc.nextInt();

        for (int i = 0; i < insects; i++) {
            String insect = sc.next();
            if (cards.containsKey(insect)) {
                cards.put(insect, cards.get(insect) + 1);
            } else {
                cards.put(insect, 1);
            }
        }

        Set<Integer> all_same = new HashSet<>();
        Collection<Integer> values = cards.values();
        all_same.addAll(values);

        if (yes_or_no(cards)) {
            System.out.println("Y");
            if (all_same.size() == 1) {
                System.out.println(insects);
            } else {
                System.out.println(insects + 1);
            }
            System.out.println(cards.size());
        } else {
            System.out.println("N");
            System.out.println(insects);
            System.out.println(cards.size());
        }

    }
}
