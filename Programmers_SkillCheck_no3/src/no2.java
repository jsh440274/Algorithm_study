import java.util.ArrayList;
import java.util.Collections;

public class no2 {
    static ArrayList<Integer> friend_around;
    static int answer = -1;
    static int[] far, dist;


    public int solution(int n, int[] weak, int[] dist) {
        this.dist = dist;

        far = new int[weak.length];

        for (int i = 0; i < weak.length - 1; i++) {
            far[i] = weak[i + 1] - weak[i];
        }
        far[weak.length - 1] = weak[weak.length - 1] - weak[0];
        for (int i = 1; i <= dist.length; i++) {
            pick_friend(1, 0, i);
        }

        return answer;
    }

    public static void pick_friend(int start, int depth, int n) {
        if (depth == n) {//고른 애들 비교해서 있는지 보고 있으면 제일 작은 값 리턴
            isanswer(n);
        } else {
            for (int i = start; i < far.length - 1; i++) {
                int temp = far[i];
                far[i] = 0;
                if (i < far.length - 2) {
                    pick_friend(i + 2, depth + 1, n);
                }
                far[i] = temp;
            }
        }
    }

    public static void workSchedule() {
        int friend_move = 0;
        for (int i = 0; i < far.length; i++) {
            if (far[i] == 0) {
                friend_around.add(friend_move);
                friend_move = 0;
            } else {
                friend_move += far[i];
            }
        }
        if (friend_around.size() == dist.length) {
            friend_move += friend_around.get(0);
            friend_around.remove(0);
        }
        friend_around.add(friend_move);
    }

    public static void isanswer(int n) {
        friend_around = new ArrayList();
        workSchedule();
        Collections.sort(friend_around);
        boolean possible = true;
        for (int i = dist.length - 1; i >= 0; i--) {
            for (int f = friend_around.size() - 1; f >= 0; f--) {
                if (friend_around.get(f) > dist[i]) {
                    possible = false;
                }
                break;
            }
            if (!possible) {
                break;
            }
        }
        if (possible) {
            answer = Math.min(answer, n);
        }
    }
}
