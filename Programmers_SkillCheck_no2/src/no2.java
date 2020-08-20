import java.util.*;

public class no2 {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        int answer = 0;
        Queue<String> cache = new LinkedList<>();

        for (int i = 0; i < cities.length; i++) {
            String input = cities[i].toLowerCase();
            if (cache.size() < cacheSize) {
                if (cache.contains(input)) {
                    answer++;
                    cache.remove(input);
                } else {
                    answer += 5;
                }
                cache.add(input);
            } else {
                if (cache.contains(input)) {
                    answer++;
                    cache.remove(input);
                } else {
                    answer += 5;
                    cache.remove();
                }
                cache.add(input);
            }
        }
        return answer;
    }
}