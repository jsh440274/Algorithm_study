public class no1 {
    public int solution(String[] emails){
        int answer = 0;
        String alphabet_lower = "^[a-z]*$";
        String names = "^[a-z.]*$";
        for(int i = 0; i< emails.length;i++){
            String[] name_mail = emails[i].split("@");
            if(name_mail.length != 2){
                continue;
            }
            String[] domains = name_mail[1].split(".");
            if(domains.length != 2){
                continue;
            }
            if(!domains[1].equals("com") && !domains[1].equals("net") && !domains[1].equals("org")){
                continue;
            }
            if(!domains[0].matches(alphabet_lower)){
                continue;
            }
            if(!name_mail[0].matches(names)){
                continue;
            }
            answer++;
        }
        return answer;
    }
}
