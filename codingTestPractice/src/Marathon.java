class Marathon {
    public String solution(String[] participant, String[] completion) {
        int index = 0;
        int j = 0;
        for (int i = 0; i < participant.length; i++) {
            while (j < completion.length) {
                if(participant[i] == completion[j]){
                    break;
                }
                j++;
            }
            if(j == completion.length){
                index = i;
                break;
            }
            else{
                j = 0;
            }
        }
        String answer = participant[index];
        return answer;
    }
}