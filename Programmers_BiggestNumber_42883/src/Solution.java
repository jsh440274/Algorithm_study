class Solution {
    public static String number;
    StringBuilder answer = new StringBuilder();

    public String solution(String number, int k) {
        this.number = number;
        trimming(k);
        String ans = answer.toString();
        if (ans.charAt(0) == '0') {
            return "0";
        } else {
            return ans;
        }
    }

    public void trimming(int k) {
        int index = 0;
        for (int i = 9; i >= 0; i--) {
            index = number.indexOf(i + '0');
            if (index != -1 && index <= k) {
                break;
            }
        }

        if (index == k) {
            answer.append(number.substring(k));
        } else {
            answer.append(number.charAt(index));
            k -= index;
            if (index < number.length()) {
                number = number.substring(index + 1);
            }
            trimming(k);
        }
    }
//    public String solution(String number, int k) {
//        StringBuilder answer = new StringBuilder();
//        char[] cnum = number.toCharArray();
//        char erasing = '0';
//        while (k > 0) {
//            for (int i = 0; i < number.length(); i++) {
//                if (cnum[i] == erasing) {
//                    cnum[i] = '0' - 1;
//                    k--;
//                    if (k == 0) {
//                        break;
//                    }
//                }
//            }
//            erasing++;
//        }
//
//        for (int i = 0; i < cnum.length; i++) {
//            if (cnum[i] != '0' - 1) {
//                answer.append(cnum[i]);
//            }
//        }
//
//        return answer.toString();
//    }

}