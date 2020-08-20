import java.util.LinkedList;
import java.util.Queue;

public class Cache {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue q = new LinkedList();
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        for (int i = 0; i < cities.length; i++) {
            String inputing = cities[i].toLowerCase();
            if (q.contains(inputing)) {
                q.remove(inputing);
                q.add(inputing);
                answer += 1;
            } else {
                if (q.size() >= cacheSize) {
                    q.remove();
                }
                q.add(inputing);
                answer += 5;
            }
        }
        return answer;
    }
}
