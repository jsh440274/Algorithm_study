import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, ArrayList<song>> map = new HashMap<>();
        HashMap<String, genre> g_map = new HashMap<>();
        PriorityQueue<genre> pq = new PriorityQueue<>();
        ArrayList<Integer> ans_al = new ArrayList<>();

        for (int i = 0; i < plays.length; i++) {
            genre count = g_map.getOrDefault(genres[i], new genre(genres[i], 0));
            count.count += plays[i];
            g_map.put(genres[i], count);
            ArrayList<song> input = map.getOrDefault(genres[i], new ArrayList<>());
            input.add(new song(i, plays[i]));
            map.put(genres[i], input);
        }

        Set<String> keyset = g_map.keySet();
        for (String i : keyset) {
            pq.offer(g_map.get(i));
        }

        while (!pq.isEmpty()) {
            String g = pq.poll().name;
            ArrayList<song> temp = map.get(g);
            Collections.sort(temp);
            for (int i = 0; i < temp.size(); i++) {
                if (i >= 2) break;
                ans_al.add(temp.get(i).index);
            }
        }

        int[] answer = new int[ans_al.size()];

        for (int i = 0; i < ans_al.size(); i++) {
            answer[i] = ans_al.get(i);
        }

        return answer;
    }

    public static class song implements Comparable<song> {
        int index;
        int play_count;

        public song(int index, int play_count) {
            this.index = index;
            this.play_count = play_count;
        }

        @Override
        public int compareTo(song t) {
            if (t.play_count > this.play_count) {
                return 1;
            } else if (t.play_count < this.play_count) {
                return -1;
            } else {
                return this.index - t.index;
            }
        }
    }

    public static class genre implements Comparable<genre> {
        String name;
        int count;

        public genre(String name, int count) {
            this.name = name;
            this.count = count;
        }

        @Override
        public int compareTo(genre t) {
            return t.count - this.count;
        }
    }
}