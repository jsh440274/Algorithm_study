class Solution {
    public int solution(int[][] baseball) {
        int ans = 0;

        for (int x = 123; x <= 987; x++) {
            String ansball = String.valueOf(x);
            if (ansball.charAt(0) == ansball.charAt(1) || ansball.charAt(1) == ansball.charAt(2) || ansball.charAt(2) == ansball.charAt(1)
                    || ansball.charAt(0) == '0' || ansball.charAt(1) == '0' || ansball.charAt(2) == '0') {
                continue;
            }
            boolean isans = true;
            for (int i = 0; i < baseball.length; i++) {
//                String playball = String.valueOf(baseball[i][0]);
                int strike = 0;
                int ball = 0;
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
//                        if (ansball.charAt(j) == playball.charAt(k)) {
//                            if (j == k) {
//                                strike++;
//                            } else {
//                                ball++;
//                            }
//                            break;
//                        }
                        String playball =String.valueOf(baseball[i][0]);
                        if (j == k&&ansball.charAt(j) == playball.charAt(k))
                        {
                            strike++;
                            continue;
                        }
                        if (j != k&&ansball.charAt(j) == playball.charAt(k)) {
                            ball++;
                            continue;
                        }
                    }
                }
                if (strike != baseball[i][1] || ball != baseball[i][2]) {
                    isans = false;
                    break;
                }

            }
            if (isans) ans++;
        }

        return ans;
    }
}