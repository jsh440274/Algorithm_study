class Solution1 {
    public String solution(String new_id) {
        String answer = "";
        StringBuffer sb = new StringBuffer();
        new_id = new_id.toLowerCase();

        for (int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);
            if ((c < 'a' || c > 'z') && (c <'0' || c > '9') && c != '-' && c != '_' && c != '.') {
                continue;
            } else if (c == '.') {
                if (sb.length() != 0 && sb.charAt(sb.length() - 1) == '.') {
                    continue;
                } else {
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }


        }
        if (sb.length() == 0) {
            sb.append('a');
        }
        answer = sb.toString();
        if (answer.charAt(0) == '.') {
            answer = answer.substring(1);
            if (answer.length() == 0) {
                answer = "a";
            }
        }
        if (answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
            if (answer.length() == 0) {
                answer = "a";
            }
        }
        if (answer.length() > 15) {
            answer = answer.substring(0, 15);
            if (answer.charAt(answer.length() - 1) == '.') {
                answer = answer.substring(0, answer.length() - 1);
            }
        } else if (answer.length() <= 2) {
            char add = answer.charAt(answer.length() - 1);
            while (answer.length() <= 2) {
                answer += add;
            }
        }
        return answer;
    }
}