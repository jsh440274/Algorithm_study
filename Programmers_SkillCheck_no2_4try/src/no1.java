import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class no1 {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, ArrayList> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            ArrayList al = new ArrayList();
            if (map.containsKey(clothes[i][1])) {
                al = map.get(clothes[i][1]);
            }
            al.add(clothes[i][0]);
            map.put(clothes[i][1], al);
        }

        Iterator<String> mapIter = map.keySet().iterator();

        while (mapIter.hasNext()) {
            String key = mapIter.next();
            int size = map.get(key).size();
            answer *= (size + 1);
        }

        return answer - 1;
    }
}
