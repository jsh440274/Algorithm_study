import java.util.*;

class Solution1 {
    public String solution(String[] votes, int k) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Integer, ArrayList<String>> valuemap = new HashMap<>();
        int n = votes.length;
        int finishline = 0;
        int max = 0;

        for (int i = 0; i < votes.length; i++) {
            int input = map.getOrDefault(votes[i], 0) + 1;
            max = Math.max(input, max);
            map.put(votes[i], input);

        }

        Set<String> keys = map.keySet();
        for (String key : keys) {
            int value = map.get(key);
            ArrayList<String> temp = valuemap.getOrDefault(value, new ArrayList<>());
            temp.add(key);
            Collections.sort(temp);
            valuemap.put(value, temp);
        }

        int index = max;
        while (k > 0) {
            if (valuemap.containsKey(index)) {
                ArrayList temp = valuemap.get(index);
                if (k <= temp.size()) {
                    for (int i = 0; i < temp.size(); i++) {
                        finishline += index;
                        k--;
                        if (k == 0) {
                            break;
                        }
                    }
                } else {
                    k -= temp.size();
                    finishline += index * temp.size();
                }

            }
            index--;
        }

        index = 0;
        int count = 0;
        while (count < finishline) {
            if (valuemap.containsKey(index)) {
                ArrayList<String> temp = valuemap.get(index);
                Collections.sort(temp, Collections.reverseOrder());
                if (temp.size() * index + count >= finishline) {
                    for (int i = 0; i < temp.size(); i++) {
                        count += index;
                        if (finishline <= count) {
                            break;
                        }
                        answer = temp.get(i);
                    }
                } else {
                    count += temp.size() * index;
                    answer = temp.get(temp.size() - 1);
                }
            }
            index++;
        }

        return answer;
    }
}