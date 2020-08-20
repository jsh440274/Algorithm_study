//import java.io.*;
//import java.security.Key;
//import java.util.*;
//
//public class no2 {
//    public static void main(String[] args) {
//        Queue queue = new LinkedList();
//        HashMap<Integer, Integer> frequency = new HashMap();
//        Scanner sc = new Scanner(System.in);
//        int lines = sc.nextInt();
//        for (int i = 0; i < lines; i++) {
//            String order = sc.next();
//            if (order.equals("enqueue")) {
//                int num = sc.nextInt();
//                queue.add(num);
//                if (frequency.containsKey(num)) {
//                    frequency.put(num, frequency.get(num) + 1);
//                } else {
//                    frequency.put(num, 1);
//                }
//            } else {
//                if (queue.isEmpty()) {
//                    System.out.print(-1 + " ");
//                } else {
//                    Iterator<Integer> it = frequency.keySet().iterator();
//                    int key = it.next();
//                    int max = frequency.get(key);
//                    while (it.hasNext()) {
//                        Integer k = it.next();
//                        Integer val = frequency.get(k);
//                        if (val > max) {
//                            max = val;
//                            key = k;
//                        }
//                    }
//                    queue.remove(key);
//                    frequency.put(key, frequency.get(key) - 1);
//                    System.out.println(key + " ");
//                }
//            }
//        }
//    }
//}
