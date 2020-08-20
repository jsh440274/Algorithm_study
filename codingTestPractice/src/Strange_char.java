import java.lang.reflect.Array;
import java.util.ArrayList;

public class Strange_char {
    public String solution(String s) {
        String answer = "";
        String[] blank = s.split("\\s");
        ArrayList<char[]> str_blank = new ArrayList();

        for (int i = 0; i < blank.length; i++) {
            str_blank.add(blank[i].toCharArray());
        }

        for(int j = 0; j<str_blank.size(); j++){
            char[] alj = str_blank.get(j);
            for (int i = 0; i < alj.length; i = i + 2) {
                if(alj[i] >='A'){
                    alj[i] -= 32;
                }
            }
            for (int i = 1; i < alj.length; i = i + 2) {
                if(alj[i] < 'A'){
                    alj[i] += 32;
                }
            }
            answer += String.valueOf(alj) + "\\s";
        }

        return answer.substring(0,answer.length()-1);
    }
}
