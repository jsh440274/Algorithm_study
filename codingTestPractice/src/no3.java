import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class no3 {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        HashMap m_answer = new HashMap();

        for(String find_word : words){
            m_answer.put(find_word, find_word);
        }

        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            int index = q.indexOf('?');
            if (index != -1) {
                char[] pat = q.toCharArray();
                for (int j = 0; j < pat.length; j++) {
                    if (pat[j] == '?') {
                        pat[j] = '.';
                    }
                    queries[i] = String.valueOf(pat);
                }
            }
            for (String find : words) {
                if (find.length() != q.length()) {
                    continue;
                }
                Pattern p = Pattern.compile(queries[i]);
                Matcher m = p.matcher(find);
                if (m.find()) {
                    answer[i]++;
                }
            }
        }
        return answer;
    }
}
