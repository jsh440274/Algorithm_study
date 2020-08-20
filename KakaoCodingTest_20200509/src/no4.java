class no4 {
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};
    public static int answer = Integer.MAX_VALUE;
    public static int length = 0;
    public static int[][] board;
    public static boolean[][] visited;
    public static boolean vertical = true;
    public static int[][][] dp_num;

    public int solution(int[][] board) {
        this.board = board;
        visited = new boolean[board.length][board.length];
        dp_num = new int[board.length][board.length][2];
        length = board.length;

        making_road(0, 0, 0);

        return answer;
    }

    public static void making_road(int n, int m, int money) {
        if (n == length - 1 && m == length - 1) {
            answer = Math.min(answer, money);
            int temp = Math.min(dp_num[n][m][0], dp_num[n][m][1]);
            if (dp_num[n][m][0] != 0) {
                if (dp_num[n][m][1] != 0) {
                    temp = dp_num[n][m][1];
                } else {
                    temp = dp_num[n][m][0];
                }
            } else {
                if (dp_num[n][m][0] != 0) {
                    temp = dp_num[n][m][1];
                } else {
                    temp = answer;
                }
            }
            answer = Math.min(answer, temp);
        } else {
            for (int i = 0; i < 4; i++) {
                boolean temp = vertical;
                boolean next = (dy[i] != 0);
                boolean corner = vertical ^ next;
                int added_money = money;
                if (vertical) {
                    if (n + dy[i] >= 0 && n + dy[i] < length && m + dx[i] >= 0
                            && m + dx[i] < length && board[n + dy[i]][m + dx[i]] != 1 && !visited[n + dy[i]][m + dx[i]]) {
                        if ((n == 0 && m == 0) || !corner) {
                            added_money += 100;
                        } else if (corner) {
                            added_money += 600;
                        }
                        if (dp_num[n][m][1] != 0 && dp_num[n][m][1] < added_money) {//버티컬을 잡아야함.
                            return;
                        }
                        dp_num[n][m][1] = added_money;
                        vertical = next;
                        visited[n][m] = true;
                        making_road(n + dy[i], m + dx[i], added_money);
                        visited[n][m] = false;
                        vertical = temp;
                    }
                } else {
                    next = (dx[i] != 0);
                    corner = vertical ^ next;
                    if (n + dx[i] >= 0 && n + dx[i] < length && m + dy[i] >= 0
                            && m + dy[i] < length && board[n + dx[i]][m + dy[i]] != 1 && !visited[n + dx[i]][m + dy[i]]) {
                        if ((n == 0 && m == 0) || !corner) {
                            added_money += 100;
                        } else if (corner) {
                            added_money += 600;
                        }
                        if (dp_num[n][m][0] != 0 && dp_num[n][m][0] < added_money) {
                            return;
                        }
                        dp_num[n][m][0] = added_money;
                        vertical = next;
                        visited[n][m] = true;
                        making_road(n + dx[i], m + dy[i], added_money);
                        visited[n][m] = false;
                        vertical = temp;
                    }
                }
            }
        }
    }
}

//class no4 {
//    public static int[] dx = {1, -1, 0, 0};
//    public static int[] dy = {0, 0, 1, -1};
//    public static int answer = Integer.MAX_VALUE;
//    public static int length = 0;
//    public static int[][] board;
//    public static boolean[][] visited;
//    public static boolean vertical = true;
//
//    public int solution(int[][] board) {
//        this.board = board;
//        visited = new boolean[board.length][board.length];
//        length = board.length;
//
//        making_road(0, 0, 0);
//
//        return answer;
//    }
//
//    public static void making_road(int n, int m, int money) {
//        if (n == length - 1 && m == length - 1) {
//            answer = Math.min(answer, money);
//        } else {
//            for (int i = 0; i < 4; i++) {
//                boolean temp = vertical;
//                boolean next = (dy[i] != 0);
//                boolean corner = vertical ^ next;
//                int added_money = money;
//                if (vertical) {
//                    if (n + dy[i] >= 0 && n + dy[i] < length && m + dx[i] >= 0
//                            && m + dx[i] < length && board[n + dy[i]][m + dx[i]] != 1 && !visited[n + dy[i]][m + dx[i]]) {
//                        if ((n == 0 && m == 0) || !corner) {
//                            added_money += 100;
//                        } else if (corner) {
//                            added_money += 600;
//                        }
//                        vertical = next;
//                        visited[n][m] = true;
//                        making_road(n + dy[i], m + dx[i], added_money);
//                        visited[n][m] = false;
//                        vertical = temp;
//                    }
//                } else {
//                    next = (dx[i] != 0);
//                    corner = vertical ^ next;
//                    if (n + dx[i] >= 0 && n + dx[i] < length && m + dy[i] >= 0 && m + dy[i] < length && board[n + dx[i]][m + dy[i]] != 1 && !visited[n + dx[i]][m + dy[i]]) {
//                        if ((n == 0 && m == 0) || !corner) {
//                            added_money += 100;
//                        } else if (corner) {
//                            added_money += 600;
//                        }
//                        vertical = next;
//                        visited[n][m] = true;
//                        making_road(n + dx[i], m + dy[i], added_money);
//                        visited[n][m] = false;
//                        vertical = temp;
//                    }
//                }
//            }
//        }
//    }
//}