import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] tempsans = new String[record.length];
        int pushback = 0;
        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < record.length; i++) {
            String[] temp = record[i].split(" ");
            String command = temp[0];
            String uid = temp[1];
            if (command.equals("Enter") || command.equals("Change")) {
                String name = temp[2];
                map.put(uid, name);
                if (command.equals("Change")) {
                    pushback++;
                    continue;
                }
            }
            tempsans[i - pushback] = command + " " + uid;
        }
        String[] answer = new String[record.length - pushback];

        for (int i = 0; i < answer.length; i++) {
            String[] temp = tempsans[i].split(" ");
            String command = temp[0];
            String name = map.get(temp[1]);
            String format;
            if (temp[0].equals("Enter")) {
                format = "님이 들어왔습니다.";
            } else {
                format = "님이 나갔습니다.";
            }
            answer[i] = name + format;
        }

        return answer;
    }
}