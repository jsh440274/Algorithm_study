import java.util.ArrayList;

public class no3 {
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        int[] matched = new int[banned_id.length];
        ArrayList<String> id_al = new ArrayList<>();

        for (int i = 0; i < user_id.length; i++) {
            id_al.add(user_id[i]);
        }

        for (int i = 0; i < banned_id.length; i++) {
            for (int l = 0; l < banned_id[i].length(); l++) {
                char letter = banned_id[i].charAt(l);
                if (letter == '*') continue;
                for (int j = 0; j < id_al.size(); j++) {
                    String user = id_al.get(j);
                    if (user.length() < i) {
                        id_al.remove(user);
                        j--;
                        continue;
                    }

                }
            }
        }

        return answer;
    }
}
