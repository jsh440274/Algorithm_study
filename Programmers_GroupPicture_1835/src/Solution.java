import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int solution(int n, String[] data) {
        int answer = 0;
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (int i = 0; i < data.length; i++) {
            String[] datum = new String[2];
            if (data[i].charAt(0) < data[i].charAt(2)) {
                char a = data[i].charAt(2);
                char b = data[i].charAt(0);
                data[i].replace(b, a);
                datum[0] = String.valueOf(a);
            } else {
                datum[0] = String.valueOf(data[i].charAt(0));
            }
            datum[1] = data[i].substring(2);
            ArrayList temp = map.getOrDefault(data[0], new ArrayList<>());
            temp.add(datum[1]);
            map.put(datum[0], temp);
        }

        

        return answer;
    }
}