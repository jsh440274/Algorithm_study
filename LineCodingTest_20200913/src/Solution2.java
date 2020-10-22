import java.util.ArrayList;

class Solution2 {
    public static int ansindex = 0;
    public static int front = 0;
    public static int back = 0;
    public static int[] answer;
    public static int[] ball;
    public static ArrayList<Integer> queue = new ArrayList<>();

    public int[] solution(int[] ball, int[] order) {
        answer = new int[order.length];
        this.ball = ball;
        back = ball.length - 1;

        for (int i = 0; i < order.length; i++) {
            while (!queue.isEmpty()) {
                boolean cycle = false;
                for (int j = 0; j < queue.size(); j++) {
                    int polled = queue.get(j);
                    boolean temp = balling(polled);
                    if (temp) {
                        queue.remove(j);
                        cycle = true;
                    }
                }
                if (!cycle) {
                    break;
                }
            }
            int ballnum = order[i];
            boolean t = balling(ballnum);
            if (!t) {
                queue.add(order[i]);
            }
        }
        int i = 0;
        while (queue.size() != 0) {
            //나머지 빼기 안되면 뺐다가 뒤에 다시 넣기
            int pop = queue.get(i);
            boolean temp = balling(pop);
            if (temp) {
                queue.remove(i);
            }
            i++;
            if (i == queue.size()) {
                i = 0;
            }
        }
        return answer;
    }

    public static boolean balling(int ballnum) {
        boolean ret = false;
        if (ballnum == ball[front] || ballnum == ball[back]) {
            ret = true;
            if (ballnum == ball[front]) {
                answer[ansindex] = ball[front];
                front++;
            } else if (ballnum == ball[back]) {
                answer[ansindex] = ball[back];
                back--;
            }
            ansindex++;
        }
        return ret;
    }
}
