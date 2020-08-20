class no2 {
    public int solution(int[][] office, int r, int c, String[] move) {
        int answer = office[r][c];
        office[r][c] = 0;
        int heading = 0;//향하는 곳. 0북 1동 2남 3서

        for (int i = 0; i < move.length; i++) {
            if (move[i].equals("left")) {//왼 회전.
                if (heading == 0) {
                    heading += 4;
                }
                heading--;
            } else if (move[i].equals("right")) {//오른 회전.
                heading = (heading + 1) % 4;
            } else {//직진.
                int original_r = r;
                int original_c = c;
                switch (heading) {
                    case 0:
                        r--;
                        break;
                    case 1:
                        c++;
                        break;
                    case 2:
                        r++;
                        break;
                    case 3:
                        c--;
                        break;
                }
                if (r < 0 || r >= office.length || c < 0 || c >= office[0].length || office[r][c] == -1) {
                    r = original_r;
                    c = original_c;
                }
            }
            answer += office[r][c];
            office[r][c] = 0;
        }

        return answer;
    }
}