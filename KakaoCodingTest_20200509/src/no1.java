class no1 {
    public String solution(int[] numbers, String hand) {
        StringBuffer answer = new StringBuffer();
        int[] left_hand = {3, 0};
        int[] right_hand = {3, 2};
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                numbers[i] = 11;
            }
            int x = (numbers[i] - 1) / 3;
            int y = (numbers[i] - 1) % 3;

            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer.append('L');
                left_hand[0] = x;
                left_hand[1] = y;
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer.append('R');
                right_hand[0] = x;
                right_hand[1] = y;
            } else {
                int distance_left_x = Math.abs(left_hand[0] - x);
                int distance_left_y = Math.abs(left_hand[1] - y);
                int dist_left = distance_left_x + distance_left_y;

                int distance_right_x = Math.abs(right_hand[0] - x);
                int distance_right_y = Math.abs(right_hand[1] - y);
                int dist_right = distance_right_x + distance_right_y;

                if (dist_left > dist_right) {
                    answer.append('R');
                    right_hand[0] = x;
                    right_hand[1] = y;
                } else if (dist_left < dist_right) {
                    answer.append('L');
                    left_hand[0] = x;
                    left_hand[1] = y;
                } else {
                    if (hand.equals("right")) {
                        answer.append('R');
                        right_hand[0] = x;
                        right_hand[1] = y;
                    } else {
                        answer.append('L');
                        left_hand[0] = x;
                        left_hand[1] = y;
                    }
                }
            }
        }
        return answer.toString();
    }
}