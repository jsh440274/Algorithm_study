import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    //
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> al = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
//            if (s.equals("0")) break;
            al.add(line);
        }

        if (al.size() < 1) {
            return;
        }

        Collections.sort(al);
        double index = 1;

        for (int i = 1; i < al.size(); i++) {
            if (al.get(i).equals(al.get(i - 1))) {
                index++;
            } else {
                index = 1;
            }
        }
//        double ans = Math.round(index * 1000000 / al.size()) / 10000.0;
//        System.out.println(al.get(i - 1) + " " + ans);
//        System.out.println(al.get(al.size() - 1) + " " + Math.round(index * 10000 / al.size()) / 10000);
    }
}

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Collections;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        ArrayList<String> al = new ArrayList<>();
//        String line;
//        while ((line = br.readLine()) != null) {
////            if (s.equals("0")) break;
//            al.add(line);
//        }
//
//        if (al.size() < 1) {
//            return;
//        }
//
//        Collections.sort(al);
//        double index = 1;
//
//        for (int i = 1; i < al.size(); i++) {
//            if (al.get(i).equals(al.get(i - 1))) {
//                index++;
//            } else {
//                double ans = Math.round(index * 1000000 / al.size()) / 10000.0;
//                System.out.println(al.get(i - 1) + " " + ans);
//                index = 1;
//            }
//        }
//        System.out.println(al.get(al.size() - 1) + " " + Math.round(index * 10000 / al.size()) / 10000);
//
//    }
//}
