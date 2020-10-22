class Solution4 {
    public int solution(int[][] maze) {
        int answer = 0;
        int n = maze.length;
        int[][] temp = new int[n + 2][n + 2];
        for (int i = 0; i < temp.length; i++) {
            temp[i][0] = 1;
            temp[0][i] = 1;
            temp[i][temp.length - 1] = 1;
            temp[temp.length - 1][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[i+1][j+1] = maze[i][j];
            }
        }
        maze = temp;
        //위 아래 왼쪽 오른쪽
        int[][] heading = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        //왼손은 왼쪽 오른쪽 아래 위
        int[][] lefthand = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        //미로 끝까지 갔을때
        int[] now = {1, 1};
        int direction = 3;

        while (now[0] != n || now[1] != n) {
            int[] h = heading[direction];
            int[] l = lefthand[direction];
            int[] next = {now[0] + h[0], now[1] + h[1]};
            //왼쪽에 벽이 없어지면 움직여
            //왼쪽에 벽이 있을때 앞을 벽이 막고있어도 움직여
            if (maze[now[0] + l[0]][now[1] + l[1]] == 0) {
                direction = emptyleft(direction);
                next[0] = now[0] + heading[direction][0];
                next[1] = now[1] + heading[direction][1];
            }
            while (maze[next[0]][next[1]] == 1) {
                direction = wall(direction);
                next[0] = now[0] + heading[direction][0];
                next[1] = now[1] + heading[direction][1];
            }
            now[0] = next[0];
            now[1] = next[1];
            answer++;
        }

        return answer;
    }

    public static int wall(int direction) {
        int ret = -1;
        switch (direction) {
            case 0:
                ret = 3;
                break;
            case 1:
                ret = 2;
                break;
            case 2:
                ret = 0;
                break;
            case 3:
                ret = 1;
                break;
        }
        return ret;
    }

    public static int emptyleft(int direction) {
        int ret = -1;
        switch (direction) {
            case 0:
                ret = 2;
                break;
            case 1:
                ret = 3;
                break;
            case 2:
                ret = 1;
                break;
            case 3:
                ret = 0;
                break;
        }
        return ret;
    }
}