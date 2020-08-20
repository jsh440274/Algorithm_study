import java.util.ArrayList;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        ArrayList<String> song_arr = new ArrayList<>();
        ArrayList<Integer> time_arr = new ArrayList<>();

        for (int i = 0; i < musicinfos.length; i++) {
            String[] infos = musicinfos[i].split(",");
            String[] start = infos[0].split(":");
            String[] end = infos[1].split(":");
            int time = (Integer.parseInt(end[0]) - Integer.parseInt(start[0])) * 60 + (Integer.parseInt(end[1]) - Integer.parseInt(start[1]));

            m = convertingSharp(m);
            infos[3] = convertingSharp(infos[3]);

            if (m.length() <= time) {//이어붙여. 그담에 해당하는 글자가 있는지를 확인쓰. 만약 있으면 그걸루다가 바로 출력
                infos[3] = full(time, infos[3]);
                if (infos[3].contains(m)) {
                    song_arr.add(infos[2]);
                    time_arr.add(time);
                }
            }
        }
        if (!song_arr.isEmpty()) {
            answer = song_arr.get(0);
            int maxtime = time_arr.get(0);
            for (int i = 1; i < song_arr.size(); i++) {
                if (time_arr.get(i) > maxtime) {
                    maxtime = time_arr.get(i);
                    answer = song_arr.get(i);
                }
            }
        }
        return answer;
    }

    public static String convertingSharp(String m) {
        StringBuffer strbuf = new StringBuffer();
        char[] chars = m.toCharArray();
        for (int j = 1; j < chars.length; j++) {
            if (chars[j] == '#') {
                strbuf.append((char) (chars[j - 1] + 32));
                j++;
            } else {
                strbuf.append(chars[j - 1]);
            }
        }
        if (chars[chars.length - 1] != '#') {
            strbuf.append(chars[chars.length - 1]);
        }
        return strbuf.toString();
    }

    public static String full(int time, String m) {
        if (m.length() == time) return m;
        StringBuffer strbuf = new StringBuffer();
        for (int i = 0; i < time; i++) {
            strbuf.append(m.charAt(i % m.length()));
        }
        return strbuf.toString();
    }
}