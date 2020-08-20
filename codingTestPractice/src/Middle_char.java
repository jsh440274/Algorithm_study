public class Middle_char {
    public String solution(String s) {
        String answer = "";
        int str_length = s.length();
        if (str_length % 2 == 0) {
            answer =  s.charAt(str_length / 2 - 1) + String.valueOf(s.charAt(str_length / 2));
        } else {
            answer = String.valueOf(s.charAt(str_length / 2));
        }
        return answer;
    }
}
