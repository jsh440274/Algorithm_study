//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class no4 {
//    public static int far_distance(String seat) {
//        ArrayList<Integer> indexes = new ArrayList();
//        int start = 0;
//        float distance = 0;
//        while (start < seat.length()) {
//            int one_index = seat.indexOf('1', start + 1);
//            if (one_index == -1) break;
//            start = one_index;
//            indexes.add(one_index);
//        }
//        for (int i = indexes.size()-1; i > 0; i--) {
//            float temp_distance = indexes.get(i) - indexes.get(i - 1);
//            if(temp_distance > distance){
//                distance = temp_distance;
//            }
//        }
//        return Math.round(distance/2);
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//
//        String seat = "";
//
//        for (int i = 0; i < a; i++) {
//            seat += sc.nextInt();
//        }
//
//        System.out.println(far_distance(seat));
//    }
//}
