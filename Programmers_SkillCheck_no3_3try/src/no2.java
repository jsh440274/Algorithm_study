import java.util.HashMap;

public class no2 {
    public int solution(String word, String[] pages) {
        int answer = 0;
        int length = pages.length;
        int[][] score = new int[length][3];
        int[][] outerlink = new int[length][length];
        HashMap<String, Integer> pagemap = new HashMap<>();

        for (int i = 0; i < length; i++) {
            String[] thispage = pages[i].split("<head>|<body>|</body>");
            String[] metas = thispage[1].split("<meta");
            String pagename = metas[1].split("content= | />")[1];
            pagemap.put(pagename, i);
            pages[i] = thispage[2];
        }

        for (int i = 0; i < length; i++) {
            score[i][0] = 0;
            int index = pages[i].indexOf(word);
            while (index != -1) {
                if (index > 0 && index < pages[i].length()) {
                    
                }
                index = pages[i].indexOf(word, index);
            }
        }
        return answer;
    }
}