class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String[] sss = s.split(" ");
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < sss.length; i++) {
            int index = Integer.parseInt(sss[i]);
            if (max <= index) max = index;
            if (min >= index) min = index;
        }
        answer.append(min);
        answer.append(" ");
        answer.append(max);
        return answer.toString();
    }
}