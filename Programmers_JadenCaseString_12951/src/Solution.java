class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        s = s.toLowerCase();

        String[] strarr = s.split(" ");

        for (int i = 0; i < strarr.length; i++) {
            if (i != 0) {
                answer.append(" ");
            }
            if (strarr[i].length() >= 1) {
                char[] array = strarr[i].toCharArray();
                array[0] = Character.toUpperCase(array[0]);

                strarr[i] = new String(array);
                answer.append(strarr[i]);
            }
        }

        for (int i = 0; i < s.length() - answer.length(); i++) {
            answer.append(" ");
        }

        return answer.toString();
    }
}