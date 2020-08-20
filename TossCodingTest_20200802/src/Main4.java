import java.io.*;
import java.util.*;

public class Main4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line);
        HashMap<String, Integer> costMap = new HashMap<>();
        HashMap<String, Integer> freaquencyMap = new HashMap<>();
        for (int m = 0; m < n; m++) {
            line = br.readLine();
            String[] lines = line.split(",");
            String name = lines[0];
            int cost = Integer.parseInt(lines[1]);
            int temp1 = costMap.getOrDefault(name, 0);
            costMap.put(name, temp1 + cost);
            int temp2 = freaquencyMap.getOrDefault(name, 0);
            freaquencyMap.put(name, temp2 + 1);
        }
        Set<String> costkeys = costMap.keySet();
        Set<String> freaquencykeys = freaquencyMap.keySet();

        int maxcost = 0;
        int maxfreq = 0;

        ArrayList<String> costvals = new ArrayList<>();
        ArrayList<String> freaquencyvals = new ArrayList<>();

        for (String key : costkeys) {
            int val = costMap.get(key);
            if (val >= maxcost) {
                if (val > maxcost) {
                    costvals = new ArrayList<>();
                }
                maxcost = val;
                costvals.add(key);
            }
        }
        for (String key : freaquencykeys) {
            int val = freaquencyMap.get(key);
            if (val >= maxfreq) {
                if (val > maxfreq) {
                    freaquencyvals = new ArrayList<>();
                }
                maxfreq = val;
                freaquencyvals.add(key);
            }
        }

        Comparator<String> com = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.toLowerCase().compareTo(o2.toLowerCase());
            }
        };
        Collections.sort(costvals, com);
        Collections.sort(freaquencyvals, com);

        StringBuffer sb1 = new StringBuffer();
        sb1.append(costvals.get(0));
        for (int i = 1; i < costvals.size(); i++) {
            sb1.append(",");
            sb1.append(costvals.get(i));
        }
        StringBuffer sb2 = new StringBuffer();
        sb2.append(freaquencyvals.get(0));
        for (int i = 1; i < freaquencyvals.size(); i++) {
            sb2.append(",");
            sb2.append(freaquencyvals.get(i));
        }

        System.out.println(sb1.toString());
        System.out.println(sb2.toString());

    }
}
