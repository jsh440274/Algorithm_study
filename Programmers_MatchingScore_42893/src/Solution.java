import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

class Solution {
    public static String word;

    public int solution(String word, String[] pages) {
        int answer = 0;
        double[] totalScore = new double[pages.length];
        HashMap<String, Integer> nameMap = new HashMap<>();//각 페이지의 인덱스별 이름 저장.
        HashMap<String, int[]> scoreMap = new HashMap<>();//각 페이지의 이름별 기본점수, 외부링크수 저장.
        HashMap<String, ArrayList<String>> LinkedMap = new HashMap<>();//각 페이지의 이름별 기본점수, 외부링크수 저장.

        this.word = word.toLowerCase();
        for (int i = 0; i < pages.length; i++) {
            String html = pages[i];
            int[] scores = new int[3];
            String[] temp1 = html.split("</head>")[0].split("content=\"");
            String pageName = temp1[1].split("\"")[0];
            String[] temp2 = html.split("<body>");
            String bodybody = temp2[1].split("</body>")[0];
            String[] body = bodybody.split("</a>");
            nameMap.put(pageName, i);

            for (int j = 0; j < body.length - 1; j++) {
                String link = body[j].split("<a href=\"")[1].split("\">")[0];
                String input = body[j].split("<a href=\"")[0].toLowerCase();
                ArrayList<String> linked = LinkedMap.getOrDefault(link, new ArrayList<>());
                linked.add(pageName);
                LinkedMap.put(link, linked);
                scores[0] += countingWord(input);
            }
            scores[1] = body.length - 1;
            scores[2] = scores[0];
            scoreMap.put(pageName, scores);
        }

        Set<String> keys = scoreMap.keySet();
        for (String k : keys) {
            double total = scoreMap.get(k)[2];
            if (LinkedMap.containsKey(k)) {
                ArrayList<String> temp = LinkedMap.get(k);
                for (int i = 0; i < temp.size(); i++) {
                    int[] sc = scoreMap.get(temp.get(i));
                    if (sc == null) continue;
                    double linkedScore = (double) sc[0] / (double) sc[1];
                    total += linkedScore;
                }
            }
            int index = nameMap.get(k);
            totalScore[index] = total;
        }

        double s = totalScore[0];
        for (int i = 1; i < totalScore.length; i++) {
            if (s < totalScore[i]) {
                answer = i;
                s = totalScore[i];
            }
        }

        return answer;
    }

    public static int countingWord(String body) {//알파벳 빼고 전부로 스플릿 한담에 그걸 비교하기.
        int ret = 0;
        StringBuilder sb = new StringBuilder();
//        int index = 0;
//
//        while (body.indexOf(word, index) != -1) {
//            index = body.indexOf(word, index);
//            ret++;
//        }

        for (int i = 0; i < body.length(); i++) {
            if (body.charAt(i) <= 'z' && body.charAt(i) >= 'a') {
                sb.append(body.charAt(i));
            } else {
                if (sb.toString().equals(word)) {
                    ret++;
                }
                sb = new StringBuilder();
            }
        }
        //이게 안되면 잘라야하는데 그건 되건 안되건 한번 알아보기는 해야함.

        return ret;
    }
}