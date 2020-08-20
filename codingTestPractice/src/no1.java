public class no1 {
    public int solution(String s) {
        String answer = s;

        for (int i = 1; i < s.length(); i++) {
            String temp_answer = "";
            int count = 0;
            String letters = "";
            for (int j = 0; j <= s.length() / i; j++) {
                if (j == s.length() / i) {
                    if (count != 1) {
                        temp_answer += String.valueOf(count);
                    }
                    String last = s.substring((j - 1) * i);
                    temp_answer += last;
                    break;
                }
                String sub = s.substring(j * i, (j + 1) * i);
                if (!letters.equals(sub) && letters.length() != 0) {
                    if (count != 1) {
                        temp_answer += String.valueOf(count);
                    }
                    temp_answer += letters;
                    count = 0;
                }
                letters = sub;
                count++;
            }
            if (temp_answer.length() < answer.length()) {
                answer = temp_answer;
            }
        }

        return answer.length();
    }
}
