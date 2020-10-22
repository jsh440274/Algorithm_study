import java.util.*;

class Solution6 {
    public String[] solution(String[] companies, String[] applicants) {
        String[] answer = new String[companies.length];
        HashMap<Character, company> companymap = new HashMap<>();
        HashMap<Character, ArrayList<Character>> hiring = new HashMap<>();
        HashMap<Character, applicant> applicantmap = new HashMap<>();

        for (int i = 0; i < companies.length; i++) {
            String[] c = companies[i].split(" ");
            company temp = new company(c[0], c[1], c[2]);
            companymap.put(temp.name, temp);
        }

        for (int i = 0; i < applicants.length; i++) {
            String[] a = applicants[i].split(" ");
            applicant temp = new applicant(a[0], a[1], a[2]);
            applicantmap.put(temp.name, temp);
        }

        int index = 0;
        int loop = applicantmap.size();
        while (loop != 0) {
            Set<Character> ketset = applicantmap.keySet();
            //지원자들 먼저 다 지원함.
            //hiring에 리스트로 넣은뒤
            for (char key : ketset) {
                applicant temp = applicantmap.get(key);
                if (index >= temp.wantcompany.length) {
                    loop--;
                    continue;
                } else {
                    char cname = temp.wantcompany[index];
                    ArrayList<Character> t = hiring.getOrDefault(cname, new ArrayList<>());
                    t.add(temp.name);
                    hiring.put(cname, t);
                }
            }

            //회사쪽에서 고용.
            ketset = hiring.keySet();
            for (char key : ketset) {
                company company = companymap.get(key);
                ArrayList<Character> applicantname = hiring.get(key);
                char[] temp = company.order;
                for (int i = 0; i < temp.length; i++) {
                    if (applicantname.contains(temp[i]) && company.hired.size() < company.maxhire) {
                        company.hired.add(temp[i]);
                    }
                }
            }
            index++;
        }

        ArrayList<String> retal = new ArrayList<>();

        Set<Character> keyset = companymap.keySet();
        for (char key : keyset) {
            StringBuffer sb = new StringBuffer();
            company temp = companymap.get(key);
            sb.append(key);
            sb.append("_");
            Collections.sort(temp.hired);
            for (int i = 0; i < temp.hired.size(); i++) {
                sb.append(temp.hired.get(i));
            }
        }

        Collections.sort(retal, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.charAt(0) > o2.charAt(0) ? 1 : -1;
            }
        });

        for (int i = 0; i < retal.size(); i++) {
            answer[i] = retal.get(i);
        }
        return answer;
    }

    public class company {
        char name;
        char[] order;
        ArrayList<Character> hired = new ArrayList<>();
        int maxhire;

        public company(String name, String order, String maxhire) {
            this.name = name.charAt(0);
            this.order = order.toCharArray();
            this.maxhire = Integer.parseInt(maxhire);
        }
    }

    public class applicant {
        char name;
        char[] wantcompany;
        boolean ending = false;

        public applicant(String name, String wantcompany, String companynum) {
            this.name = name.charAt(0);
            this.wantcompany = wantcompany.substring(0, Integer.parseInt(companynum)).toCharArray();
        }
    }
}