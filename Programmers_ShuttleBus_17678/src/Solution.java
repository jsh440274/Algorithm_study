import java.util.Arrays;
import java.util.Stack;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int intans = 0;
        int minTime = 60 * 9;
        int maxTime = 60 * 9 + (n - 1) * t;
        int count = 0;
        Stack<Integer> q = new Stack<>();
        Arrays.sort(timetable);
        int nowTime = minTime + count * t;

        for (int i = 0; i < timetable.length; i++) {
            String[] temp = timetable[i].split(":");
            int time = Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
            nowTime = minTime + count * t;
            if (time > maxTime) {
                break;
            }
            if (time > nowTime) {
                count++;
                q.clear();
                q.push(time);
                continue;
            }
            if (q.size() == m) {
                count++;
                if (count == n) {
                    break;
                } else {
                    q.clear();
                    q.push(time);
                }
            } else {
                q.push(time);
            }
        }
        if (q.size() == m) {
            if (count == n - 1) {
                intans = q.peek() - 1;
            } else {
                intans = maxTime;
            }
        } else {
            intans = maxTime;
        }

        String hour = String.valueOf(intans / 60);
        if (hour.length() == 1) {
            hour = "0" + hour;
        }
        String minute = String.valueOf(intans % 60);
        if (minute.length() == 1) {
            minute = "0" + minute;
        }

        answer = hour + ":" + minute;
        return answer;
    }
}