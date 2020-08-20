class Solution {
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][] lengthMap = new boolean[11][11][4];
        int[] now = {5, 5};
        char[] dir = dirs.toCharArray();

        for (int i = 0; i < dir.length; i++) {
            int nextX = now[0];
            int nextY = now[1];
            int path = -1;
            switch (dir[i]) {
                case 'U':
                    path = 0;
                    nextY--;
                    break;
                case 'D':
                    path = 3;
                    nextY++;
                    break;
                case 'R':
                    path = 1;
                    nextX++;
                    break;
                case 'L':
                    path = 2;
                    nextX--;
                    break;
            }
            if (nextX >= 0 && nextX <= 10 && nextY >= 0 && nextY <= 10) {
                if (!lengthMap[nextX][nextY][3 - path] && !lengthMap[now[0]][now[1]][path]) {
                    lengthMap[nextX][nextY][3 - path] = true;
                    lengthMap[now[0]][now[1]][path] = true;
                    answer++;
                }
                now[0] = nextX;
                now[1] = nextY;
            }
        }

        return answer;
    }
}