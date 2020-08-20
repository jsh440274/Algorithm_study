import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public static Set<String> words;
    public static HashMap<Integer, ArrayList<Character>> index_letter_map;
    public static HashMap<Integer, ArrayList<Boolean>> index_letter_visited;
    public static int answer;
    public static String targetWord;

    public int solution(String begin, String target, String[] words) {
        answer = 0;
        this.targetWord = target;
        this.words = new HashSet<>();
        this.index_letter_map = new HashMap<>();
        this.index_letter_visited = new HashMap<>();
        this.words.add(begin);
        for (int i = 0; i < words.length; i++) {
            this.words.add(words[i]);
            char[] temp = words[i].toCharArray();
            for (int j = 0; j < temp.length; j++) {
                ArrayList<Character> tempchar = index_letter_map.getOrDefault(j, new ArrayList<>());
                ArrayList<Boolean> tempvisited = index_letter_visited.getOrDefault(j, new ArrayList<>());
                if (!tempchar.contains(temp[j])) {
                    tempchar.add(temp[j]);
                    tempvisited.add(false);
                }
                index_letter_map.put(j, tempchar);
                index_letter_visited.put(j, tempvisited);
            }
        }
        if (!this.words.contains(target)) return 0;

        char[] prevWord = begin.toCharArray();
        changing(0, prevWord);

        return answer;
    }

    public static void changing(int count, char[] prevWord) {
        String prev = String.valueOf(prevWord);
        if (!words.contains(prev)) {
            return;
        }
        if (prev.equals(targetWord)) {
            if (answer == 0 || answer > count) {
                answer = count;
            }
            return;
        } else {
            for (int i = 0; i < prevWord.length; i++) {
                if (prevWord[i] != targetWord.charAt(i)) {
                    ArrayList<Character> input = index_letter_map.get(i);//i번째 들어갈 수 있는 애들 전부다.
                    ArrayList<Boolean> visited = index_letter_visited.get(i);//i번째 들어갈 수 있는 애들 전부다.
                    for (int j = 0; j < input.size(); j++) {
                        char temp = prevWord[i];
                        if (input.get(j) == temp || visited.get(j)) continue;
                        prevWord[i] = input.get(j);
                        count++;
                        visited.remove(j);
                        visited.add(j, true);
                        changing(count, prevWord);
                        visited.remove(j);
                        visited.add(j, false);
                        count--;
                        prevWord[i] = temp;
                    }
                }
            }
        }
    }
}