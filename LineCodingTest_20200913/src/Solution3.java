class Solution3 {
    public static int ret0 = Integer.MAX_VALUE;
    public static int ret1 = 0;

    public int[] solution(int n) {
        int[] answer = new int[2];
        ret1 = n;
        String sn = String.valueOf(n);
        plusing(sn, 0);
        answer[0] = ret0;
        answer[1] = ret1;

        return answer;
    }

    public static void plusing(String sn, int count) {
        if (sn.length() == 1) {
            if (count < ret0) {
                ret0 = count;
                ret1 = Integer.parseInt(sn);
            }
        } else {
            for (int i = 1; i < sn.length(); i++) {
                int a = Integer.parseInt(sn.substring(0, i));
                String tempb = sn.substring(i);
                if (tempb.length() != 1 && tempb.charAt(0) == '0') {
                    continue;
                }
                int b = Integer.parseInt(tempb);
                String nextsn = String.valueOf(a + b);
                plusing(nextsn, count + 1);
            }
        }
    }
}