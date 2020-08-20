public class no2 {
    public int solution(String[] ip_addrs, String[] langs, int[] scores) {
        int answer = -1;

        return answer;
    }

    public class student {
        String ip;
        boolean lang;
        int score;

        public student(String ip, String lang, int score) {
            this.ip = ip;
            this.score = score;
            if (lang.charAt(0) == 'C') {
                this.lang = true;
            } else {
                this.lang = false;
            }
        }
    }
}
