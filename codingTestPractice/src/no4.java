
public class no4 {
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            String q = queries[i];
            int index = q.indexOf('?');
            int start = 0;
            int end = 0;
            String s = "";
            if (index == -1) {
                s = q;
                start = 0;
                end = q.length() - 1;
            } else {
                if (index == 0) {
                    index = q.lastIndexOf('?');
                    if (index == q.length() - 1) {
                        start = -1;
                    }
                    else{
                        start = index + 1;
                        end = q.length();
                    }
                    s = q.substring(index + 1);
                } else {
                    start = 0;
                    end = index;
                    s = q.substring(0, index);
                }
            }
            for (String find : words) {
                if (find.length() != q.length()) {
                    continue;
                }
                else if (start == -1 || find.substring(start,end).equals(s)) {
                    answer[i]++;
                }
            }
        }
        return answer;
    }
}
