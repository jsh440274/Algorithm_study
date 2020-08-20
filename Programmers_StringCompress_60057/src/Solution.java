class Solution {
    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuffer tempsum = new StringBuffer();
            String compared = "", comparing = "";
            int count = 1;
            int j = 0;
            for (; j <= s.length() - (2 * i); j += i) {
                compared = s.substring(j, j + i);
                comparing = s.substring(j + i, j + i + i);
                if (compared.equals(comparing)) {
                    count++;
                } else {
                    if (count != 1) {
                        tempsum.append(count);
                    }
                    tempsum.append(compared);
                    count = 1;
                }
            }
            if (count != 1) {
                tempsum.append(count);
            }
            tempsum.append(s.substring(j));
            answer = Math.min(tempsum.length(), answer);
        }
        return answer;
    }

    //문제를 잘읽자......
    //괜히 어렵게 첫번째부터가 아니라 두번째부터도 할 수 있게끔 만든다고 애썼다.
//    public int solution(String s) {
//        int answer = s.length();
//
//        for (int i = 1; i <= s.length() / 2; i++) {
//            StringBuffer tempsum = new StringBuffer();
//            String compared = "", comparing = "";
//            int count = 1;
//            int j = 0;
//            for (; j <= s.length() - (2 * i); j++) {
//                compared = s.substring(j, j + i);
//                comparing = s.substring(j + i, j + i + i);
//                if (compared.equals(comparing)) {
//                    count++;
//                    j += (i - 1);
//                } else {
//                    if (count != 1) {
//                        tempsum.append(count);
//                        tempsum.append(compared);
//                        j += (i - 1);
//                    } else {
//                        tempsum.append(s.charAt(j));
//                    }
//                    count = 1;
//                }
//            }
//            if (count != 1) {
//                tempsum.append(count);
//            }
//            tempsum.append(s.substring(j));
//            answer = Math.min(tempsum.length(), answer);
//        }
//        return answer;
//    }
}