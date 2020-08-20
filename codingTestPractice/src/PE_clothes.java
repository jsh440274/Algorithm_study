public class PE_clothes {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        for (int i = 0; i < reserve.length; i++) {
            int j = 0;
            while (j < lost.length) {
                if (reserve[i] - 1 == lost[j]) {
                    lost[j] = -2;
                    break;
                }
                else if (reserve[i] + 1 == lost[j]){
                    lost[j] = -2;
                    break;
                }
                j++;
            }
            if(j == lost.length) {
                j = 0;
                while (j < lost.length) {
                    if (reserve[i] + 1 == lost[j]) {
                        lost[j] = -2;
                        break;
                    }
                    j++;
                }
            }
            if (j == lost.length) {
                answer--;
            }
        }

        return answer;
    }
}
